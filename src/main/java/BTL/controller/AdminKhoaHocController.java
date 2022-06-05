package BTL.controller;

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
import BTL.repository.KhoaHocRepository;

@Controller
@RequestMapping("/courses")
public class AdminKhoaHocController {
	@Autowired
	private KhoaHocRepository khRepo;
	
	@GetMapping						//ten duong dan
	public String getCourse(Model model) {
        List<KhoaHoc> khList = khRepo.findAll();
        model.addAttribute("listKhoaHoc", khList);	//ten doi tuong
        return "course-admin";								//ten file
    }
	
	@GetMapping("/addCourse")
	public String showAddCourse(Model model) {
		model.addAttribute("newCourse", new KhoaHoc());
		return "addCourse";                                               
	}
	@PostMapping(value = "/addKH")
	public String addCourse(@ModelAttribute("newCourse") KhoaHoc khoaHoc) {
		khRepo.save(khoaHoc);
		return "redirect:/courses";
	}
	
	@GetMapping("/updateCourse/{maKH}")
	public String showUpdateCourse(@PathVariable(name = "maKH") String maKH, Model model) {
		KhoaHoc khoaHoc = khRepo.findByMaKH(maKH);
		model.addAttribute("courseUpdate", khoaHoc);
		return "updateCourse";
	}
	@PostMapping(value = "/updateKH")
	public String updateCourse(@ModelAttribute("courseUpdate") KhoaHoc khoaHoc) {
		khRepo.save(khoaHoc);
		return "redirect:/courses";
	}
	
	@GetMapping("/deleteCourse/{maKH}")
	public String showDeleteCourse(@PathVariable(name = "maKH") String maKH, Model model) {
		KhoaHoc khoaHoc = khRepo.findByMaKH(maKH);
		model.addAttribute("courseDelete", khoaHoc);
		khRepo.delete(khoaHoc);
		return "redirect:/courses";
	}
}
