package xuly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import base.CanBo;
import detail.GiangVien;
import detail.NhanVien;
import util.MyEnum.CHUCVU;
import util.MyEnum.TRINHDO;

public class QuanLyCanBo {

	public static GiangVien nhapGiangVien() {
		GiangVien giangVien = new GiangVien();
		try {
			Scanner reader = new Scanner(System.in);
			// Nhap ho ten
			System.out.print("Ho ten: ");
			String hoTen = reader.nextLine();
			// Nhap khoa
			System.out.print("Khoa: ");
			String khoa = reader.nextLine();
			// Nhap he so luong
			System.out.print("He so luong: ");
			float heSoLuong = reader.nextFloat();
			// Nhap so tiet day
			System.out.print("So tiet day: ");
			int soTietDay = reader.nextInt();
			// Nhap trinh do
			System.out.println("Nhap 1, 2 hoac 3 tuong ung voi trinh do:");
			System.out.println("1 = Cu Nhan, 2 = Thac Si, 3 = Tien Si");
			int trinhDo = reader.nextInt();
			// gan gia tri
			giangVien.setHoTen(hoTen);
			giangVien.setHeSoLuong(heSoLuong);
			giangVien.setKhoa(khoa);
			switch (trinhDo) {
			case 1:
				giangVien.setTrinhDo(TRINHDO.CUNHAN);
				giangVien.setPhuCap(300);
				break;
			case 2:
				giangVien.setTrinhDo(TRINHDO.THACSI);
				giangVien.setPhuCap(500);
				break;
			case 3:
				giangVien.setTrinhDo(TRINHDO.TIENSI);
				giangVien.setPhuCap(1000);
				break;
			default:
				return null;
			}
			giangVien.setSoTietDay(soTietDay);
			giangVien.setLuong(giangVien.tinhLuong());
		} catch (Exception e) {
			return null;
		}
		return giangVien;
	}

	public static NhanVien nhapNhanVien() {
		NhanVien nhanVien = new NhanVien();
		try {
			Scanner reader = new Scanner(System.in);
			// Nhap ho ten
			System.out.print("Ho ten: ");
			String hoTen = reader.nextLine();
			// Nhap khoa
			System.out.print("Phong ban: ");
			String phongBan = reader.nextLine();
			// Nhap he so luong
			System.out.print("He so luong: ");
			float heSoLuong = reader.nextFloat();
			// Nhap so tiet day
			System.out.print("So ngay cong: ");
			int soNgayCong = reader.nextInt();
			// Nhap trinh do
			System.out.println("Nhap 1, 2 hoac 3 tuong ung voi trinh do:");
			System.out.println("1 = Truong Phong, 2 = Pho Phong, 3 = Nhan Vien");
			int chucVu = reader.nextInt();
			// gan gia tri
			nhanVien.setHoTen(hoTen);
			nhanVien.setHeSoLuong(heSoLuong);
			nhanVien.setPhongBan(phongBan);
			switch (chucVu) {
			case 1:
				nhanVien.setChucVu(CHUCVU.TRUONGPHONG);
				nhanVien.setPhuCap(2000);
				break;
			case 2:
				nhanVien.setChucVu(CHUCVU.PHOPHONG);
				nhanVien.setPhuCap(1000);
				break;
			case 3:
				nhanVien.setChucVu(CHUCVU.NHANVIEN);
				nhanVien.setPhuCap(500);
				break;
			default:
				return null;
			}
			nhanVien.setSoNgayCong(soNgayCong);
			nhanVien.setLuong(nhanVien.tinhLuong());
		} catch (Exception e) {
			return null;
		}
		return nhanVien;
	}

