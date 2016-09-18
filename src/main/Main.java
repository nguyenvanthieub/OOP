package main;

import java.util.ArrayList;
import java.util.Scanner;
import base.CanBo;
import detail.GiangVien;
import detail.NhanVien;
import xuly.QuanLyCanBo;
import xuly.QuanLyFile;

public class Main {

	public static void main(String[] args) {
		Scanner scanIn = new Scanner(System.in);
		Boolean check = true;
		while (check) {
			System.out.println(">>>> Nhap so tuong ung voi chuc nang:");
			System.out.println("1 = Nhap danh sach can bo");
			System.out.println("2 = Tim kiem nhan vien theo ten va phong ban");
			System.out.println("3 = Xuat ra danh sach giang vien");
			System.out.println("Khac 1,2,3 = Thoat chuong trinh");
			try {
				int nhap = scanIn.nextInt();
				switch (nhap) {
				case 1:
					nhapDanhSachCanBo();
					break;
				case 2:
					timKiemNhanVien();
					break;
				case 3:
					xuatDanhSachGiangVien();
					break;
				default:
					check = false;
					break;
				}
			} catch (Exception e) {
				check = false;
			}
		}
		System.out.println(">>Chuong trinh ket thuc<<");
	}

	private static void nhapDanhSachCanBo() {
		Scanner scanIn = new Scanner(System.in);
		Boolean check = true;
		while (check) {
			System.out.println(">>> Nhap so tuong ung voi kieu nhap:");
			System.out.println("1 = Nhap Giang Vien");
			System.out.println("2 = Nhap Nhan Vien");
			System.out.println("Khac 1,2 = Dung lai nhap");
			try {
				int nhap = scanIn.nextInt();
				switch (nhap) {
				case 1:
					GiangVien giangVien = new GiangVien();
					do {
						giangVien = QuanLyCanBo.nhapGiangVien();
						if (giangVien == null) {
							System.out.println("> Nhap sai, nhap lai nhan vien <");
						}
					} while (giangVien == null);
					QuanLyFile.write(QuanLyFile.FILE_NAME, giangVien);
					break;
				case 2:
					NhanVien nhanVien = new NhanVien();
					do {
						nhanVien = QuanLyCanBo.nhapNhanVien();
						if (nhanVien == null) {
							System.out.println("> Nhap sai, nhap lai nhan vien <");
						}
					} while (nhanVien == null);
					QuanLyFile.write(QuanLyFile.FILE_NAME, nhanVien);
					break;
				default:
					System.out.println("> Dung nhap <");
					check = false;
					break;
				}
			} catch (Exception e) {
				System.out.println("> Dung nhap <");
				check = false;
			}
		}
	}

	private static void timKiemNhanVien() {
		Scanner scanIn = new Scanner(System.in);
		System.out.print("Nhap ho ten cua nguoi can tim: ");
		String hoTen = scanIn.nextLine();
		System.out.print("Nhap phong ban cua nguoi can tim: ");
		String phongBan = scanIn.nextLine();
		ArrayList<CanBo> dsCanBo = new ArrayList<CanBo>();
		dsCanBo = QuanLyFile.read(QuanLyFile.FILE_NAME);
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		dsNhanVien = QuanLyCanBo.timKiem(dsCanBo, hoTen, phongBan);
		if (dsNhanVien.size() == 0) {
			System.out.println(">>>>> Khong tim thay nhan vien nao <<<<<");
		} else {
			for (int i = 0; i < dsNhanVien.size(); i++) {
				QuanLyCanBo.xuatNhanVien(dsNhanVien.get(i));
			}
		}
	}

	private static void xuatDanhSachGiangVien() {
		ArrayList<CanBo> dsCanBo = new ArrayList<CanBo>();
		dsCanBo = QuanLyFile.read(QuanLyFile.FILE_NAME);
		QuanLyCanBo.xuatGiangVien(dsCanBo);
	}

}
