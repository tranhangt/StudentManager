package BTL.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import BTL.entity.KhoaHoc;
import BTL.entity.ThoiKhoaBieu;
import BTL.repository.KhoaHocRepository;
import BTL.repository.ThoiKhoaBieuRepository;

@Controller
@RequestMapping("/admin/schedule")
public class AdminThoiKhoaBieuController {
	@Autowired
	private ThoiKhoaBieuRepository tkbRepo;
	private KhoaHocRepository khRepo;
	
	@GetMapping("/{maSV}")
	public String AdminTKB(@PathVariable(name = "maSV") String maSV, Model model) {
		List<ThoiKhoaBieu> ad_tkbList = tkbRepo.findByMaSV(maSV);
		List<KhoaHoc> ad_KhoaHoc = getKhoaHoc(ad_tkbList);
		model.addAttribute("admin_tkb", ad_KhoaHoc);
		return "adminSchedule";
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
	
	@GetMapping("/point/{maKH}")
	public String NhapDiemForm(@PathVariable(name = "maKH") String maKH, Model model) {
		ThoiKhoaBieu tkb = tkbRepo.findByMaKH(maKH);
		model.addAttribute("tkb", tkb);
		return "addPoint";
	}
	@PostMapping("/addPoint")
	public String setDiem(@ModelAttribute("tkb") ThoiKhoaBieu tkb) {
		tkbRepo.save(tkb);
		return "redirect:/admin/schedule";
	}
}
