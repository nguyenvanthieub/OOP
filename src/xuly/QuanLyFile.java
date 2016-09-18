package xuly;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import base.CanBo;

public class QuanLyFile {
	
	public static final String FILE_NAME = "asm4java.dat";

    public static boolean hasObject(File file) {
        FileInputStream fileInputStream;
        boolean check = true;
        try {
        	fileInputStream = new FileInputStream(file);
            ObjectInputStream inStream = new ObjectInputStream(fileInputStream);
            if (inStream.readObject() == null) {
                check = false;
            }
            inStream.close();
        } catch (FileNotFoundException e) {
            check = false;
        } catch (IOException e) {
            check = false;
        } catch (ClassNotFoundException e) {
            check = false;
        }
        return check;
    }
 
    public static boolean write(String fileName, CanBo canBo) {
        try {
            File file = new File(fileName);
            FileOutputStream fileOutputStream;
            ObjectOutputStream outStream = null;
            if (!file.exists()) {
            	fileOutputStream = new FileOutputStream(file);
            	outStream = new ObjectOutputStream(fileOutputStream);
            } else {
                if (!hasObject(file)) {
                	fileOutputStream = new FileOutputStream(file);
                	outStream = new ObjectOutputStream(fileOutputStream);
                } else {
                	fileOutputStream = new FileOutputStream(file, true);
                	outStream = new ObjectOutputStream(fileOutputStream) {
                        protected void writeStreamHeader() throws IOException {
                            reset();
                        }
                    };
                }
            }
            outStream.writeObject(canBo);
            outStream.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
 
    public static ArrayList<CanBo> read(String fileName) {
    	ArrayList<CanBo> dsCanBo = new ArrayList<CanBo>();
        try {
            File file = new File(fileName);
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream inStream = new ObjectInputStream(fileInputStream);
            Object object;
            while (true) {
            	object = inStream.readObject();
                dsCanBo.add((CanBo) object);
            }
        } catch (ClassNotFoundException e) {
        } catch (IOException e) {
        }
        return dsCanBo;
    }
	
}
