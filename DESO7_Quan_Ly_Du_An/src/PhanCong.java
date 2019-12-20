
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
public class PhanCong implements Serializable {
    DuAn da;
    NhanVien nv;
    int soNgay;

    public void save() {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("PHANCONG.TXT"), true)) {
                @Override
                protected void writeStreamHeader() throws IOException {
                    reset();
                }
            };
            os.writeObject(this);
            os.close();
        } catch (IOException ex) {
            Logger.getLogger(PhanCong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public PhanCong(DuAn da, NhanVien nv, int soNgay) {
        this.da = da;
        this.nv = nv;
        this.soNgay = soNgay;
    }

    public PhanCong() {
        nv = null;
        da = null;
    }

    public DuAn getDa() {
        return da;
    }

    public NhanVien getNv() {
        return nv;
    }

    public int getSoNgay() {
        return soNgay;
    }

}
