package BTL.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BTL.entity.MonHoc;

public interface MonHocRepository extends JpaRepository<MonHoc, String> {
	MonHoc findByMaMH(String maMH);
}
