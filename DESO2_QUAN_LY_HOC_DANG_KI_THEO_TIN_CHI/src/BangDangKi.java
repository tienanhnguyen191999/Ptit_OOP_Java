
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Date;
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
public class BangDangKi implements Serializable{
    MonHoc mh;
    SinhVien sv;
    Date d;

    public BangDangKi() {
        mh = null;
        sv = null;
    }

    
    
    public void save(){
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("QLDK.TXT", true)){
                @Override
                protected void writeStreamHeader() throws IOException {
                    reset();
                } 
            };
            os.writeObject(this);
            os.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BangDangKi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public BangDangKi(MonHoc mh, SinhVien sv) {
        this.mh = mh;
        this.sv = sv;
        this.d = new Date();
    }

    public MonHoc getMh() {
        return mh;
    }

    public SinhVien getSv() {
        return sv;
    }

    public Date getD() {
        return d;
    }
    
    
}
