
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tienanh
 */
public class BangKe implements  Serializable{
	HanhKhach hk;
	LoaiVe ve;
	Date d;

	public BangKe() {
		hk = null;
		ve = null;
	}

	
	
	public void save(){
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("BANVE.TXT"),true)){
				@Override
				protected void writeStreamHeader() throws IOException {
					reset();
				}
				
			};
			os.writeObject(this);
			os.close();
		} catch (IOException ex) {
			Logger.getLogger(BangKe.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public BangKe(HanhKhach hk, LoaiVe ve) {
		this.hk = hk;
		this.ve = ve;
		d = new Date();
	}

	public HanhKhach getHk() {
		return hk;
	}

	public LoaiVe getVe() {
		return ve;
	}

	public Date getD() {
		return d;
	}
	
	
	
	
}
