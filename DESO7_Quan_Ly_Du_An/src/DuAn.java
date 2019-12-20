
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
public class DuAn implements Serializable{
    int mda;
    String name, cate;
    double total;
    public void save(){
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("DA.TXT"),true));
            pw.append(mda +"\n"+ name +"\n"+ cate +"\n"+ total +"\n");
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DuAn(int mda, String name, String cate, double total) {
        this.mda = mda;
        this.name = name;
        this.cate = cate;
        this.total = total;
    }

    public int getMda() {
        return mda;
    }

    public String getName() {
        return name;
    }

    public String getCate() {
        return cate;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "DuAn{" + "mda=" + mda + ", name=" + name + '}';
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
        final DuAn other = (DuAn) obj;
        if (this.mda != other.mda) {
            return false;
        }
        if (Double.doubleToLongBits(this.total) != Double.doubleToLongBits(other.total)) {
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
