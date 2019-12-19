
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tienanh
 */
public class App extends javax.swing.JFrame {

    private final ArrayList<ThietBi> arr_tb;
    private final ArrayList<PhongHoc> arr_ph;
    private final ArrayList<QLTB> arr_qltb;
    private DefaultTableModel model1;
    private DefaultTableModel model2;
    private DefaultTableModel model3;
    private final JTableHeader th;
    private ArrayList<QLTB> arr_search_table;
    private DefaultTableModel model4;

    public App() {
        arr_tb = new ArrayList<ThietBi>();
        arr_ph = new ArrayList<PhongHoc>();
        arr_qltb = new ArrayList<QLTB>();
        initComponents();
        String data[] = {"Nhập khẩu", "Nội địa", "Liên doanh"};
        for (String item : data) cb_xx.addItem(item);
        String data1[] = {"Mới", "Cũ"};
        for (String item : data1) cb_status.addItem(item);
        try {
            Scanner sc = new Scanner(new File("PH.TXT"));
            while (sc.hasNextLine()) {
                PhongHoc tmp = new PhongHoc(Integer.parseInt(sc.nextLine()), sc.nextLine(), Integer.parseInt(sc.nextLine()));
                arr_ph.add(tmp);
                cb_ph.addItem(tmp);
            }
            sc = new Scanner(new File("TB.TXT"));
            while (sc.hasNextLine()) {
                ThietBi tmp = new ThietBi(Integer.parseInt(sc.nextLine()), sc.nextLine(), sc.nextLine(), sc.nextLine());
                arr_tb.add(tmp);
                cb_tb.addItem(tmp);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(new File("QLTB.TXT")));
            while (true){
                QLTB tmp = (QLTB)is.readObject();
                if ( tmp.getPh() != null) arr_qltb.add(tmp);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("If QLTB.TXT not exsit => Create");
            try {
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("QLTB.TXT")));
                os.writeObject(new QLTB());
                os.close();
            } catch (FileNotFoundException ex1) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (IOException ex1) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (IOException ex) {
            System.out.println("END OF FILE => STOP LOOP");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        th = jTable3.getTableHeader();
        th.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (th.columnAtPoint(e.getPoint()) == 0){
                    arr_qltb.sort(new Comparator<QLTB>(){
                        @Override
                        public int compare(QLTB o1, QLTB o2) {
                            return o1.getPh().getName().compareTo(o2.getPh().getName());
                        }
                    });
                }
                else if (th.columnAtPoint(e.getPoint()) == 1){
                    arr_qltb.sort(new Comparator<QLTB>(){
                        @Override
                        public int compare(QLTB o1, QLTB o2) {
                            return o1.getTb().getName().compareTo(o2.getTb().getName());
                        }
                    });
                }
                else if (th.columnAtPoint(e.getPoint()) == 2){
                    arr_qltb.sort(new Comparator<QLTB>(){
                        @Override
                        public int compare(QLTB o1, QLTB o2) {
                            return o1.status.compareTo(o2.getStatus()) ;
                        }
                    });
                }
                else if (th.columnAtPoint(e.getPoint()) == 3){
                    arr_qltb.sort(new Comparator<QLTB>(){
                        @Override
                        public int compare(QLTB o1, QLTB o2) {
                            return o1.getSl() > o2.getSl() ? 1 : -1;
                        }
                    });
                }
                rerender();
            }
            
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_name = new javax.swing.JTextField();
        tf_soghe = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_nameTB = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        tf_year = new javax.swing.JTextField();
        cb_xx = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        cb_ph = new javax.swing.JComboBox<>();
        cb_status = new javax.swing.JComboBox<>();
        cb_tb = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tf_sl = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        tf_keyword = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Thiết Bị Phòng Hoc");

        jLabel1.setText("Tên Phòng  học");

        jLabel2.setText("Số ghế");

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Display ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Phòng Học", "Tên Phòng Học", "Số ghế"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(78, 78, 78)
                                .addComponent(tf_soghe))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(tf_name)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(37, 37, 37))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_soghe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Phòng Học", jPanel1);

        jLabel3.setText("Tên Thiết bị");

        jLabel4.setText("Xuất xứ");

        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Display ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Thiết Bị", "Tên Thiết Bị", "Xuất Xứ", "Năm Sản Xuất"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel5.setText("Năm sản xuất");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_nameTB)
                            .addComponent(tf_year)
                            .addComponent(cb_xx, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_nameTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cb_xx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thiết Bị", jPanel2);

        jLabel6.setText("Phòng học");

        jLabel7.setText("Thiết Bị");

        jButton5.setText("Save");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Display ");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Phòng Học", "Thiết Bị", "Số lượng", "Tình tr"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jLabel8.setText("Tình Trạng");

        jLabel9.setText("*Click headerTable to sort ");

        jLabel10.setText("Số Lượng");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6)
                                .addGap(26, 26, 26))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_status, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_ph, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_tb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_sl))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cb_ph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_tb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_sl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("QLTB", jPanel3);

        jLabel11.setText("Keyword");

        tf_keyword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_keywordActionPerformed(evt);
            }
        });
        tf_keyword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_keywordKeyPressed(evt);
            }
        });

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Phòng Học", "Thiết Bị", "Số lượng", "Tình tr"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_keyword)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tf_keyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Search", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (tf_name.getText().equals("") || tf_soghe.getText().equals("")) {
                throw new MyException(1);
            }
            
            String name = tf_name.getText();
            int soghe = Integer.parseInt(tf_soghe.getText());
            
            if (soghe < 0) throw new MyException(2);
            
            PhongHoc tmp = new PhongHoc(arr_ph.size() + 10000, name, soghe);
            tmp.save();
            arr_ph.add(tmp);
            JOptionPane.showMessageDialog(null, "Saved");
        } catch (MyException ex) {
            if ( ex.getId() == 1) JOptionPane.showMessageDialog(null, "Các trường không được để trống");
            else if ( ex.getId() == 2) JOptionPane.showMessageDialog(null, "Số ghế phải > 0");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        model1 = new DefaultTableModel();
        model1= (DefaultTableModel)jTable1.getModel();
        
        for (int i = model1.getRowCount() - 1; i >= 0 ; i--) 
            model1.removeRow(0);
        
        for (PhongHoc item : arr_ph){
            Object tmp[] = {item.getMph(),item.getName(),item.getSoghe()};
            model1.addRow(tmp);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            if (tf_nameTB.getText().equals("") || tf_year.getText().equals("")) {
                throw new MyException(1);
            }
            
            String name = tf_nameTB.getText();
            String year = tf_year.getText();
            String xx = cb_xx.getSelectedItem() +"";
            
            if (!year.matches("^[1-9][0-9]{3}$")) throw new MyException(2);
            
            ThietBi tmp = new ThietBi(arr_tb.size() + 1000, name, xx, year);
            tmp.save();
            arr_tb.add(tmp);
            JOptionPane.showMessageDialog(null, "Saved");
        } catch (MyException ex) {
            if ( ex.getId() == 1) JOptionPane.showMessageDialog(null, "Các trường không được để trống");
            else if ( ex.getId() == 2) JOptionPane.showMessageDialog(null, "Năm phải có đinh dang gồm 4 chữ số, số đầu khác 0");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        model2 = new DefaultTableModel();
        model2= (DefaultTableModel)jTable2.getModel();
        
        for (int i = model2.getRowCount() - 1; i >= 0 ; i--) 
            model2.removeRow(0);
        
        for (ThietBi item : arr_tb){
            Object tmp[] = {item.getMtb(),item.getName(),item.getXx(),item.getYear()};
            model2.addRow(tmp);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            if (tf_sl.getText().equals("") ) {
                throw new MyException(1);
            }
            int sl = Integer.parseInt(tf_sl.getText());
            if ( sl < 0) throw new MyException(2);
            PhongHoc ph = (PhongHoc)cb_ph.getSelectedItem();
            ThietBi tb = (ThietBi)cb_tb.getSelectedItem();
            String status = "" +cb_status.getSelectedItem();
            
            for (QLTB item : arr_qltb){
                if (item.getPh().equals(ph) && item.getTb().equals(tb)){
                    throw new MyException(3);
                }
            }
            
            QLTB tmp = new QLTB(ph, tb, status, sl);
            tmp.save();
            arr_qltb.add(tmp);
            JOptionPane.showMessageDialog(null, "Saved");
        } catch (MyException ex) {
            if ( ex.getId() == 1) JOptionPane.showMessageDialog(null, "Các trường không được để trống");
            else if ( ex.getId() == 2) JOptionPane.showMessageDialog(null, "SL > 0");
            else if ( ex.getId() == 3) JOptionPane.showMessageDialog(null, "Phòng đã được thêm thiết bị");
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Lỗi format");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        rerender();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tf_keywordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_keywordActionPerformed
        
    }//GEN-LAST:event_tf_keywordActionPerformed

    private void tf_keywordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_keywordKeyPressed
        String keyword = tf_keyword.getText();
        System.out.println(keyword);
        
        String regex = ".*"+keyword+".*";
        arr_search_table = new ArrayList<QLTB>();
        for ( QLTB item : arr_qltb){
            if ( item.getPh().getName().matches(regex) || item.getTb().getName().matches(regex)){
                arr_search_table.add(item);
            }
        }
        
        model4 = new DefaultTableModel();
        model4= (DefaultTableModel)jTable4.getModel();
        
        for (int i = model4.getRowCount() - 1; i >= 0 ; i--) 
            model4.removeRow(0);
        
        for (QLTB item : arr_search_table){
            Object tmp[] = {item.getPh(),item.getTb(),item.getStatus(),item.getSl()};
            model4.addRow(tmp);
        }
    }//GEN-LAST:event_tf_keywordKeyPressed

    private void rerender(){
        model3 = new DefaultTableModel();
        model3= (DefaultTableModel)jTable3.getModel();
        
        for (int i = model3.getRowCount() - 1; i >= 0 ; i--) 
            model3.removeRow(0);
        
        for (QLTB item : arr_qltb){
            Object tmp[] = {item.getPh(),item.getTb(),item.getStatus(),item.getSl()};
            model3.addRow(tmp);
        }
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<PhongHoc> cb_ph;
    private javax.swing.JComboBox<String> cb_status;
    private javax.swing.JComboBox<ThietBi> cb_tb;
    private javax.swing.JComboBox<String> cb_xx;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField tf_keyword;
    private javax.swing.JTextField tf_name;
    private javax.swing.JTextField tf_nameTB;
    private javax.swing.JTextField tf_sl;
    private javax.swing.JTextField tf_soghe;
    private javax.swing.JTextField tf_year;
    // End of variables declaration//GEN-END:variables
}
