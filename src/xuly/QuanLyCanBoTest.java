package xuly;

import base.CanBo;
import detail.NhanVien;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.junit.Test;

public class QuanLyCanBoTest extends TestCase {

    @Test
    public void testTimKiem() {
        ArrayList<CanBo> dsCanBo = new ArrayList<CanBo>();
        String hoTen = "Nguyen Van A";
        String phongBan = "IT";
        ArrayList<NhanVien> actual = QuanLyCanBo.timKiem(dsCanBo, hoTen, phongBan);
        ArrayList<NhanVien> expected = new ArrayList<NhanVien>();
        assertEquals(expected, actual);
    }
    
}