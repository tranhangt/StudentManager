package BTL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import BTL.entity.TaiKhoan;
import BTL.service.TaiKhoanService;

@Controller
public class TaiKhoanController {
	@Autowired
	private TaiKhoanService tkSer;
	
	@GetMapping("/")
	public String login(Model model) {
		model.addAttribute("account", new TaiKhoan());
		return "login";
	}
	
	@PostMapping("alogin")
	public String login(Model model, @ModelAttribute("account") TaiKhoan tk, BindingResult result) {
		if(result.hasErrors()) {
			return "login";
		}
		
		TaiKhoan taiKhoan = tkSer.login(tk.getUsername(), tk.getPassword());
		
		if(taiKhoan == null) {
			model.addAttribute("message", "Invalid username or password");
			return "login";
		}
		
		model.addAttribute("username", taiKhoan.getUsername());
		if(taiKhoan.getIsAdmin() == 1) {
			return "students";
		}
		return "/schedule/" + taiKhoan.getUsername();
	}
}
