
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
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

    private final ArrayList<MatHang> arr_mh;
    private final ArrayList<NhanVien> arr_nv;
    private final ArrayList<DSBH> arr_dsbh;
    private DefaultTableModel model1;
    private DefaultTableModel model2;
    private DefaultTableModel model3;
    private final JTableHeader th;
    private ArrayList<DSBH> arr_bangke;
    private DefaultTableModel model4;

    
    public App() {
        arr_mh = new ArrayList<MatHang>();
        arr_nv = new ArrayList<NhanVien>();
        arr_dsbh = new ArrayList<DSBH>();
        initComponents();
        String data[] = {"Điện tử", "Điện lạnh", "Máy tính", "Thiết bị văn phòng"};
        for (String item : data)  cb_cate.addItem(item);
        
        try {
            Scanner sc = new Scanner(new File("MH.TXT"));
            while (sc.hasNextLine()){
                MatHang tmp = new MatHang(Integer.parseInt(sc.nextLine()),sc.nextLine(),sc.nextLine(),Double.parseDouble(sc.nextLine()),Integer.parseInt(sc.nextLine()));
                arr_mh.add(tmp);
                cb_mh.addItem(tmp);
            }
            sc = new Scanner(new File("NV.TXT"));
            while (sc.hasNextLine()){
                NhanVien tmp = new NhanVien(Integer.parseInt(sc.nextLine()),sc.nextLine(),sc.nextLine(),sc.nextLine());
                arr_nv.add(tmp);
                cb_nv.addItem(tmp);
                cb_nv1.addItem(tmp);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(new File("QLBH.TXT")));
            while (true){
                DSBH tmp = (DSBH)is.readObject();
                if ( tmp.getMh() != null) arr_dsbh.add(tmp);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("IF NOT EXSIT => CREATE");
            try {
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("QLBH.TXT")));
                os.writeObject(new DSBH());
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
                    arr_dsbh.sort(new Comparator<DSBH>(){
                        @Override
                        public int compare(DSBH o1, DSBH o2) {
                            return o1.getNv().getName().compareTo(o2.getNv().getName());
                        }   
                    });
                }
                else if ( th.columnAtPoint(e.getPoint()) == 1){
                    arr_dsbh.sort(new Comparator<DSBH>(){
                        @Override
                        public int compare(DSBH o1, DSBH o2) {
                            return o1.getMh().getCate().compareTo(o2.getMh().getCate());
                        }   
                    });
                    
                }
                else if ( th.columnAtPoint(e.getPoint()) == 2){
                    arr_dsbh.sort(new Comparator<DSBH>(){
                        @Override
                        public int compare(DSBH o1, DSBH o2) {
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cb_cate = new javax.swing.JComboBox<>();
        tf_sl = new javax.swing.JTextField();
        tf_nameMH = new javax.swing.JTextField();
        tf_cost = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tf_nameNV = new javax.swing.JTextField();
        tf_add = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        tf_sdt = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cb_mh = new javax.swing.JComboBox<>();
        tf_sl1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cb_nv = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cb_nv1 = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        lb_total = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QLBH Siêu Thị");

        jLabel1.setText("Tên Hàng");

        jLabel2.setText("NHóm hàng");

        jLabel3.setText("Giá bán");

        jLabel4.setText("Số lượng");

        tf_cost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_costActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hàng", "Tên Hàng", "Nhóm Hàng", "Giá Bán", "Số Lượng"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Giá Bán");
            jTable1.getColumnModel().getColumn(4).setHeaderValue("Số Lượng");
        }

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 275, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(44, 44, 44))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(33, 33, 33)
                                .addComponent(tf_nameMH))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_sl)
                                    .addComponent(tf_cost)
                                    .addComponent(cb_cate, 0, 317, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_nameMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cb_cate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_cost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_sl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Mặt Hàng", jPanel1);

        jLabel5.setText("Tên Nhân Viên");

        jLabel6.setText("Địa Chỉ");

        jLabel7.setText("SDT");

        tf_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_addActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Địa CHỉ", "SDT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(3).setHeaderValue("Giá Bán");
        }

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_nameNV, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                            .addComponent(tf_add)
                            .addComponent(tf_sdt))
                        .addGap(67, 67, 67))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(44, 44, 44))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_nameNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tf_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tf_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Nhân Viên", jPanel2);

        jLabel8.setText("Nhân Viên");

        jLabel9.setText("Mặt Hàng");

        jLabel10.setText("Số Lượng");

        tf_sl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_sl1ActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nhân Viên", "Mặt Hàng", "Số Lượng"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

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

        jLabel11.setText("* Click to headerTable to sort ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton5)
                                        .addComponent(jLabel10)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tf_sl1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cb_mh, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cb_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(276, 276, 276)
                                        .addComponent(jButton6))))
                            .addComponent(jLabel11))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cb_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cb_mh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tf_sl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("QLBH", jPanel3);

        jLabel12.setText("Nhân Viên");

        cb_nv1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_nv1ActionPerformed(evt);
            }
        });

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Mặt Hàng", "Tên Mặt Hàng", "Đơn Giá", "Đã Bán", "Tổng"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        lb_total.setText("Tổng cộng: ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(49, 49, 49)
                        .addComponent(cb_nv1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(lb_total)
                                .addGap(140, 140, 140))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cb_nv1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lb_total)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bảng kê", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tf_costActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_costActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_costActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if ( tf_cost.getText().equals("") || tf_nameMH.getText().equals("") || tf_sl.getText().equals("")) 
            throw new MyException(1);
            
            String name = tf_nameMH.getText();
            String cate = cb_cate.getSelectedItem() + "";
            Double cost = Double.parseDouble(tf_cost.getText());
            int sl = Integer.parseInt(tf_sl.getText());
            
            if (cost < 0) throw new MyException(2);
            if (sl < 0) throw new MyException(3);
            
            MatHang tmp = new MatHang(arr_mh.size() + 1000, name, cate, cost, sl);
            tmp.save();
            arr_mh.add(tmp);
            JOptionPane.showMessageDialog(null, "Đã Lưu");
        } catch (MyException ex) {
            if ( ex.getId() == 1) JOptionPane.showMessageDialog(null, "Không được để trống các trường");
            if ( ex.getId() == 2) JOptionPane.showMessageDialog(null, "Giá Không được âm");
            if ( ex.getId() == 3) JOptionPane.showMessageDialog(null, "Số lượng không được âm");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        model1=  new DefaultTableModel();
        model1 = (DefaultTableModel)jTable1.getModel();
        
        for (int i = model1.getRowCount() - 1;  i >= 0 ; i--)
            model1.removeRow(0);
        
        for (MatHang item : arr_mh){
            Object tmp[] = {item.getMh(),item.getName(),item.getCate(),item.getCost(),item.getSl()};
            model1.addRow(tmp);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tf_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_addActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            if ( tf_sdt.getText().equals("") || tf_nameNV.getText().equals("") || tf_add.getText().equals("")) 
            throw new MyException(1);
            
            String name = tf_nameNV.getText();
            String sdt = tf_sdt.getText();
            String add = tf_add.getText();
          
            if (!sdt.matches("^0[0-9]{8,9}$")) throw new MyException(2);

            NhanVien tmp = new NhanVien(arr_nv.size() + 1000, name, add, sdt);
            tmp.save();
            arr_nv.add(tmp);
            JOptionPane.showMessageDialog(null, "Đã Lưu");
        } catch (MyException ex) {
            if ( ex.getId() == 1) JOptionPane.showMessageDialog(null, "Không được để trống các trường");
            if ( ex.getId() == 2) JOptionPane.showMessageDialog(null, "SDT phải bắt đầu = 0 và gồm 9-10 chữ số");            
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        model2 =  new DefaultTableModel();
        model2 = (DefaultTableModel)jTable2.getModel();
        
        for (int i = model2.getRowCount() - 1;  i >= 0 ; i--)
            model2.removeRow(0);
        
        for (NhanVien item : arr_nv){
            Object tmp[] = {item.getMnv(),item.getName(),item.getAdd(),item.getSdt()};
            model2.addRow(tmp);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void rerender(){
        model3 =  new DefaultTableModel();
        model3 = (DefaultTableModel)jTable3.getModel();
        
        for (int i = model3.getRowCount() - 1;  i >= 0 ; i--)
            model3.removeRow(0);
        
        for (DSBH item : arr_dsbh){
            Object tmp[] = {item.getNv(),item.getMh(),item.getSl()};
            model3.addRow(tmp);
        }
    }
    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        rerender();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         try {
            if (tf_sl1.getText().equals("")) 
            throw new MyException(1);
            
            int sl = Integer.parseInt(tf_sl1.getText());
            MatHang mh = (MatHang)cb_mh.getSelectedItem();
            NhanVien nv = (NhanVien)cb_nv.getSelectedItem();
            
            if (sl < 0) throw new MyException(2);
            int c = 0;
            for ( DSBH item : arr_dsbh ){
                if (item.getNv().equals(nv)){
                    c++;
                    if ( c == 10) throw new MyException(3);
                    if ( item.getMh().equals(mh)){
                        throw new MyException(4);
                    }
                }
            }
            

            DSBH tmp = new DSBH( mh, nv, sl);
            tmp.save();
            arr_dsbh.add(tmp);
            JOptionPane.showMessageDialog(null, "Đã Lưu");
        } catch (MyException ex) {
            if ( ex.getId() == 1) JOptionPane.showMessageDialog(null, "Không được để trống các trường");
            if ( ex.getId() == 2) JOptionPane.showMessageDialog(null, "Số lượng phải lớn hơn 0");            
            if ( ex.getId() == 3) JOptionPane.showMessageDialog(null, "Không được bán quá 10sp");            
            if ( ex.getId() == 4) JOptionPane.showMessageDialog(null, "Sản phẩm đã được nhập");            
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tf_sl1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_sl1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_sl1ActionPerformed

    private void cb_nv1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_nv1ActionPerformed
        NhanVien tmp = (NhanVien)cb_nv1.getSelectedItem();
        
        arr_bangke = new ArrayList<DSBH>();
        
        for (DSBH item : arr_dsbh){
            if ( item.getNv().equals(tmp)){
                arr_bangke.add(item);
            }
        }
        
        renderTable4();
       
    }//GEN-LAST:event_cb_nv1ActionPerformed

    private void  renderTable4(){
        model4 =  new DefaultTableModel();
        model4 = (DefaultTableModel)jTable4.getModel();
        
        for (int i = model4.getRowCount() - 1;  i >= 0 ; i--)
            model4.removeRow(0);
        Double s = 0.0 ;
        for (DSBH item : arr_bangke){
            Double total = item.getSl() * item.getMh().getCost();
            s+= total;
            Object tmp[] = {item.getMh().getMh(),item.getMh().getName(),item.getMh().getCost(),item.getSl(),total};
            model4.addRow(tmp);
        }
        lb_total.setText("Tổng cộng: " + s );
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
    private javax.swing.JComboBox<String> cb_cate;
    private javax.swing.JComboBox<MatHang> cb_mh;
    private javax.swing.JComboBox<NhanVien> cb_nv;
    private javax.swing.JComboBox<NhanVien> cb_nv1;
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
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JLabel lb_total;
    private javax.swing.JTextField tf_add;
    private javax.swing.JTextField tf_cost;
    private javax.swing.JTextField tf_nameMH;
    private javax.swing.JTextField tf_nameNV;
    private javax.swing.JTextField tf_sdt;
    private javax.swing.JTextField tf_sl;
    private javax.swing.JTextField tf_sl1;
    // End of variables declaration//GEN-END:variables
}
