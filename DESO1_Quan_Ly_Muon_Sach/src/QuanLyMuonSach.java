
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
public class QuanLyMuonSach implements Serializable{
    BanDoc bd;
    Sach sach;
    int sl;

    public QuanLyMuonSach() {
        bd = null;
        sach = null;
    }

    
    public void save(){
        try {
            FileOutputStream os = new FileOutputStream("QLMS.TXT", true);
            ObjectOutputStream oos = new ObjectOutputStream(os){
                @Override
                protected void writeStreamHeader() throws IOException {
                    reset();
                }
                
            };
            oos.writeObject(this);
            System.out.println("Add to file");
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(QuanLyMuonSach.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(QuanLyMuonSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public QuanLyMuonSach(BanDoc bd, Sach sach, int sl) {
        this.bd = bd;
        this.sach = sach;
        this.sl = sl;
    }

    public BanDoc getBd() {
        return bd;
    }

    public Sach getSach() {
        return sach;
    }

    public int getSl() {
        return sl;
    }
    
    
}
