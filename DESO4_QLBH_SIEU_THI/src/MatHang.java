
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
public class MatHang implements Serializable{
    int mh;
    String name,cate;
    double cost;
    int sl;

    public void save(){
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("MH.TXT"),true));
            pw.append(mh + "\n" +name +  "\n" +cate +  "\n" +cost + "\n" +sl + "\n");
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public MatHang(int mh, String name, String cate, double cost, int sl) {
        this.mh = mh;
        this.name = name;
        this.cate = cate;
        this.cost = cost;
        this.sl = sl;
    }

    public MatHang() {
    }

    
    public int getMh() {
        return mh;
    }

    public String getName() {
        return name;
    }

    public String getCate() {
        return cate;
    }

    public double getCost() {
        return cost;
    }

    public int getSl() {
        return sl;
    }

    public void setMh(int mh) {
        this.mh = mh;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setSl(int sl) {
        this.sl = sl;
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
        final MatHang other = (MatHang) obj;
        if (this.mh != other.mh) {
            return false;
        }
        if (Double.doubleToLongBits(this.cost) != Double.doubleToLongBits(other.cost)) {
            return false;
        }
        if (this.sl != other.sl) {
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
        return "MatHang{" + "mh=" + mh + ", name=" + name + '}';
    }
    
    
}
