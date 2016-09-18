package base;

import java.io.Serializable;

public abstract class CanBo implements Serializable{
	
	private String hoTen;
	private float heSoLuong;
	private float phuCap;
	private float luong;
	
	public String getHoTen(){
		return this.hoTen;
	}
	
	public void setHoTen(String hoTen){
		this.hoTen = hoTen;
	}
	
	public float getHeSoLuong(){
		return this.heSoLuong;
	}
	
	public void setHeSoLuong(float heSoLuong){
		this.heSoLuong = heSoLuong;
	}	
	
	public float getPhuCap(){
		return this.phuCap;
	}
	
	public void setPhuCap(float phuCap){
		this.phuCap = phuCap;
	}	
	
	public float getLuong(){
		return this.luong;
	}
	
	public void setLuong(float luong){
		this.luong = luong;
	}	
		
}
