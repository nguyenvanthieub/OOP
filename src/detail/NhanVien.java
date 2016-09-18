package detail;

import base.CanBo;
import base.ICanBo;
import util.MyEnum.CHUCVU;

public class NhanVien extends CanBo implements ICanBo {

	private String phongBan;
	private CHUCVU chucVu;
	private int soNgayCong;
	
	@Override
	public float tinhLuong() {
		return this.getHeSoLuong() * 730 + this.getPhuCap() + this.getSoNgayCong() * 30;
	}
	
	public String getPhongBan(){
		return this.phongBan;
	}
	
	public void setPhongBan(String phongBan){
		this.phongBan = phongBan;
	}
	
	public CHUCVU getChucVu() {
		return this.chucVu;
	}
	
	public void setChucVu(CHUCVU chucVu) {
		this.chucVu = chucVu;
	}
	
	public int getSoNgayCong() {
		return this.soNgayCong;
	}
	
	public void setSoNgayCong(int soNgayCong) {
		this.soNgayCong = soNgayCong;
	}
	
}
