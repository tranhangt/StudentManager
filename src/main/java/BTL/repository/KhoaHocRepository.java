package BTL.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BTL.entity.KhoaHoc;

public interface KhoaHocRepository extends JpaRepository<KhoaHoc, String>{
	KhoaHoc findByMaKH(String maKH);
}
