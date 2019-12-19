
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
public class MonHoc implements Serializable{
    int mmh;
    String name;
    int total;
    String cate;

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
        final MonHoc other = (MonHoc) obj;
        if (this.mmh != other.mmh) {
            return false;
        }
        if (this.total != other.total) {
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

        
    public void save(){
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("MH.TXT"),true));
            pw.append(mmh + "\n" + name + "\n" + total + "\n" + cate+ "\n" );
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getMmh() {
        return mmh;
    }

    public String getName() {
        return name;
    }

    public int getTotal() {
        return total;
    }

    public String getCate() {
        return cate;
    }

    public void setMmh(int mmh) {
        this.mmh = mmh;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    @Override
    public String toString() {
        return "{" + "mmh=" + mmh + ", name=" + name + '}';
    }

    
    public MonHoc() {
    }

    public MonHoc(int mmh, String name, int total, String cate) {
        this.mmh = mmh;
        this.name = name;
        this.total = total;
        this.cate = cate;
    }
    
    

}
