
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Objects;
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
public class HanhKhach implements  Serializable{
	private int mhk;
	private String name,add,cate;

	
	
	public void save(){
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(new File("HK.TXT"),true));
			pw.append(mhk + "\n" +name + "\n" + add + "\n" + cate + "\n");
			pw.close();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(LoaiVe.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public HanhKhach(int mhk, String name, String add, String cate) {
		this.mhk = mhk;
		this.name = name;
		this.add = add;
		this.cate = cate;
	}

	public int getMhk() {
		return mhk;
	}

	public String getName() {
		return name;
	}

	public String getAdd() {
		return add;
	}

	public String getCate() {
		return cate;
	}

	@Override
	public String toString() {
		return "HanhKhach{" + "mhk=" + mhk + ", name=" + name + '}';
	}

	@Override
	public int hashCode() {
		int hash = 5;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final HanhKhach other = (HanhKhach) obj;
		if (this.mhk != other.mhk) {
			return false;
		}
		if (!Objects.equals(this.name, other.name)) {
			return false;
		}
		if (!Objects.equals(this.add, other.add)) {
			return false;
		}
		if (!Objects.equals(this.cate, other.cate)) {
			return false;
		}
		return true;
	}
	
	
}

