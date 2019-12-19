
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
public class PhongHoc implements Serializable{
    private int mph;
    private String name;
    private int soghe;

    public void save(){
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("PH.TXT"),true));
            pw.append(mph +"\n"+ name+"\n"+soghe  + "\n");
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PhongHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public PhongHoc(int mph, String name, int soghe) {
        this.mph = mph;
        this.name = name;
        this.soghe = soghe;
    }

    public PhongHoc() {
    }

    public int getMph() {
        return mph;
    }

    public String getName() {
        return name;
    }

    public int getSoghe() {
        return soghe;
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
        final PhongHoc other = (PhongHoc) obj;
        if (this.mph != other.mph) {
            return false;
        }
        if (this.soghe != other.soghe) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PhongHoc{" + "mph=" + mph + ", name=" + name + '}';
    }
    
    
}
