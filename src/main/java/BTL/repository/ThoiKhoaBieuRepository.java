package BTL.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import BTL.entity.ThoiKhoaBieu;

public interface ThoiKhoaBieuRepository extends JpaRepository<ThoiKhoaBieu, String> {
	List<ThoiKhoaBieu> findByMaSV(String maSV);
	ThoiKhoaBieu findByMaKH(String maKH);
}
