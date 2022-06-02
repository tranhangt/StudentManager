package BTL.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import BTL.entity.KhoaHoc;
import BTL.entity.ThoiKhoaBieu;
import BTL.repository.KhoaHocRepository;
import BTL.repository.ThoiKhoaBieuRepository;

@Controller
@RequestMapping("/student/schedule")
public class StudentThoiKhoaBieuController {
	@Autowired
	private ThoiKhoaBieuRepository tkbRepo;
	private KhoaHocRepository khRepo;
	
	@GetMapping("/{maSV}")
	public String getTKB(@PathVariable(name = "maSV") String maSV, Model model) {
		List<ThoiKhoaBieu> st_tkbList = tkbRepo.findByMaSV(maSV);
		List<KhoaHoc> st_khoaHoc = getKhoaHoc(st_tkbList);
		model.addAttribute("student_tkb", st_khoaHoc);
		return "studentSchedule";
	}
	
	private List<KhoaHoc> getKhoaHoc(List<ThoiKhoaBieu> ad_tkbList) {
		List<KhoaHoc> khList = khRepo.findAll();
		List<KhoaHoc> tmpKh = new ArrayList<>();
		for (ThoiKhoaBieu tkb: ad_tkbList) {
			for (KhoaHoc khoaHoc: khList) {
				if(khoaHoc.getMaKH().equals(tkb.getMaKH())){
					tmpKh.add(khoaHoc);
				}
			}
		}
		return tmpKh;
	}
}
