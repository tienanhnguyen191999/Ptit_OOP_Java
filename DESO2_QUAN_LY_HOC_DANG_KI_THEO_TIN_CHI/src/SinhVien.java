
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
public class SinhVien implements Serializable{
    int msv;
    String name,add,sdt;

    public void save(){
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("SV.TXT"),true));
            pw.append(msv + "\n" +name + "\n" + add + "\n" + sdt+ "\n" );
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final SinhVien other = (SinhVien) obj;
        if (this.msv != other.msv) {
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
        return "{" + "msv=" + msv + ", name=" + name + '}';
    }

    public SinhVien(int msv, String name, String add, String sdt) {
        this.msv = msv;
        this.name = name;
        this.add = add;
        this.sdt = sdt;
    }

    public SinhVien() {
    }

    public int getMsv() {
        return msv;
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
    
    
}
