
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
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
public class QLMS extends javax.swing.JFrame {

    ArrayList<Sach> arr_sach;
    ArrayList<BanDoc> arr_bd;
    ArrayList<QuanLyMuonSach> arr_qlms;
    private DefaultTableModel model1;
    private DefaultTableModel model2;
    private DefaultTableModel model3;
    private JTableHeader th;
    private DefaultTableModel model4;
    private ArrayList<QuanLyMuonSach> arr_search;

    public QLMS() {
        try {
            arr_sach = new ArrayList<Sach>();
            arr_bd = new ArrayList<BanDoc>();
            arr_qlms = new ArrayList<QuanLyMuonSach>();
            initComponents();
            String data[] = {"Khoa học tự nhiên", "Văn học – Nghệ thuật", "Điện tử Viễn thông", "Công nghệ thông tin"};
            for (String item : data) {
                cb_cate.addItem(item);
            }

            Scanner sc = new Scanner(new File("SACH.TXT"));
            while (sc.hasNextLine()) {
                Sach tmp = new Sach(Integer.parseInt(sc.nextLine()), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()));
                arr_sach.add(tmp);
                cb_sach.addItem(tmp);
            }

            sc = new Scanner(new File("BD.TXT"));
            while (sc.hasNextLine()) {
                BanDoc tmp = new BanDoc(Integer.parseInt(sc.nextLine()), sc.nextLine(), sc.nextLine(), sc.nextLine());
                arr_bd.add(tmp);
                cb_bd.addItem(tmp);
            }

            cb_sach.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Sach tmp = (Sach) cb_sach.getSelectedItem();
                    lb_rest.setText("Hiện có: " + tmp.getSl() + " cuốn");
                }
            });

            // Get Data (arr_qlms) From QLMS.TXT FILE
            try {
                FileInputStream is = new FileInputStream(new File("QLMS.TXT"));
                ObjectInputStream ois = new ObjectInputStream(is);
                while (true) {
                    QuanLyMuonSach tmp = (QuanLyMuonSach) ois.readObject();
                    if (tmp.getBd() != null) {
                        arr_qlms.add(tmp);
                    }
                    System.out.println(arr_qlms.size());
                }
            } catch (FileNotFoundException ex) {
                ObjectOutputStream os1 = new ObjectOutputStream(new FileOutputStream("QLMS.TXT"));
                os1.writeObject(new QuanLyMuonSach());
                os1.close();
            } catch (IOException ex) {
                System.out.println("End Of File");
            }

            // Click header Table handle event => sort
            th = new JTableHeader();
            th =  jTable3.getTableHeader();
            th.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if ( th.columnAtPoint(e.getPoint()) == 0){
                        arr_qlms.sort(new Comparator<QuanLyMuonSach>(){
                            @Override
                            public int compare(QuanLyMuonSach o1, QuanLyMuonSach o2) {
                                return o1.getBd().getName().compareTo(o2.getBd().getName());
                            }
                            
                        });
                        rerender();
                    }else if ( th.columnAtPoint(e.getPoint()) == 1) {
                        arr_qlms.sort(new Comparator<QuanLyMuonSach>(){
                            @Override
                            public int compare(QuanLyMuonSach o1, QuanLyMuonSach o2) {
                                return o1.getSl() >= o2.getSl() ? 1 : -1;
                            }
                            
                        });
                        rerender();
                    }
                    
                }
            });
        } catch (FileNotFoundException ex) {
            System.out.println("File chua ton tai!, Sau Lan Save dau tien, file se dc tao");
        } catch (IOException ex) {
            Logger.getLogger(QLMS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLMS.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jLabel5 = new javax.swing.JLabel();
        tf_nameS = new javax.swing.JTextField();
        tf_auth = new javax.swing.JTextField();
        tf_nxb = new javax.swing.JTextField();
        tf_sl = new javax.swing.JTextField();
        cb_cate = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tf_nameBD = new javax.swing.JTextField();
        tf_sdt = new javax.swing.JTextField();
        tf_add = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tf_slsach = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        cb_bd = new javax.swing.JComboBox<>();
        cb_sach = new javax.swing.JComboBox<>();
        lb_rest = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        tf_keyword = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("App");

        jLabel1.setText("Tên Sách");

        jLabel2.setText("Tác Giả");

        jLabel3.setText("Chuyên Ngành");

        jLabel4.setText("Năm Xuất Bản");

        jLabel5.setText("Số Lượng");

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
                "Mã Sách", "Tên Sách", "Tác giả", " Chuyên ngành", "Năm xuất bản", "Số lượng"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setHeaderValue("SDT");
            jTable1.getColumnModel().getColumn(4).setHeaderValue("Năm xuất bản");
            jTable1.getColumnModel().getColumn(5).setHeaderValue("Số lượng");
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton1)
                                .addComponent(jLabel4)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_nameS)
                                    .addComponent(tf_auth)
                                    .addComponent(cb_cate, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tf_nxb)
                                    .addComponent(tf_sl))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 595, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(56, 56, 56))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_nameS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_auth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cb_cate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_nxb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_sl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sach", jPanel1);

        jLabel6.setText("Họ Tên");

        jLabel7.setText("Số điện thoại");

        jLabel10.setText("Địa chỉ");

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
                "Mã Bạn đọc", "Họ tên", "Địa chỉ", "SDT"
            }
        ));
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setHeaderValue("SDT");
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tf_nameBD, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                    .addComponent(tf_sdt)
                    .addComponent(tf_add))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 601, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(67, 67, 67))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tf_nameBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tf_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("BanDoc", jPanel2);

        jLabel8.setText("BanDoc");

        jLabel11.setText("SoLuong");

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

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Bạn đọc", "Mã Sách", "Số Lượng"
            }
        ));
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel12.setText("Sach");

        lb_rest.setText("Hiện có: ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tf_slsach, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lb_rest)
                        .addGap(69, 69, 69)
                        .addComponent(jLabel14)
                        .addGap(15, 15, 15))
                    .addComponent(cb_bd, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_sach, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 601, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(67, 67, 67))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cb_bd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12)
                    .addComponent(cb_sach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_slsach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(lb_rest)
                    .addComponent(jLabel14))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("QuanLyMuonSach", jPanel3);

        jLabel13.setText("Keyword");

        tf_keyword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_keywordActionPerformed(evt);
            }
        });
        tf_keyword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_keywordKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_keywordKeyPressed(evt);
            }
        });

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bạn Đọc", "Tên Sách"
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
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(32, 32, 32)
                        .addComponent(tf_keyword)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
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
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (tf_auth.getText().equals("") || tf_nameS.getText().equals("") || tf_nxb.getText().equals("") || tf_sl.getText().equals("") || tf_auth.getText().equals("")) {
                throw new MyException(1);
            }

            String name = tf_nameS.getText();
            String auth = tf_auth.getText();
            String nxb = tf_nxb.getText();
            int sl = Integer.parseInt(tf_sl.getText());
            String cate = cb_cate.getSelectedItem() + "";
            Sach tmp = new Sach(10000 + arr_sach.size(), name, auth, cate, nxb, sl);
            tmp.save();
            arr_sach.add(tmp);
            JOptionPane.showMessageDialog(null, "Saved");
        } catch (MyException ex) {
            if (ex.getId() == 1) {
                JOptionPane.showMessageDialog(null, "Không được để trống các trường");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi format");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        model1 = new DefaultTableModel();
        model1 = (DefaultTableModel) jTable1.getModel();
        for (int i = model1.getRowCount() - 1; i >= 0; i--) {
            model1.removeRow(0);
        }

        for (Sach item : arr_sach) {
            Object tmp[] = {item.getMs(), item.getName(), item.getAuth(), item.getCate(), item.getNxb(), item.getSl()};
            model1.addRow(tmp);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            if (tf_add.getText().equals("") || tf_nameBD.getText().equals("") || tf_sdt.getText().equals("")) {
                throw new MyException(1);
            }

            String name = tf_nameBD.getText();
            String add = tf_add.getText();
            String sdt = tf_sdt.getText();
            BanDoc tmp = new BanDoc(10000 + arr_bd.size(), name, add, sdt);
            tmp.save();
            arr_bd.add(tmp);
            JOptionPane.showMessageDialog(null, "Saved");
        } catch (MyException ex) {
            if (ex.getId() == 1) {
                JOptionPane.showMessageDialog(null, "Không được để trống các trường");
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        model2 = new DefaultTableModel();
        model2 = (DefaultTableModel) jTable2.getModel();
        for (int i = model2.getRowCount() - 1; i >= 0; i--) {
            model2.removeRow(0);
        }

        for (BanDoc item : arr_bd) {
            Object tmp[] = {item.getMbd(), item.getName(), item.getAdd(), item.getSdt()};
            model2.addRow(tmp);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            if (tf_slsach.getText().equals("")) {
                throw new MyException(1);
            }

            Sach sach = (Sach) cb_sach.getSelectedItem();
            BanDoc bd = (BanDoc) cb_bd.getSelectedItem();
            int sl = Integer.parseInt(tf_slsach.getText());
            if (sl > 3) {
                throw new MyException(2);
            }
            QuanLyMuonSach tmp = new QuanLyMuonSach(bd, sach, sl);

            int c = 0;
            System.out.println(arr_qlms.size());
            for (QuanLyMuonSach item : arr_qlms) {
                System.out.println("IN");
                if (item.getBd().equals(tmp.getBd())) {
                    System.out.println(item.getBd() + "||" + tmp.getBd());
                    c++;
                    if (item.getSach().equals(tmp.getSach())) {
                        System.out.println(item.getSach() + "||" + tmp.getSach());
                        throw new MyException(3);
                    }
                }
            }

            if (c == 5) {
                throw new MyException(4);
            }

            arr_qlms.add(tmp);
            tmp.save();

            // update arr_sach
            sach.setSl(sach.getSl() - sl);
            arr_sach.set(arr_sach.indexOf(sach), sach);
            PrintWriter pw = new PrintWriter(new File("SACH.TXT"));
            pw.flush();
            pw.close();
            for (Sach item : arr_sach) {
                item.save();
            }

            JOptionPane.showMessageDialog(null, "Saved");
        } catch (MyException ex) {
            if (ex.getId() == 1) {
                JOptionPane.showMessageDialog(null, "Không được để trống các trường");
            } else if (ex.getId() == 2) {
                JOptionPane.showMessageDialog(null, "Sách không được mượn quá 3 cuốn");
            } else if (ex.getId() == 3) {
                JOptionPane.showMessageDialog(null, "Sách đã được bạn thuê");
            } else if (ex.getId() == 4) {
                JOptionPane.showMessageDialog(null, "Bạn được chỉ được thuê tối đa 5 cuốn sách");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(QLMS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(QLMS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        rerender();
    }//GEN-LAST:event_jButton6ActionPerformed
    
    public void rerender(){
        model3 = new DefaultTableModel();
        model3 = (DefaultTableModel) jTable3.getModel();
        for (int i = model3.getRowCount() - 1; i >= 0; i--) {
            model3.removeRow(0);
        }

        for (QuanLyMuonSach item : arr_qlms) {
            Object tmp[] = {item.getBd(), item.getSach(), item.getSl()};
            model3.addRow(tmp);
        }
    }
    private void tf_keywordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_keywordActionPerformed

    }//GEN-LAST:event_tf_keywordActionPerformed

    private void tf_keywordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_keywordKeyPressed
        System.out.println(tf_keyword.getText());
        String regex = ".*" + tf_keyword.getText() + ".*";
        
        arr_search = new ArrayList<QuanLyMuonSach>();
        for( int i = arr_qlms.size() - 1 ; i >= 0 ; i--){
            if ((arr_qlms.get(i).getBd().getName().matches(regex) || arr_qlms.get(i).getSach().getName().matches(regex))){
                arr_search.add(arr_qlms.get(i));
            }
        }
        rerenderTable4();
    }//GEN-LAST:event_tf_keywordKeyPressed

    public void rerenderTable4(){
        model4 = new DefaultTableModel();
        model4 = (DefaultTableModel) jTable4.getModel();
        for (int i = model4.getRowCount() - 1; i >= 0; i--) {
            model4.removeRow(0);
        }

        for (QuanLyMuonSach item : arr_search) {
            Object tmp[] = {item.getBd().getName(), item.getSach().getName()};
            model4.addRow(tmp);
        }
    }
    private void tf_keywordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_keywordKeyTyped

    }//GEN-LAST:event_tf_keywordKeyTyped

    
    
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
            java.util.logging.Logger.getLogger(QLMS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLMS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLMS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLMS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLMS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<BanDoc> cb_bd;
    private javax.swing.JComboBox<String> cb_cate;
    private javax.swing.JComboBox<Sach> cb_sach;
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
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JLabel lb_rest;
    private javax.swing.JTextField tf_add;
    private javax.swing.JTextField tf_auth;
    private javax.swing.JTextField tf_keyword;
    private javax.swing.JTextField tf_nameBD;
    private javax.swing.JTextField tf_nameS;
    private javax.swing.JTextField tf_nxb;
    private javax.swing.JTextField tf_sdt;
    private javax.swing.JTextField tf_sl;
    private javax.swing.JTextField tf_slsach;
    // End of variables declaration//GEN-END:variables
}
