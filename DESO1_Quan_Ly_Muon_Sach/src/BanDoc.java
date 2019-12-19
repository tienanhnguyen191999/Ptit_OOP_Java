
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
public class BanDoc implements Serializable{
    int mbd;
    String name, add, sdt;

    public void save(){ 
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("BD.TXT"), true));
            pw.append(mbd+"\n" + name+"\n"+ add+"\n" +sdt + "\n");
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BanDoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public BanDoc(int mbd, String name, String add, String sdt) {
        this.mbd = mbd;
        this.name = name;
        this.add = add;
        this.sdt = sdt;
    }

    boolean equals(BanDoc obj){
        if ( mbd == obj.mbd ||
             name == obj.name ||
             add  == obj.add ||
             sdt == obj.sdt 
                ) return true;
        return false;
    }
    
    @Override
    public String toString() {
        return "BanDoc{" + "mbd=" + mbd + ", name=" + name + ", add=" + add + ", sdt=" + sdt + '}';
    }

    public int getMbd() {
        return mbd;
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
