package BTL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import BTL.entity.KhoaHoc;
import BTL.repository.KhoaHocRepository;
import BTL.repository.ThoiKhoaBieuRepository;

@Controller
@RequestMapping("/student/courses")
public class StudentKhoaHocController {
	@Autowired
	private KhoaHocRepository khRepo;
	
	@Autowired
	private ThoiKhoaBieuRepository tkbRepo;
	
	@GetMapping
	public String getKhoaHoc(Model model) {
		List<KhoaHoc> st_khList = khRepo.findAll();
		model.addAttribute("studentCourse", st_khList);
		return "course";
	}
	
	@PostMapping("/register")
	public String RegisterCourse(List<KhoaHoc> khList, @ModelAttribute("username") String username) {
		
		return "";
	}
}
