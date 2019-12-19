
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
public class ThietBi implements Serializable{
    private int mtb;
    private String name,xx,year;
    
    public void save(){
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("TB.TXT"),true));
            pw.append(mtb +"\n" + name +"\n"+ xx+"\n"+ year + "\n");
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PhongHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ThietBi(int mtb, String name, String xx, String year) {
        this.mtb = mtb;
        this.name = name;
        this.xx = xx;
        this.year = year;
    }

    public int getMtb() {
        return mtb;
    }

    public String getName() {
        return name;
    }

    public String getXx() {
        return xx;
    }

    public String getYear() {
        return year;
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
        final ThietBi other = (ThietBi) obj;
        if (this.mtb != other.mtb) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.xx, other.xx)) {
            return false;
        }
        if (!Objects.equals(this.year, other.year)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ThietBi{" + "mtb=" + mtb + ", name=" + name + '}';
    }
    
}
