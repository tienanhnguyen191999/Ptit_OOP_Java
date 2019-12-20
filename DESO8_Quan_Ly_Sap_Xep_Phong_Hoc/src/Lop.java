
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
public class Lop implements  Serializable{
    int ml;
    String name;
    int total;
    
    public void save(){
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("LOP.TXT")));
            pw.append(ml +"\n"+ name +"\n"+ total +"\n" );
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Lop(int ml, String name, int total) {
        this.ml = ml;
        this.name = name;
        this.total = total;
    }

    public int getMl() {
        return ml;
    }

    public String getName() {
        return name;
    }

    public int getTotal() {
        return total;
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
        final Lop other = (Lop) obj;
        if (this.ml != other.ml) {
            return false;
        }
        if (this.total != other.total) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Lop{" + "ml=" + ml + ", name=" + name + '}';
    }
    
    
}
