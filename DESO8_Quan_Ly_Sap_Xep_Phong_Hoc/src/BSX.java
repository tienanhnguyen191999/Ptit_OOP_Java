
import java.io.File;
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
public class BSX implements Serializable {

    Lop l;
    PhongHoc ph;
    String shift;

    void save() {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("BSX.TXT"), true)) {
                @Override
                protected void writeStreamHeader() throws IOException {
                    reset();
                }
            };
            os.writeObject(this);
            os.close();
        } catch (IOException ex) {
            Logger.getLogger(BSX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public Lop getL() {
        return l;
    }

    public PhongHoc getPh() {
        return ph;
    }

    public String getShift() {
        return shift;
    }

    public BSX(Lop l, PhongHoc ph, String shift) {
        this.l = l;
        this.ph = ph;
        this.shift = shift;
    }

    public BSX() {
        this.l = null;
        this.ph = null;
    }

    
}
