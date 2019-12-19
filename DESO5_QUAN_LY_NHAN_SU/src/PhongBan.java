
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
public class PhongBan implements Serializable{
    int mp;
    String name,des;
    double hscv;
    
    public void save(){
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("PB.TXT"),true));
            pw.append(mp +"\n"+ name +"\n"+ des +"\n"+ hscv+"\n");
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public PhongBan() {
    }

    public PhongBan(int mp, String name, String des, double hscv) {
        this.mp = mp;
        this.name = name;
        this.des = des;
        this.hscv = hscv;
    }

    public int getMp() {
        return mp;
    }

    public String getName() {
        return name;
    }

    public String getDes() {
        return des;
    }

    public double getHscv() {
        return hscv;
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
        final PhongBan other = (PhongBan) obj;
        if (this.mp != other.mp) {
            return false;
        }
        if (Double.doubleToLongBits(this.hscv) != Double.doubleToLongBits(other.hscv)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.des, other.des)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PhongBan{" + "mp=" + mp + ", name=" + name + '}';
    }
    
    
}
