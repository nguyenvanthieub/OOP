package detail;

import org.junit.Test;
import junit.framework.TestCase;

public class NhanVienTest extends TestCase {

    @Test
    public void testTinhLuong() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setHeSoLuong(0);
        nhanVien.setPhuCap(0);
        nhanVien.setSoNgayCong(1);
        float actual = nhanVien.tinhLuong();
        float expected = 30.0F;
        assertEquals(expected, actual);
    }

}
