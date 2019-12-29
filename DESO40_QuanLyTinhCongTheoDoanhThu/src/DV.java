
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
public class DV implements Serializable{
	int mdv;
	String name, cate;
	double cp,gc;
	
	public DV() {
	}

	public void save(){
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(new File("DV.TXT"),true));
			pw.append(mdv + "\n"+ name +"\n"+cate+"\n"+cp +"\n"+gc +"\n");
			pw.close();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(DV.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public DV(int mdv, String name, String cate, double cp, double gc) {
		this.mdv = mdv;
		this.name = name;
		this.cate = cate;
		this.cp = cp;
		this.gc = gc;
	}

	public int getMdv() {
		return mdv;
	}

	public String getName() {
		return name;
	}

	public String getCate() {
		return cate;
	}

	public double getCp() {
		return cp;
	}

	public double getGc() {
		return gc;
	}

	@Override
	public int hashCode() {
		int hash = 7;
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
		final DV other = (DV) obj;
		if (this.mdv != other.mdv) {
			return false;
		}
		if (Double.doubleToLongBits(this.cp) != Double.doubleToLongBits(other.cp)) {
			return false;
		}
		if (Double.doubleToLongBits(this.gc) != Double.doubleToLongBits(other.gc)) {
			return false;
		}
		if (!Objects.equals(this.name, other.name)) {
			return false;
		}
		if (!Objects.equals(this.cate, other.cate)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "DV{" + "mdv=" + mdv + ", name=" + name + '}';
	}
	
	
		
}
