package detail;

//import static org.junit.Assert.*;

import org.junit.Test;
import junit.framework.TestCase;

public class GiangVienTest extends TestCase {
	  
    @Test
    public void testTinhLuong() {
        GiangVien giangVien = new GiangVien();
        giangVien.setHeSoLuong(0);
        giangVien.setPhuCap(0);
        giangVien.setSoTietDay(1);
        float actual = giangVien.tinhLuong();
        float expected = 45.0F;
        assertEquals(expected, actual);
    }
    
}