	public static void xuatGiangVien(GiangVien giangVien) {
		System.out.println("Ho ten: " + giangVien.getHoTen());
		System.out.println("He so luong: " + giangVien.getHeSoLuong());
		System.out.println("Khoa: " + giangVien.getKhoa());
		switch (giangVien.getTrinhDo()) {
		case TIENSI:
			System.out.println("Trinh do: Tien Si");
			break;
		case THACSI:
			System.out.println("Trinh do: Thac Si");
			break;
		case CUNHAN:
			System.out.println("Trinh do: Cu Nhan");
			break;
		}
		System.out.println("Phu cap: " + giangVien.getPhuCap());
		System.out.println("So tiet day: " + giangVien.getSoTietDay());
		System.out.println("Luong: " + giangVien.getLuong());
	}

	public static void xuatNhanVien(NhanVien nhanVien) {
		System.out.println("Ho ten: " + nhanVien.getHoTen());
		System.out.println("He so luong: " + nhanVien.getHeSoLuong());
		System.out.println("Phong ban: " + nhanVien.getPhongBan());
		switch (nhanVien.getChucVu()) {
		case TRUONGPHONG:
			System.out.println("Chuc vu: Truong Phong");
			break;
		case PHOPHONG:
			System.out.println("Chuc vu: Pho Phong");
			break;
		case NHANVIEN:
			System.out.println("Chuc vu: Nhan Vien");
			break;
		}
		System.out.println("Phu cap: " + nhanVien.getPhuCap());
		System.out.println("So ngay cong: " + nhanVien.getSoNgayCong());
		System.out.println("Luong: " + nhanVien.getLuong());
	}

	public static ArrayList<NhanVien> timKiem(ArrayList<CanBo> dsCanBo, String hoTen, String phongBan) {
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		for (int i = 0; i < dsCanBo.size(); i++) {
			if (dsCanBo.get(i).getClass() == NhanVien.class) {
				NhanVien nhanVien = (NhanVien) dsCanBo.get(i);
				String hoTenNhanVien = nhanVien.getHoTen().toLowerCase();
				String phongBanNhanVien = nhanVien.getPhongBan().toLowerCase();
				if (hoTenNhanVien.contains(hoTen.toLowerCase()) && phongBanNhanVien.equals(phongBan.toLowerCase())) {
					dsNhanVien.add(nhanVien);
				}
			}
		}
		return dsNhanVien;
	}

	public static void xuatGiangVien(ArrayList<CanBo> dsCanBo) {
		int dem = 0;
		ArrayList<GiangVien> dsGiangVien = new ArrayList<GiangVien>();
		for (int i = 0; i < dsCanBo.size(); i++) {
			if (dsCanBo.get(i).getClass() == GiangVien.class) {
				dem++;
				GiangVien giangVien = (GiangVien) dsCanBo.get(i);
				dsGiangVien.add(giangVien);
			}
		}
		if (dem == 0) {
			System.out.println(">>>>> Khong tim thay giang vien nao <<<<<");
		} else {
			xuatDanhSachGiangVienDaSapXep(dsGiangVien);
		}
	}
	
	private static void xuatDanhSachGiangVienDaSapXep(ArrayList<GiangVien> dsGiangVien) {
		Collections.sort(dsGiangVien, new Comparator<GiangVien>() {
			@Override
			public int compare(GiangVien gv1, GiangVien gv2) {
				if (gv1.getHoTen().compareTo(gv2.getHoTen()) > 0) {
					return 1;
				} else {
					if (gv1.getHoTen().compareTo(gv2.getHoTen()) == 0) {
						if (gv1.getLuong() < gv2.getLuong()) {
							return 1;
						} else if (gv1.getLuong() > gv2.getLuong()) {
							return -1;
						}
						return 0;
					} else {
						return -1;
					}
				}
			}
		});
		for (int i = 0; i < dsGiangVien.size(); i++) {
			System.out.println(">> Giang vien thu " + (i + 1));
			GiangVien giangVien = dsGiangVien.get(i);
			QuanLyCanBo.xuatGiangVien(giangVien);
		}
	}

}
