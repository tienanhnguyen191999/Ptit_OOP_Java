
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
public class Sach implements Serializable{
    int ms;
    String name, auth, cate, nxb;
    int sl;

    Sach(){
        
    }
    
     public void save(){ 
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("SACH.TXT"), true));
            pw.append(ms+"\n" + name+"\n"+ auth+"\n" +cate + "\n" + nxb + "\n" + sl + "\n");
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BanDoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    boolean equals(Sach obj){
        if ( this.auth == obj.auth ||
             this.cate == obj.cate ||
             this.sl  == obj.sl ||
             this.name == obj.name ||
             this.nxb == obj.nxb ||
             this.sl == obj.sl
                ) return true;
        return false;
    }
     
    @Override
    public String toString() {
        return "Sach{" + "ms=" + ms + ", name=" + name + ", auth=" + auth + ", cate=" + cate + ", nxb=" + nxb + ", sl=" + sl + '}';
    }

    public void setMs(int ms) {
        this.ms = ms;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    
    
    public Sach(int ms, String name, String auth, String cate, String nxb, int sl) {
        this.ms = ms;
        this.name = name;
        this.auth = auth;
        this.cate = cate;
        this.nxb = nxb;
        this.sl = sl;
    }

    public int getMs() {
        return ms;
    }

    public String getName() {
        return name;
    }

    public String getAuth() {
        return auth;
    }

    public String getCate() {
        return cate;
    }

    public String getNxb() {
        return nxb;
    }

    public int getSl() {
        return sl;
    }
    
    
}
