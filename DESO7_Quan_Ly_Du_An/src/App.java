
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

    private final ArrayList<DuAn> arr_da;
    private final ArrayList<NhanVien> arr_nv;
    private final ArrayList<PhanCong> arr_pc;
    private DefaultTableModel model1;
    private DefaultTableModel model2;
    private DefaultTableModel model3;
    private final JTableHeader th;
    private ArrayList<PhanCong> arr_search;
    private DefaultTableModel model4;
    
    
    public App() {
        arr_da = new ArrayList<DuAn>();
        arr_nv = new ArrayList<NhanVien>();
        arr_pc = new ArrayList<PhanCong>();
        initComponents();
        String data[] = {"nhỏ", "trung bình" , "lớn"};
        for (String item : data) cb_cate.addItem(item);
        
        try {
            Scanner sc = new Scanner(new File("DA.TXT"));
            while (sc.hasNextLine()){
                DuAn tmp = new DuAn(Integer.parseInt(sc.nextLine()),sc.nextLine(),sc.nextLine(),Double.parseDouble(sc.nextLine()));
                arr_da.add(tmp);
                cb_da.addItem(tmp);
            }
            sc = new Scanner(new File("NV.TXT"));
            while (sc.hasNextLine()){
                NhanVien tmp = new NhanVien(Integer.parseInt(sc.nextLine()),sc.nextLine(),sc.nextLine(),sc.nextLine());
                arr_nv.add(tmp);
                cb_nv.addItem(tmp);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(new File("PHANCONG.TXT")));
            while (true){
                PhanCong tmp = (PhanCong)is.readObject();
                if (tmp.getDa() != null) arr_pc.add(tmp);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("IF PHANCONG.TXT not exist => create and push empty Object");
            try {
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("PHANCONG.TXT")));
                os.writeObject(new PhanCong());
                os.close();
            } catch (FileNotFoundException ex1) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (IOException ex1) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        th = jTable3.getTableHeader();
        th.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if ( th.columnAtPoint(e.getPoint()) == 0){
                    arr_pc.sort((o1, o2) -> o1.getNv().getName().compareTo(o1.getNv().getName()));
                }
                else if ( th.columnAtPoint(e.getPoint()) == 1){
                    arr_pc.sort((o1, o2) -> o1.getDa().getName().compareTo(o1.getDa().getName()));
                }
                else if ( th.columnAtPoint(e.getPoint()) == 2){
                    arr_pc.sort((o1, o2) -> o1.getSoNgay() > o2.getSoNgay() ? 1 : -1);
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
        cb_cate = new javax.swing.JComboBox<>();
        tf_total = new javax.swing.JTextField();
        tf_nameDA = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_cm = new javax.swing.JTextField();
        tf_nameNV = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        tf_add = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cb_da = new javax.swing.JComboBox<>();
        tf_soNgay = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        cb_nv = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        tf_keyWord = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tên Dự Án");

        jLabel2.setText("Kiểu Dự Án");

        jLabel3.setText("Tổng kinh phí");

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
                "Mã Dự Án", "Tên Dự Án", "Kiểu Dự Án", "Tổng Kinh Phí"
            }
        ));
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Tổng Kinh Phí");
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
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_nameDA)
                    .addComponent(cb_cate, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_total))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(43, 43, 43))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_nameDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cb_cate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dự Án", jPanel1);

        jLabel4.setText("Tên Nhân Viên");

        jLabel5.setText("Địa chỉ");

        jLabel6.setText("Chuyên Môn");

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
                "Mã Nhân Viên", "Tên Nhân Viên", "Địa chỉ", "Chuyên Môn"
            }
        ));
        jScrollPane4.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(3).setHeaderValue("Tổng Kinh Phí");
        }

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
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_nameNV)
                    .addComponent(tf_cm)
                    .addComponent(tf_add))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(43, 43, 43))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_nameNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tf_cm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nhân Viên", jPanel2);

        jLabel7.setText("Nhân viên");

        jLabel8.setText("Dự Án");

        jLabel9.setText("Số Ngày Công");

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
                "Nhân Viên", "Dự Án", "Số Ngày Công"
            }
        ));
        jScrollPane5.setViewportView(jTable3);

        jLabel10.setText("*Click to tableHeader to sort");

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
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_da, 0, 388, Short.MAX_VALUE)
                    .addComponent(tf_soNgay)
                    .addComponent(cb_nv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(43, 43, 43))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cb_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cb_da, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tf_soNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Phân Công", jPanel3);

        jLabel11.setText("KeyWord");

        tf_keyWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_keyWordActionPerformed(evt);
            }
        });
        tf_keyWord.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_keyWordKeyPressed(evt);
            }
        });

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nhân Viên", "Dự Án", "Số Ngày Công"
            }
        ));
        jScrollPane6.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_keyWord)
                .addContainerGap())
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tf_keyWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6)
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
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try {
            if (tf_total.getText().equals("") || tf_nameDA.getText().equals("")) {
                throw new MyException(1);
            }
            
            String name = tf_nameDA.getText();
            String cate = "" + cb_cate.getSelectedItem();
            Double total = Double.parseDouble(tf_total.getText());
            if (total < 0) throw new MyException(2);
            
            DuAn tmp = new DuAn(arr_da.size() +10000, name, cate, total);
            tmp.save();
            arr_da.add(tmp);
            JOptionPane.showMessageDialog(null, "Saved");
        } catch (MyException ex) {
            if ( ex.getId() == 1) JOptionPane.showMessageDialog(null, "Không để trống các trường");
            else if ( ex.getId() == 2) JOptionPane.showMessageDialog(null, "Kinh phí phải > 0");
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Lỗi format");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        model1 = new DefaultTableModel();
        model1 = (DefaultTableModel)jTable1.getModel();
        
        for ( int i = model1.getRowCount() - 1; i >=0;i--)
            model1.removeRow(0);
        
        for ( DuAn item : arr_da){
            Object tmp[] = {item.getMda(),item.getName(),item.getCate(),item.getTotal()};
            model1.addRow(tmp);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            if (tf_cm.getText().equals("") || tf_nameNV.getText().equals("") || tf_add.getText().equals("")) {
                throw new MyException(1);
            }
            
            String name = tf_nameNV.getText();
            String add = tf_add.getText();
            String cm = tf_cm.getText();
            
            NhanVien tmp = new NhanVien(arr_nv.size() + 10000, name, add, cm);
            tmp.save();
            arr_nv.add(tmp);
            JOptionPane.showMessageDialog(null, "Saved");
        } catch (MyException ex) {
            if ( ex.getId() == 1) JOptionPane.showMessageDialog(null, "Không để trống các trường");
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Lỗi format");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        model2 = new DefaultTableModel();
        model2 = (DefaultTableModel)jTable2.getModel();
        
        for ( int i = model2.getRowCount() - 1; i >=0;i--)
            model2.removeRow(0);
        
        for ( NhanVien item : arr_nv){
            Object tmp[] = {item.getMnv(),item.getName(),item.getAdd(),item.getCm()};
            model2.addRow(tmp);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            if (tf_soNgay.getText().equals("")) {
                throw new MyException(1);
            }
            
            
            int soNgay = Integer.parseInt(tf_soNgay.getText());
            NhanVien nv = (NhanVien)cb_nv.getSelectedItem();
            DuAn da = (DuAn)cb_da.getSelectedItem();
            
            for (PhanCong item : arr_pc){
                if (item.getNv().equals(nv) && item.getDa().equals(da)){
                    throw new MyException(2);
                }
            }
            
            PhanCong tmp = new PhanCong(da, nv, soNgay);
            tmp.save();
            arr_pc.add(tmp);
            JOptionPane.showMessageDialog(null, "Saved");
        } catch (MyException ex) {
            if ( ex.getId() == 1) JOptionPane.showMessageDialog(null, "Không để trống các trường");
            else if ( ex.getId() == 2) JOptionPane.showMessageDialog(null, "Dự án đã được thêm cho nhân viên này");
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Lỗi format");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        rerender();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tf_keyWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_keyWordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_keyWordActionPerformed

    private void tf_keyWordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_keyWordKeyPressed
        String key = tf_keyWord.getText();
        String pattern = ".*"+key+".*";
        
        arr_search = new ArrayList<PhanCong>();
        for (PhanCong item : arr_pc){
           if (item.getDa().getName().matches(pattern) || item.getNv().getName().matches(pattern)){
               arr_search.add(item);
           } 
        }
        
        model4 = new DefaultTableModel();
        model4 = (DefaultTableModel)jTable4.getModel();
        
        for ( int i = model4.getRowCount() - 1; i >=0;i--)
            model4.removeRow(0);
        
        for ( PhanCong item : arr_search){
            Object tmp[] = {item.getNv(),item.getDa(),item.getSoNgay()};
            model4.addRow(tmp);
        }
    }//GEN-LAST:event_tf_keyWordKeyPressed

    private void rerender(){
        model3 = new DefaultTableModel();
        model3 = (DefaultTableModel)jTable3.getModel();
        
        for ( int i = model3.getRowCount() - 1; i >=0;i--)
            model3.removeRow(0);
        
        for ( PhanCong item : arr_pc){
            Object tmp[] = {item.getNv(),item.getDa(),item.getSoNgay()};
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
    private javax.swing.JComboBox<DuAn> cb_da;
    private javax.swing.JComboBox<NhanVien> cb_nv;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField tf_add;
    private javax.swing.JTextField tf_cm;
    private javax.swing.JTextField tf_keyWord;
    private javax.swing.JTextField tf_nameDA;
    private javax.swing.JTextField tf_nameNV;
    private javax.swing.JTextField tf_soNgay;
    private javax.swing.JTextField tf_total;
    // End of variables declaration//GEN-END:variables
}
