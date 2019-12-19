
import java.io.File;
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
public class QLTB implements Serializable{
   PhongHoc ph;
   ThietBi tb;
   String status;
   int sl;

   public void save(){
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("QLTB.TXT"),true)){
                @Override
                protected void writeStreamHeader() throws IOException {
                    reset();
                }  

            };
            os.writeObject(this);
            os.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(QLTB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(QLTB.class.getName()).log(Level.SEVERE, null, ex);
        }
   }

    public QLTB(PhongHoc ph, ThietBi tb, String status, int sl) {
        this.ph = ph;
        this.tb = tb;
        this.status = status;
        this.sl = sl;
    }

    public QLTB() {
        ph = null;
        tb = null;
    }

    public int getSl() {
        return sl;
    }

    public PhongHoc getPh() {
        return ph;
    }

    public ThietBi getTb() {
        return tb;
    }

    public String getStatus() {
        return status;
    }
   
   
}
