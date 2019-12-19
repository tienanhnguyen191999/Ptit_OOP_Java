
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
public class NhanVien implements Serializable{
    int mnv;
    String name,add,sdt;

    public void save(){
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("NV.TXT"),true));
            pw.append(mnv + "\n" +name +  "\n" +add +  "\n" +sdt + "\n");
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public NhanVien(int mnv, String name, String add, String sdt) {
        this.mnv = mnv;
        this.name = name;
        this.add = add;
        this.sdt = sdt;
    }

    public NhanVien() {
    }
    
    

    public int getMnv() {
        return mnv;
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
        final NhanVien other = (NhanVien) obj;
        if (this.mnv != other.mnv) {
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

    @Override
    public String toString() {
        return "NhanVien{" + "mnv=" + mnv + ", name=" + name + '}';
    }
    
    
}
