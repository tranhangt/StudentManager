package BTL.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BTL.entity.SinhVien;

public interface SinhVienRepository extends JpaRepository<SinhVien, String>{
	SinhVien findByMaSV(String maSV);
}
