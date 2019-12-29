
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
import java.util.Date;
import java.util.HashMap;
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

	private final ArrayList<LoaiVe> arr_ve;
	private final ArrayList<BangKe> arr_bk;
	private final ArrayList<HanhKhach> arr_hk;
	private DefaultTableModel model1;
	private DefaultTableModel model2;
	private DefaultTableModel model3;
	private final JTableHeader th;
	private ArrayList<BangKe> arr_hd;
	private DefaultTableModel model4;
	

	public App() {
		arr_hk = new ArrayList<HanhKhach>();
		arr_ve = new ArrayList<LoaiVe>();
		arr_bk = new ArrayList<BangKe>();
		initComponents();
		String data[] = {"học sinh sinh viên", "cán bộ trong ngành" , "khách thông thường"};
		for (String item : data) cb_cate.addItem(item);
		
		try {
			Scanner sc = new Scanner(new File("HK.TXT"));
			while (sc.hasNextLine()){
				HanhKhach tmp = new HanhKhach(Integer.parseInt(sc.nextLine()),sc.nextLine(),sc.nextLine(),sc.nextLine());
				arr_hk.add(tmp);
				cb_hk.addItem(tmp);
				cb_hk1.addItem(tmp);
			}
			sc = new Scanner(new File("VE.TXT"));
			while (sc.hasNextLine()){
				LoaiVe tmp = new LoaiVe(Integer.parseInt(sc.nextLine()),sc.nextLine(),Double.parseDouble(sc.nextLine()));
				arr_ve.add(tmp);
				cb_ve.addItem(tmp);
			}
			
		} catch (FileNotFoundException ex) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(new File("BANVE.TXT")));
			while (true ){
				BangKe tmp = (BangKe) is.readObject();
				if (tmp.getHk()!=null) arr_bk.add(tmp);
			}
		} catch (FileNotFoundException ex) {
			try {
				ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("BANVE.TXT")));
				os.writeObject(new BangKe());
				os.close();
			} catch (FileNotFoundException ex1) {
				Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex1);
			} catch (IOException ex1) {
				Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex1);
			}
		} catch (IOException ex) {
			System.out.println("End Of File");
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		
		th = jTable3.getTableHeader();
		th.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if ( th.columnAtPoint(e.getPoint()) == 0){
					arr_bk.sort((o1, o2) -> o1.getHk().getName().compareToIgnoreCase(o2.getHk().getName()));
				}
				else if ( th.columnAtPoint(e.getPoint()) == 1){
					arr_bk.sort((o1, o2) -> o1.getHk().getName().compareToIgnoreCase(o2.getHk().getName()));
				}
				else if ( th.columnAtPoint(e.getPoint()) == 2){
					arr_bk.sort((o1, o2) -> o1.getVe().getDes().compareToIgnoreCase(o1.getVe().getDes()));
				}
				else if ( th.columnAtPoint(e.getPoint()) == 3){
					arr_bk.sort((o1, o2) -> o1.getVe().getDes().compareToIgnoreCase(o1.getVe().getDes()));
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
                tf_name = new javax.swing.JTextField();
                tf_add = new javax.swing.JTextField();
                cb_cate = new javax.swing.JComboBox<>();
                jButton1 = new javax.swing.JButton();
                jButton2 = new javax.swing.JButton();
                jScrollPane1 = new javax.swing.JScrollPane();
                jTable1 = new javax.swing.JTable();
                jPanel2 = new javax.swing.JPanel();
                jLabel4 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                tf_des = new javax.swing.JTextField();
                tf_cost = new javax.swing.JTextField();
                jButton3 = new javax.swing.JButton();
                jButton4 = new javax.swing.JButton();
                jScrollPane2 = new javax.swing.JScrollPane();
                jTable2 = new javax.swing.JTable();
                jPanel3 = new javax.swing.JPanel();
                jLabel6 = new javax.swing.JLabel();
                jLabel7 = new javax.swing.JLabel();
                cb_hk = new javax.swing.JComboBox<>();
                jButton5 = new javax.swing.JButton();
                jButton6 = new javax.swing.JButton();
                jScrollPane3 = new javax.swing.JScrollPane();
                jTable3 = new javax.swing.JTable();
                cb_ve = new javax.swing.JComboBox<>();
                jLabel8 = new javax.swing.JLabel();
                jPanel4 = new javax.swing.JPanel();
                jLabel9 = new javax.swing.JLabel();
                cb_hk1 = new javax.swing.JComboBox<>();
                jScrollPane4 = new javax.swing.JScrollPane();
                jTable4 = new javax.swing.JTable();
                jLabel10 = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jLabel1.setText("Họ tên");

                jLabel2.setText("Địa chỉ");

                jLabel3.setText("Loại khách");

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
                                "Mã hành khách", "Họ tên", "Địa chỉ", "Loại khách"
                        }
                ));
                jScrollPane1.setViewportView(jTable1);
                if (jTable1.getColumnModel().getColumnCount() > 0) {
                        jTable1.getColumnModel().getColumn(3).setHeaderValue("Loại khách");
                }

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(56, 56, 56)
                                                .addComponent(tf_name))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3))
                                                .addGap(29, 29, 29)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(tf_add)
                                                        .addComponent(cb_cate, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(57, 57, 57))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                                .addContainerGap())
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(tf_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(tf_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(cb_cate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                jTabbedPane1.addTab("Hành khách", jPanel1);

                jLabel4.setText("Mô tả");

                jLabel5.setText("Giá bán");

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
                                "Mã vé", "Mô tả", "Giá bán"
                        }
                ));
                jScrollPane2.setViewportView(jTable2);

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tf_des)
                                        .addComponent(tf_cost))
                                .addContainerGap())
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4)
                                .addGap(51, 51, 51))
                );
                jPanel2Layout.setVerticalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(tf_des, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(tf_cost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton3)
                                        .addComponent(jButton4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                jTabbedPane1.addTab("Loại vé", jPanel2);

                jLabel6.setText("Hành khách");

                jLabel7.setText("Loại Vé");

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
                                "Hành Khách", "Họ tên", "Loại vé", "Mô tả vé"
                        }
                ));
                jScrollPane3.setViewportView(jTable3);

                jLabel8.setText("*Click to tableHeader to sort");

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(18, 18, 18)
                                                .addComponent(cb_hk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(15, 15, 15))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(53, 53, 53)
                                                .addComponent(cb_ve, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap())))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6)
                                .addGap(42, 42, 42))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel8)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                jPanel3Layout.setVerticalGroup(
                        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(cb_hk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(cb_ve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton5)
                                        .addComponent(jButton6))
                                .addGap(20, 20, 20)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                jTabbedPane1.addTab("Bảng kê", jPanel3);

                jLabel9.setText("HanhKhac ");

                cb_hk1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                cb_hk1ActionPerformed(evt);
                        }
                });

                jTable4.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {

                        },
                        new String [] {
                                "Mã vé", "Mô tả", "Giá bán", "Tổng Tiền"
                        }
                ));
                jScrollPane4.setViewportView(jTable4);

                jLabel10.setText("Tổng cộng: ");

                javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
                jPanel4.setLayout(jPanel4Layout);
                jPanel4Layout.setHorizontalGroup(
                        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cb_hk1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE))
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addGap(101, 101, 101))
                );
                jPanel4Layout.setVerticalGroup(
                        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(cb_hk1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addContainerGap(88, Short.MAX_VALUE))
                );

                jTabbedPane1.addTab("HoaDon", jPanel4);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		 try {
			if ( tf_name.equals("") || tf_add.equals(""))
			throw new MyException(1);
			
			String name = tf_name.getText();
			String add = tf_add.getText();
			String cate = cb_cate.getSelectedItem() + "";
			
			 HanhKhach tmp = new HanhKhach(arr_hk.size() + 10000, name, add, cate);
			 tmp.save();
			 arr_hk.add(tmp);
			 JOptionPane.showMessageDialog(null,"Đã Lưu");
		} catch (MyException ex) {
			if ( ex.getId() == 1) JOptionPane.showMessageDialog(null,"Không được để trống các trường");
		}
        }//GEN-LAST:event_jButton1ActionPerformed

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            model1 = new DefaultTableModel();
	    model1 = (DefaultTableModel) jTable1.getModel();
	    
	    for (int i = model1.getRowCount() - 1; i >=0; i--) 
		    model1.removeRow(0);
	    
	    for ( HanhKhach item : arr_hk){
		    Object tmp[] = {item.getMhk(),item.getName(),item.getAdd(),item.getCate()};
		    model1.addRow(tmp);
	    }
        }//GEN-LAST:event_jButton2ActionPerformed

        private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
             try {
			if ( tf_des.equals("") || tf_cost.equals(""))
			throw new MyException(1);
			
			String des = tf_des.getText();
			Double cost = Double.parseDouble(tf_cost.getText());
			if (cost < 0 ) throw new MyException(2);
			
			LoaiVe tmp = new LoaiVe(arr_ve.size() + 10000, des, cost);
			 
			tmp.save();
			arr_ve.add(tmp);
			JOptionPane.showMessageDialog(null,"Đã Lưu");
		} catch (MyException ex) {
			if ( ex.getId() == 1) JOptionPane.showMessageDialog(null,"Không được để trống các trường");
			else if ( ex.getId() == 2) JOptionPane.showMessageDialog(null,"Giá phải dương");
		} catch (NumberFormatException ex){
			JOptionPane.showMessageDialog(null,"Lỗi format");
		}
        }//GEN-LAST:event_jButton3ActionPerformed

        private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
                model2 = new DefaultTableModel();
		model2 = (DefaultTableModel) jTable2.getModel();

		for (int i = model2.getRowCount() - 1; i >=0; i--) 
			model2.removeRow(0);

		for ( LoaiVe item : arr_ve){
			Object tmp[] = {item.getMl(),item.getDes(),item.getCost()};
			model2.addRow(tmp);
		}
        }//GEN-LAST:event_jButton4ActionPerformed

        private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
                try {
			HanhKhach hk = (HanhKhach) cb_hk.getSelectedItem();
			LoaiVe ve = (LoaiVe) cb_ve.getSelectedItem();
			
			int c = 0;
			for (BangKe item : arr_bk){
				if (item.getHk().equals(hk)){
					c++;
					if ( c == 3) throw new MyException(1);
					if (item.getVe().equals(ve) ){
						Date d = new Date();
						System.out.println("");
						throw new MyException(2);
					}
				}
			}
			
			BangKe tmp = new BangKe(hk, ve);
			tmp.save();
			arr_bk.add(tmp);
			JOptionPane.showMessageDialog(null,"Đã Lưu");
		} catch (MyException ex) {
			if ( ex.getId() == 1) JOptionPane.showMessageDialog(null,"Hành khách không được mua quá 3 loại vé");
			else if ( ex.getId() == 2) JOptionPane.showMessageDialog(null,"Loại vé này đã được quý khách mua! Để mua được vé, quý khác vui lòng đợi tới ngày thứ 30 kể từ ngày mua vé");
		}
        }//GEN-LAST:event_jButton5ActionPerformed

        private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
                 rerender();
        }//GEN-LAST:event_jButton6ActionPerformed

        private void cb_hk1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_hk1ActionPerformed
		HanhKhach hk = (HanhKhach) cb_hk1.getSelectedItem(); 
		
		arr_hd = new ArrayList<BangKe>();
		for ( BangKe item : arr_bk){
			if (item.getHk().equals(hk)){
				arr_hd.add(item);
			}
		}
		
		model4 = new DefaultTableModel();
		model4 = (DefaultTableModel) jTable4.getModel();

		for (int i = model4.getRowCount() - 1; i >=0; i--) 
			model4.removeRow(0);

		double s = 0;
		HashMap<String,Double> disCount= new HashMap<String,Double>();
		disCount.put("khách thông thường",1.0);
		disCount.put("cán bộ trong ngành",0.3);
		disCount.put("học sinh sinh viên",0.5);
		for ( BangKe  item : arr_hd){
			double total = item.getVe().getCost() * disCount.get(item.getHk().getCate());
			s+= total;
			Object tmp[] = {item.getVe().getMl(),item.getVe().getDes(),item.getVe().getCost(), total};
			model4.addRow(tmp);
		}
		
		
		jLabel10.setText("Tổng cộng: " + s);	
        }//GEN-LAST:event_cb_hk1ActionPerformed

	private void rerender (){
		model3 = new DefaultTableModel();
		model3 = (DefaultTableModel) jTable3.getModel();

		for (int i = model3.getRowCount() - 1; i >=0; i--) 
			model3.removeRow(0);

		for ( BangKe  item : arr_bk){
			Object tmp[] = {item.getHk(),item.getHk().getName(),item.getVe(), item.getVe().getDes()};
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
        private javax.swing.JComboBox<HanhKhach> cb_hk;
        private javax.swing.JComboBox<HanhKhach> cb_hk1;
        private javax.swing.JComboBox<LoaiVe> cb_ve;
        private javax.swing.JButton jButton1;
        private javax.swing.JButton jButton2;
        private javax.swing.JButton jButton3;
        private javax.swing.JButton jButton4;
        private javax.swing.JButton jButton5;
        private javax.swing.JButton jButton6;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel10;
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
        private javax.swing.JTextField tf_add;
        private javax.swing.JTextField tf_cost;
        private javax.swing.JTextField tf_des;
        private javax.swing.JTextField tf_name;
        // End of variables declaration//GEN-END:variables
}
