
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
public class LoaiVe implements  Serializable{
	private int ml;
	private String des;
	private double cost;

	public void save(){
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(new File("VE.TXT"),true));
			pw.append(ml + "\n" +des + "\n" + cost + "\n");
			pw.close();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(LoaiVe.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public LoaiVe(int ml, String des, double cost) {
		this.ml = ml;
		this.des = des;
		this.cost = cost;
	}

	public int getMl() {
		return ml;
	}

	public String getDes() {
		return des;
	}

	public double getCost() {
		return cost;
	}

	@Override
	public String toString() {
		return "LoaiVe{" + "ml=" + ml + ", des=" + des + '}';
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
		final LoaiVe other = (LoaiVe) obj;
		if (this.ml != other.ml) {
			return false;
		}
		if (Double.doubleToLongBits(this.cost) != Double.doubleToLongBits(other.cost)) {
			return false;
		}
		if (!Objects.equals(this.des, other.des)) {
			return false;
		}
		return true;
	}
	
	
}
