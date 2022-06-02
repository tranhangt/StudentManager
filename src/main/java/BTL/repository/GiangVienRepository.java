package BTL.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BTL.entity.GiangVien;

public interface GiangVienRepository extends JpaRepository<GiangVien, String>{
	GiangVien findByMaGV(String maGV);
}
