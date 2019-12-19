
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
public class BDSMH implements Serializable{
    private MatHang mh;
    private KhachHang kh;
    private int sl;

    public BDSMH() {
        mh = null;
        kh = null;
    }
    
    public void save(){
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("QLBH.TXT"),true)){
                @Override
                protected void writeStreamHeader() throws IOException {
                    reset();
                }
            };
            
            os.writeObject(this);
            os.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BDSMH.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BDSMH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public BDSMH(MatHang mh, KhachHang kh, int sl) {
        this.mh = mh;
        this.kh = kh;
        this.sl = sl;
    }

    public MatHang getMh() {
        return mh;
    }

    public KhachHang getKh() {
        return kh;
    }

    public int getSl() {
        return sl;
    }
    
}
