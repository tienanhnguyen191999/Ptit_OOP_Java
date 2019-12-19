
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
public class KhachHang implements Serializable{
    int mkh;
    String name, add,sdt;
    
    public void save(){
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("KH.TXT"),true));
            pw.append(mkh + "\n" + name + "\n" + add + "\n" + sdt + "\n");
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MatHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    public KhachHang(int mkh, String name, String add, String sdt) {
        this.mkh = mkh;
        this.name = name;
        this.add = add;
        this.sdt = sdt;
    }

    
    
    @Override
    public String toString() {
        return "KhachHang{" + "mkh=" + mkh + ", name=" + name + '}';
    }

    
    
    public int getMkh() {
        return mkh;
    }

    public String getName() {
        return name;
    }

    public String getAdd() {
        return add;
    }

    public String getSdt() {
        return sdt;
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
        final KhachHang other = (KhachHang) obj;
        if (this.mkh != other.mkh) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.add, other.add)) {
            return false;
        }
        if (!Objects.equals(this.sdt, other.sdt)) {
            return false;
        }
        return true;
    }
    
    
}