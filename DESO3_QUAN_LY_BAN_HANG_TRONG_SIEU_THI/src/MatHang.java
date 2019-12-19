
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

    public void save(){
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("MH.TXT"),true));
            pw.append(mh + "\n" + name + "\n" + cate + "\n" + cost + "\n");
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MatHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public MatHang(int mh, String name, String cate, double cost) {
        this.mh = mh;
        this.name = name;
        this.cate = cate;
        this.cost = cost;
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

    @Override
    public String toString() {
        return "MatHang{" + "mh=" + mh + ", name=" + name + '}';
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
        final MatHang other = (MatHang) obj;
        if (this.mh != other.mh) {
            return false;
        }
        if (Double.doubleToLongBits(this.cost) != Double.doubleToLongBits(other.cost)) {
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
    
    
}
