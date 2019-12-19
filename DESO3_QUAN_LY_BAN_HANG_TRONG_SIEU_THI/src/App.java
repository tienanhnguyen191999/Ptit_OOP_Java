
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

public class App extends javax.swing.JFrame {

    private final ArrayList<MatHang> arr_mh;
    private final ArrayList<BDSMH> arr_bdsmh;
    private final ArrayList<KhachHang> arr_kh;
    private DefaultTableModel model1;
    private DefaultTableModel model2;
    private DefaultTableModel model3;
    private final JTableHeader th;
    private DefaultTableModel model4;

    public App() {
        arr_mh = new ArrayList<MatHang>();
        arr_kh = new ArrayList<KhachHang>();
        arr_bdsmh = new ArrayList<BDSMH>();
        initComponents();

        String data[] = {"Hàng thời trang", "Hàng tiêu dùng", "Hàng điện máy", "Hàng gia dụng"};
        for (String item : data) {
            cb_cate.addItem(item);
        }

        try {
            Scanner sc = new Scanner(new File("MH.TXT"));
            while (sc.hasNextLine()) {
                MatHang tmp = new MatHang(Integer.parseInt(sc.nextLine()), sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()));
                arr_mh.add(tmp);
                cb_mh.addItem(tmp);
            }

            sc = new Scanner(new File("KH.TXT"));
            while (sc.hasNextLine()) {
                KhachHang tmp = new KhachHang(Integer.parseInt(sc.nextLine()), sc.nextLine(), sc.nextLine(), sc.nextLine());
                arr_kh.add(tmp);
                cb_kh.addItem(tmp);
                cb_kh1.addItem(tmp);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            System.out.println("IN");
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(new File("QLBH.TXT")));
            System.out.println("IN");
            while(true){
                BDSMH tmp = (BDSMH)is.readObject();
                if (tmp.getKh() !=  null)
                    arr_bdsmh.add(tmp);
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            ObjectOutputStream os = null;
            try {
                os = new ObjectOutputStream(new FileOutputStream(new File("QLBH.TXT")));
                os.writeObject(new BDSMH());
                os.close();
            } catch (FileNotFoundException ex1) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (IOException ex1) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex1);
            } finally {
                try {
                    os.close();
                } catch (IOException ex1) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex1);
                }
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
                System.out.println("click ||" + th.columnAtPoint(e.getPoint()) );
                if ( th.columnAtPoint(e.getPoint()) == 0){
                    arr_bdsmh.sort(new Comparator<BDSMH>(){
                        @Override
                        public int compare(BDSMH o1, BDSMH o2) {
                            return o1.getKh().getName().compareTo(o2.getKh().getName());
                        } 
                    });
                   
                }
                else if ( th.columnAtPoint(e.getPoint()) == 1 ){
                    arr_bdsmh.sort(new Comparator<BDSMH>(){
                        @Override
                        public int compare(BDSMH o1, BDSMH o2) {
                            return o1.getMh().getName().compareTo(o2.getMh().getName());
                        } 
                    });
                   
                } else if( th.columnAtPoint(e.getPoint()) == 2 ){
                    arr_bdsmh.sort(new Comparator<BDSMH>(){
                        @Override
                        public int compare(BDSMH o1, BDSMH o2) {
                            return o1.getSl() <= o2.getSl() ? 1 : -1;
                        } 
                    });
                    
                }
                render();
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
        tf_nameMH = new javax.swing.JTextField();
        tf_cost = new javax.swing.JTextField();
        cb_cate = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_nameKH = new javax.swing.JTextField();
        tf_sdt = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        tf_add = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tf_sl = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        cb_mh = new javax.swing.JComboBox<>();
        cb_kh = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cb_kh1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        lb_total = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Bản Hàng Trong Siêu Thị");

        jLabel1.setText("Tên Hàng");

        jLabel2.setText("Nhóm hàng");

        jLabel3.setText("Giá bán");

        tf_nameMH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nameMHActionPerformed(evt);
            }
        });

        tf_cost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_costActionPerformed(evt);
            }
        });

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
                "Mã Mặt Hàng", "Tên Hàng", "Nhóm Hàng", "Giá Bán"
            }
        ));
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(3).setHeaderValue("SDT");
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_cost)
                    .addComponent(tf_nameMH)
                    .addComponent(cb_cate, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(27, 27, 27))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Mặt Hàng", jPanel1);

        jLabel4.setText("Tên Khách Hàng");

        jLabel5.setText("Địa chỉ");

        jLabel6.setText("Số điện thoại");

        tf_nameKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nameKHActionPerformed(evt);
            }
        });

        tf_sdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_sdtActionPerformed(evt);
            }
        });

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
                "Mã Khách Hàng", "Tên Khách Hàng", "Địa chỉ", "SDT"
            }
        ));
        jScrollPane4.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(3).setHeaderValue("SDT");
        }

        tf_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_addActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_sdt)
                    .addComponent(tf_nameKH)
                    .addComponent(tf_add, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(27, 27, 27))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_nameKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tf_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Khách Hàng", jPanel2);

        jLabel7.setText(" Khách Hàng");

        jLabel8.setText("Mặt Hàng");

        jLabel9.setText("Số lượng");

        tf_sl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_slActionPerformed(evt);
            }
        });

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
                "Khách Hang", "Mặt Hàng", "Số lượng"
            }
        ));
        jScrollPane5.setViewportView(jTable3);

        jLabel11.setText("* Click headerTable để sort ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_sl)
                    .addComponent(cb_mh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_kh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(27, 27, 27))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cb_kh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cb_mh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tf_sl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Lập Hoá đơn", jPanel3);

        jLabel10.setText("Khách Hàng");

        cb_kh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_kh1ActionPerformed(evt);
            }
        });

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Hàng", "Tên Hàng", "Loại Hàng", "Giá", "Số lương", "Tổng"
            }
        ));
        jScrollPane1.setViewportView(jTable4);

        lb_total.setText("Tổng hoá đơn: ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(cb_kh1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_total)
                .addGap(118, 118, 118))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cb_kh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lb_total)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hoá Đơn", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tf_nameMHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nameMHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nameMHActionPerformed

    private void tf_costActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_costActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_costActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (tf_cost.getText().equals("") || tf_nameMH.getText().equals("")) {
                throw new MyException(1);
            }

            String nameMH = tf_nameMH.getText();
            Double cost = Double.parseDouble(tf_cost.getText());
            String cate = cb_cate.getSelectedItem() + "";

            if (cost < 0) {
                throw new MyException(2);
            }

            MatHang tmp = new MatHang(arr_mh.size() + 1000, nameMH, cate, cost);
            tmp.save();
            arr_mh.add(tmp);

            JOptionPane.showMessageDialog(null, "Saved");
        } catch (MyException ex) {
            if (ex.getId() == 1) {
                JOptionPane.showMessageDialog(null, "Không được để trống các trường");
            } else if (ex.getId() == 2) {
                JOptionPane.showMessageDialog(null, "Giá phải là số thực dương");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        model1 = new DefaultTableModel();
        model1 = (DefaultTableModel) jTable1.getModel();

        for (int i = model1.getRowCount() - 1; i >= 0; i--) {
            model1.removeRow(0);
        }

        for (MatHang item : arr_mh) {
            Object tmp[] = {item.getMh(), item.getName(), item.getCate(), item.getCost()};
            model1.addRow(tmp);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tf_nameKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nameKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nameKHActionPerformed

    private void tf_sdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_sdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_sdtActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         try {
            if (tf_add.getText().equals("") || tf_nameKH.getText().equals("") || tf_sdt.getText().equals("")) {
                throw new MyException(1);
            }

            String nameKH = tf_nameKH.getText();
            String add  = tf_add.getText();
            String sdt  = tf_sdt.getText();
            if (!sdt.matches("^0[0-9]{8,9}$"))  throw new MyException(2);

            KhachHang tmp = new KhachHang(arr_kh.size() + 10000, nameKH, add, sdt);
            tmp.save();
            arr_kh.add(tmp);

            JOptionPane.showMessageDialog(null, "Saved");
        } catch (MyException ex) {
            if (ex.getId() == 1) {
                JOptionPane.showMessageDialog(null, "Không được để trống các trường");
            } else if (ex.getId() == 2) {
                JOptionPane.showMessageDialog(null, "SDT phải bắt đầu bằng 0 và dài từ 9-10 chữ số");
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        model2 = new DefaultTableModel();
        model2 = (DefaultTableModel) jTable2.getModel();

        for (int i = model2.getRowCount() - 1; i >= 0; i--) {
            model2.removeRow(0);
        }

        for (KhachHang item : arr_kh) {
            Object tmp[] = {item.getMkh(), item.getName(), item.getAdd(), item.getSdt()};
            model2.addRow(tmp);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tf_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_addActionPerformed

    private void tf_slActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_slActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_slActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            if (tf_sl.getText().equals("") ) {
                throw new MyException(1);
            }

            MatHang mh = (MatHang)cb_mh.getSelectedItem();
            KhachHang kh = (KhachHang)cb_kh.getSelectedItem();
            
            int sl  = Integer.parseInt(tf_sl.getText());
            if (sl < 0)  throw new MyException(2);

            int c =0 ;
            for ( BDSMH item : arr_bdsmh){
                if ( item.getKh().equals(kh) ){
                    c++;
                    if ( c == 10) throw new MyException(3);
                    if ( item.getMh().equals(mh)){
                        arr_bdsmh.set(arr_bdsmh.indexOf(item), item);
                        throw new MyException(4); // Update file
                    }
                }
            }
            BDSMH tmp = new BDSMH(mh,kh,sl);
            tmp.save();
            arr_bdsmh.add(tmp);
            JOptionPane.showMessageDialog(null, "Saved");
        } catch (MyException ex) {
            if (ex.getId() == 1) {
                JOptionPane.showMessageDialog(null, "Không được để trống các trường");
            } else if (ex.getId() == 2) {
                JOptionPane.showMessageDialog(null, "Số lượng phải > 0");
            }
            else if (ex.getId() == 3) {
                JOptionPane.showMessageDialog(null, "Lượng sản phẩm không được quá 10 món");
            }
            else if (ex.getId() == 4) {
                // update file
                
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        render();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void cb_kh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_kh1ActionPerformed
        KhachHang kh = (KhachHang)cb_kh1.getSelectedItem();
        ArrayList<BDSMH> arr_hoadon = new ArrayList<BDSMH>();
        for (BDSMH item : arr_bdsmh){
            if ( item.getKh().equals(kh)){
                arr_hoadon.add(item);
            }
        }
        
        model4 = new DefaultTableModel();
        model4 = (DefaultTableModel) jTable4.getModel();

        for (int i = model4.getRowCount() - 1; i >= 0; i--) {
            model4.removeRow(0);
        }

        int i = 1;
        double s = 0,total;
        for (BDSMH item : arr_hoadon) {
            total = item.getSl() * item.getMh().getCost();
            s+=total;
            Object tmp[] = {i++,item.getMh().getName(), item.getMh().getName(), item.getMh().getCate(), item.getMh().getCost(), item.getSl(), total};
            model4.addRow(tmp);
        }
        
        lb_total.setText("Tổng Hoá Đơn: " + s);
    }//GEN-LAST:event_cb_kh1ActionPerformed

    private void render(){
        model3 = new DefaultTableModel();
        model3 = (DefaultTableModel) jTable3.getModel();

        for (int i = model3.getRowCount() - 1; i >= 0; i--) {
            model3.removeRow(0);
        }

        for (BDSMH item : arr_bdsmh) {
            Object tmp[] = {item.getKh(), item.getMh(), item.getSl()};
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
    private javax.swing.JComboBox<String> cb_cate;
    private javax.swing.JComboBox<KhachHang> cb_kh;
    private javax.swing.JComboBox<KhachHang> cb_kh1;
    private javax.swing.JComboBox<MatHang> cb_mh;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JLabel lb_total;
    private javax.swing.JTextField tf_add;
    private javax.swing.JTextField tf_cost;
    private javax.swing.JTextField tf_nameKH;
    private javax.swing.JTextField tf_nameMH;
    private javax.swing.JTextField tf_sdt;
    private javax.swing.JTextField tf_sl;
    // End of variables declaration//GEN-END:variables
}
