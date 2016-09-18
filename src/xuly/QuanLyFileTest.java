package xuly;
import base.CanBo;
import detail.GiangVien;

import java.io.File;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.junit.Test;

public class QuanLyFileTest extends TestCase{
    
    @Test
    public void testHasObject() {
        File file = new File("testHasObject.dat");
        boolean actual = QuanLyFile.hasObject(file);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void testWrite() {
        GiangVien giangVien = new GiangVien();
        boolean actual = QuanLyFile.write("testWrite.dat", giangVien);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void testRead() {    	
        ArrayList<CanBo> actual = new ArrayList<CanBo>();
        actual = QuanLyFile.read("testRead.dat");
        ArrayList<CanBo> expected = new ArrayList<CanBo>();
        assertEquals(expected, actual);
    }
    
}