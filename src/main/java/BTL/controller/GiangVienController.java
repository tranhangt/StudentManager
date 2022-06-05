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

import BTL.entity.GiangVien;
import BTL.repository.GiangVienRepository;

@Controller
@RequestMapping("/teachers")
public class GiangVienController {
	@Autowired
	private GiangVienRepository gvRepo;
	
	@GetMapping						//ten duong dan
	public String getTeacher(Model model) {
        List<GiangVien> gvList = gvRepo.findAll();
        model.addAttribute("listGiangVien", gvList);	//ten doi tuong
        return "teacher";								//ten file
    }
	
	@GetMapping("/addTeacher")
	public String showAddTeacher(Model model) {
		model.addAttribute("newTeacher", new GiangVien());
		return "addTeacher";                                               
	}
	@PostMapping(value = "/addGV")
	public String addTeacher(@ModelAttribute("newTeacher") GiangVien giangVien) {
		gvRepo.save(giangVien);
		return "redirect:/teachers";
	}
	
	@GetMapping("/updateTeacher/{maGV}")
	public String showUpdateTeacher(@PathVariable(name = "maGV") String maGV, Model model) {
		GiangVien giangVien = gvRepo.findByMaGV(maGV);
		model.addAttribute("teacherUpdate", giangVien);
		return "updateTeacher";
	}
	@PostMapping(value = "/updateGV")
	public String updateTeacher(@ModelAttribute("teacherUpdate") GiangVien giangVien) {
		gvRepo.save(giangVien);
		return "redirect:/teachers";
	}
	
	@GetMapping("/deleteTeacher/{maGV}")
	public String showDeleteTeacher(@PathVariable(name = "maGV") String maGV, Model model) {
		GiangVien giangVien = gvRepo.findByMaGV(maGV);
		model.addAttribute("teacherDelete", giangVien);
		gvRepo.delete(giangVien);
		return "redirect:/teachers";
	}
}
