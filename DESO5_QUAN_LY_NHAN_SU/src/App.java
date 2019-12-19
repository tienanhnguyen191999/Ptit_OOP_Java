
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

    private final ArrayList<NhanVien> arr_nv;
    private final ArrayList<PhongBan> arr_pb;
    private final ArrayList<QLNS> arr_qlns;
    private DefaultTableModel model1;
    private DefaultTableModel model2;
    private DefaultTableModel model3;
    private final JTableHeader th;
    private DefaultTableModel model4;

    public App() {
        arr_nv = new ArrayList<NhanVien>();
        arr_pb = new ArrayList<PhongBan>();
        arr_qlns = new ArrayList<QLNS>();
        initComponents();
        int data[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int item : data) {
            cb_bl.addItem(item + "");
        }

        try {
            Scanner sc = new Scanner(new File("NV.TXT"));
            while (sc.hasNextLine()) {
                NhanVien tmp = new NhanVien(Integer.parseInt(sc.nextLine()), sc.nextLine(), sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()));
                arr_nv.add(tmp);
                cb_nv.addItem(tmp);
                cb_nv1.addItem(tmp);
            }
            sc = new Scanner(new File("PB.TXT"));
            while (sc.hasNextLine()) {
                PhongBan tmp = new PhongBan(Integer.parseInt(sc.nextLine()), sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()));
                arr_pb.add(tmp);
                cb_pb.addItem(tmp);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(new File("QLNS.TXT")));
            while (true){
                QLNS tmp = (QLNS)is.readObject();
                if ( tmp.getNv() != null) arr_qlns.add(tmp);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Create File 'QLNS.txt' IF Not Exsit");
            try {
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("QLNS.TXT")));
                os.writeObject(new QLNS());
                os.close();
            } catch (FileNotFoundException ex1) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (IOException ex1) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex1);
            }
            
        } catch (IOException ex) {
            System.out.println("END OF FILE");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        th = jTable3.getTableHeader();
        th.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if ( th.columnAtPoint(e.getPoint()) == 0){
                    arr_qlns.sort(new Comparator<QLNS>(){
                        @Override
                        public int compare(QLNS o1, QLNS o2) {
                            return o1.getNv().getName().compareTo(o2.getNv().getName());
                        }
                    });
                    rerender();
                }
                else if ( th.columnAtPoint(e.getPoint()) == 1){
                    arr_qlns.sort(new Comparator<QLNS>(){
                        @Override
                        public int compare(QLNS o1, QLNS o2) {
                            return o1.getPb().getName().compareTo(o2.getPb().getName());
                        }
                    });
                    rerender();
                }
                else if ( th.columnAtPoint(e.getPoint()) == 2){
                    arr_qlns.sort(new Comparator<QLNS>(){
                        @Override
                        public int compare(QLNS o1, QLNS o2) {
                            return o1.getSoNgay() > o2.getSoNgay() ? 1 : -1;
                        }
                    });
                    rerender();
                }
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_sdt = new javax.swing.JTextField();
        tf_nameNV = new javax.swing.JTextField();
        tf_add = new javax.swing.JTextField();
        cb_bl = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tf_hscv = new javax.swing.JTextField();
        tf_namePB = new javax.swing.JTextField();
        tf_des = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tf_nc = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        cb_nv = new javax.swing.JComboBox<>();
        cb_pb = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        cb_nv1 = new javax.swing.JComboBox<>();
        lb_total = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý nhân sự");

        jLabel1.setText("Tên Nhân Viên");

        jLabel2.setText("Địa ch ỉ");

        jLabel3.setText("SDT");

        jLabel4.setText("Bậc Lương");

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Display");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Địa chỉ", "Số điện thoại", "Bậc Lương"
            }
        ));
        jScrollPane8.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(3).setHeaderValue("HSCV");
            jTable1.getColumnModel().getColumn(4).setHeaderValue("Bậc Lương");
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(31, 31, 31)
                                .addComponent(tf_nameNV))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(57, 57, 57)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_sdt, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tf_add)
                                    .addComponent(cb_bl, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(41, 41, 41))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_nameNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cb_bl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Nhân Viên", jPanel1);

        jLabel5.setText("Tên Phòng Ban");

        jLabel6.setText("Mô tả");

        jLabel7.setText("HSCV");

        tf_namePB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_namePBActionPerformed(evt);
            }
        });

        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Display");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Phòng Ban", "Tên Phòng Ban", "Mô Tả", "HSCV"
            }
        ));
        jScrollPane7.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(3).setHeaderValue("HSCV");
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_namePB)
                            .addComponent(tf_hscv)
                            .addComponent(tf_des, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(40, 40, 40))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_namePB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tf_des, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tf_hscv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("PhongBan", jPanel2);

        jLabel8.setText("Nhân Viên");

        jLabel9.setText("Phòng Ban");

        jLabel10.setText("Ngày Công");

        jButton5.setText("Save");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Display");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel12.setText("*Click to tableHeader to sort");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nhân Viên", "Phòng Ban", "Ngày Công"
            }
        ));
        jScrollPane6.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_nc)
                            .addComponent(cb_pb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_nv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 284, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addGap(40, 40, 40))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cb_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cb_pb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tf_nc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("QLNS", jPanel3);

        jLabel11.setText("Nhân Viên");

        cb_nv1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_nv1ActionPerformed(evt);
            }
        });

        lb_total.setText("Tổng Cộng: ");

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Phòng", "Tên Phòng", "Mô tả", "Hệ Số Công V", "Ngày Công", "Tổng"
            }
        ));
        jScrollPane5.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(257, Short.MAX_VALUE)
                .addComponent(lb_total)
                .addGap(117, 117, 117))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(cb_nv1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cb_nv1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(lb_total)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bảng kê", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (tf_add.getText().equals("") || tf_nameNV.getText().equals("") || tf_sdt.getText().equals("")) {
                throw new MyException(1);
            }
            
            String name = tf_nameNV.getText();
            String sdt = tf_sdt.getText();
            String add = tf_add.getText();
            int bl = Integer.parseInt(cb_bl.getSelectedItem() +"");
            if ( !sdt.matches("^0\\d{8,9}$")) throw new MyException(2);
            
            NhanVien tmp = new NhanVien(arr_nv.size() + 1000, name, add, sdt, bl);
            tmp.save();
            arr_nv.add(tmp);
            JOptionPane.showMessageDialog(null, "Saved");
        } catch (MyException ex) {
            if ( ex.getId() == 1) JOptionPane.showMessageDialog(null, "Không được để trống các trường");
            else if ( ex.getId() == 2) JOptionPane.showMessageDialog(null, "SDT phải bắt đầu bằng 0 và có 9,10 chữ số");
        } catch( NumberFormatException ex ){
            JOptionPane.showMessageDialog(null, "Lỗi format");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        model1 = new DefaultTableModel();
        model1 = (DefaultTableModel)jTable1.getModel();
        
        for (int i = model1.getRowCount() - 1 ; i >= 0 ; i--)
            model1.removeRow(0);
        
        for ( NhanVien item : arr_nv){
            Object tmp[] = {item.getMnv(),item.getName(),item.getAdd(),item.getSdt(),item.getBl()};
            model1.addRow(tmp);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            if (tf_des.getText().equals("") || tf_namePB.getText().equals("") || tf_hscv.getText().equals("")) {
                throw new MyException(1);
            }
            
            String name = tf_namePB.getText();
            String des = tf_des.getText();
            Double hscv = Double.parseDouble(tf_hscv.getText());
            
            if ( hscv < 1 || hscv > 20) throw new MyException(2);
            
            PhongBan tmp = new PhongBan(arr_pb.size() + 100, name, des, hscv);
            tmp.save();
            arr_pb.add(tmp);
            JOptionPane.showMessageDialog(null, "Saved");
        } catch (MyException ex) {
            if ( ex.getId() == 1) JOptionPane.showMessageDialog(null, "Không được để trống các trường");
            else if ( ex.getId() == 2) JOptionPane.showMessageDialog(null, "HSCV phải là số thực [1,20]");
        } catch( NumberFormatException ex ){
            JOptionPane.showMessageDialog(null, "Lỗi format");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        model2 = new DefaultTableModel();
        model2 = (DefaultTableModel)jTable2.getModel();
        
        for (int i = model2.getRowCount() - 1 ; i >= 0 ; i--)
            model2.removeRow(0);
        
        for ( PhongBan item : arr_pb){
            Object tmp[] = {item.getMp(),item.getName(),item.getDes(),item.getHscv()};
            model2.addRow(tmp);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tf_namePBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_namePBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_namePBActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            if ( tf_nc.getText().equals("")) {
                throw new MyException(1);
            }
            
            Integer nc = Integer.parseInt(tf_nc.getText());
            if ( nc < 0) throw new MyException(2);
            
            NhanVien nv = (NhanVien)cb_nv.getSelectedItem();
            PhongBan pb = (PhongBan)cb_pb.getSelectedItem();
            
            for (QLNS item : arr_qlns){
                if ( item.getNv().equals(nv)){
                    throw new MyException(3); 
                }
            }
            
            QLNS tmp = new QLNS(pb, nv, nc);
            tmp.save();
            arr_qlns.add(tmp);
            JOptionPane.showMessageDialog(null, "Saved");
        } catch (MyException ex) {
            if ( ex.getId() == 1) JOptionPane.showMessageDialog(null, "Không được để trống các trường");
            else if ( ex.getId() == 2) JOptionPane.showMessageDialog(null, "Ngày Công không được âm");
            else if ( ex.getId() == 3) JOptionPane.showMessageDialog(null, "Nhân Viên đã được nhập");
        } catch( NumberFormatException ex ){
            JOptionPane.showMessageDialog(null, "Lỗi format");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        rerender();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void cb_nv1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_nv1ActionPerformed
        NhanVien nv = (NhanVien)cb_nv1.getSelectedItem();
        ArrayList<QLNS> arr_bangke = new ArrayList<QLNS>();
        for (QLNS tmp : arr_qlns){
            if ( tmp.getNv().equals(nv)){
                arr_bangke.add(tmp);
            }
        }
        
        model4 = new DefaultTableModel();
        model4 = (DefaultTableModel)jTable4.getModel();
        
        for (int i = model4.getRowCount() - 1 ; i >= 0 ; i--)
            model4.removeRow(0);
        
        double s = 0;
        for ( QLNS item : arr_bangke){
            Double total = 1450000.0 * (2 + item.getNv().getBl()/3.0) * item.getPb().getHscv() * (item.getSoNgay()/22.0);
            s+= total;
            Object tmp[] = {item.getPb().getMp(),item.getPb().getName(),item.getPb().getDes(),item.getPb().getHscv(),item.getSoNgay(),total};
            model4.addRow(tmp);
        }
        
        lb_total.setText("Tổng cộng: " + s);
    }//GEN-LAST:event_cb_nv1ActionPerformed

    private void rerender(){
        model3 = new DefaultTableModel();
        model3 = (DefaultTableModel)jTable3.getModel();
        
        for (int i = model3.getRowCount() - 1 ; i >= 0 ; i--)
            model3.removeRow(0);
        
        for ( QLNS item : arr_qlns){
            Object tmp[] = {item.getNv(),item.getPb(),item.getSoNgay()};
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
    private javax.swing.JComboBox<String> cb_bl;
    private javax.swing.JComboBox<NhanVien> cb_nv;
    private javax.swing.JComboBox<NhanVien> cb_nv1;
    private javax.swing.JComboBox<PhongBan> cb_pb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JLabel lb_total;
    private javax.swing.JTextField tf_add;
    private javax.swing.JTextField tf_des;
    private javax.swing.JTextField tf_hscv;
    private javax.swing.JTextField tf_nameNV;
    private javax.swing.JTextField tf_namePB;
    private javax.swing.JTextField tf_nc;
    private javax.swing.JTextField tf_sdt;
    // End of variables declaration//GEN-END:variables
}
