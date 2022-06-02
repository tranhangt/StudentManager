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

import BTL.entity.SinhVien;
import BTL.repository.SinhVienRepository;

@Controller
@RequestMapping("/students")
public class SinhVienController {
	@Autowired
	private SinhVienRepository svRepo;
	
	@GetMapping						//ten duong dan
	public String getStudent(Model model) {
        List<SinhVien> svList = svRepo.findAll();
        model.addAttribute("listSinhVien", svList);	//ten doi tuong
        return "students";								//ten file
    }
	
	@GetMapping("/addStudent")
	public String showAddStudent(Model model) {
		model.addAttribute("newStudent", new SinhVien());
		return "addStudent";                                               
	}
	@PostMapping(value = "/addSV")
	public String addStudent(@ModelAttribute("newStudent") SinhVien sinhVien) {
		svRepo.save(sinhVien);
		return "redirect:/students";
	}
	
	@GetMapping("/updateStudent/{maSV}")
	public String showUpdateStudent(@PathVariable(name = "maSV") String maSV, Model model) {
		SinhVien sinhVien = svRepo.findByMaSV(maSV);
		model.addAttribute("studentUpdate", sinhVien);
		return "updateStudent";
	}
	@PostMapping(value = "/updateSV")
	public String updateStudent(@ModelAttribute("studentUpdate") SinhVien sinhVien) {
		svRepo.save(sinhVien);
		return "redirect:/students";
	}
	
	@GetMapping("/deleteStudent/{maSV}")
	public String showDeleteStudent(@PathVariable(name = "maSV") String maSV, Model model) {
		SinhVien sinhVien = svRepo.findByMaSV(maSV);
		model.addAttribute("studentDelete", sinhVien);
		svRepo.delete(sinhVien);
		return "redirect:/students";
	}
}
