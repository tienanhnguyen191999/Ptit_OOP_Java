
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
public class PhongHoc implements  Serializable{
    private int mp;
    String name;
    int soghe;
    String cate;
    
    public void save(){
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("PH.TXT")));
            pw.append(mp +"\n"+ name +"\n"+ soghe +"\n" + cate + "\n");
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public PhongHoc(int mp, String name, int soghe, String cate) {
        this.mp = mp;
        this.name = name;
        this.soghe = soghe;
        this.cate = cate;
    }

    public int getMp() {
        return mp;
    }

    public String getName() {
        return name;
    }

    public int getSoghe() {
        return soghe;
    }

    public String getCate() {
        return cate;
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
        final PhongHoc other = (PhongHoc) obj;
        if (this.mp != other.mp) {
            return false;
        }
        if (this.soghe != other.soghe) {
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
        return "PhongHoc{" + "mp=" + mp + ", name=" + name + '}';
    }
    
    
}
