
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
    String name,add,cm;

    public void save(){
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("NV.TXT"),true));
            pw.append(mnv +"\n"+ name +"\n"+ add +"\n"+ cm +"\n");
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public NhanVien(int mnv, String name, String add, String cm) {
        this.mnv = mnv;
        this.name = name;
        this.add = add;
        this.cm = cm;
    }
    
    


 
    @Override
    public String toString() {
        return "NhanVien{" + "mnv=" + mnv + ", name=" + name + '}';
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
        if (!Objects.equals(this.cm, other.cm)) {
            return false;
        }
        return true;
    }

    public String getCm() {
        return cm;
    }

    
    
    
}
