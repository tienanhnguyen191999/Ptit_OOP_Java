
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
public class DSBH implements Serializable{
    private MatHang mh;
    private NhanVien nv;
    private int sl;

    public void save(){
        try {
            ObjectOutputStream  os = new ObjectOutputStream(new FileOutputStream(new File("QLBH.TXT"),true)) {
                @Override
                protected void writeStreamHeader() throws IOException {
                    reset();
                }
            };
            
            os.writeObject(this);
            os.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DSBH.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DSBH.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public DSBH() {
        mh = null;
        nv = null;
    }

    public DSBH(MatHang mh, NhanVien nv, int sl) {
        this.mh = mh;
        this.nv = nv;
        this.sl = sl;
    }

    
    
    public MatHang getMh() {
        return mh;
    }

    public NhanVien getNv() {
        return nv;
    }

    public int getSl() {
        return sl;
    }
    
    
    
    
}
