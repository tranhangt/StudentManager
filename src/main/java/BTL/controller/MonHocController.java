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

import BTL.entity.MonHoc;
import BTL.repository.MonHocRepository;

@Controller
@RequestMapping("/subjects")
public class MonHocController {
	@Autowired
	private MonHocRepository mhRepo;
	
	@GetMapping						//ten duong dan
	public String getSubject(Model model) {
        List<MonHoc> mhList = mhRepo.findAll();
        model.addAttribute("listMonHoc", mhList);	//ten doi tuong
        return "subjects";								//ten file
    }
	
	@GetMapping("/addSubject")
	public String showAddSubject(Model model) {
		model.addAttribute("newSubject", new MonHoc());
		return "addSubject";                                               
	}
	@PostMapping(value = "/addMH")
	public String addSubject(@ModelAttribute("newSubject") MonHoc monHoc) {
		mhRepo.save(monHoc);
		return "redirect:/subjects";
	}
	
	@GetMapping("/updateSubject/{maMH}")
	public String showUpdateSubject(@PathVariable(name = "maMH") String maMH, Model model) {
		MonHoc monHoc = mhRepo.findByMaMH(maMH);
		model.addAttribute("subjectUpdate", monHoc);
		return "updateSubject";
	}
	@PostMapping(value = "/updateMH")
	public String updateSubject(@ModelAttribute("subjectUpdate") MonHoc monHoc) {
		mhRepo.save(monHoc);
		return "redirect:/subjects";
	}
	
	@GetMapping("/deleteSubject/{maMH}")
	public String showDeleteSubject(@PathVariable(name = "maMH") String maMH, Model model) {
		MonHoc monHoc = mhRepo.findByMaMH(maMH);
		model.addAttribute("subjectDelete", monHoc);
		mhRepo.delete(monHoc);
		return "redirect:/subjects";
	}
}
