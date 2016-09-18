package detail;

import base.CanBo;
import base.ICanBo;
import util.MyEnum.TRINHDO;

public class GiangVien extends CanBo implements ICanBo {

	private String khoa;
	private TRINHDO trinhDo;
	private int soTietDay;

	@Override
	public float tinhLuong() {
		return this.getHeSoLuong() * 730 + this.getPhuCap() + this.getSoTietDay() * 45;
	}
	
	public String getKhoa(){
		return this.khoa;
	}
	
	public void setKhoa(String khoa){
		this.khoa = khoa;
	}
	
	public TRINHDO getTrinhDo() {
		return this.trinhDo;
	}
	
	public void setTrinhDo(TRINHDO trinhDo) {
		this.trinhDo = trinhDo;
	}
	
	public int getSoTietDay() {
		return this.soTietDay;
	}
	
	public void setSoTietDay(int soTietDay) {
		this.soTietDay = soTietDay;
	}
	
}
