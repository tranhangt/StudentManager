package BTL.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import BTL.entity.TaiKhoan;
import BTL.repository.TaiKhoanRepository;

@Controller
@RequestMapping("/")
public class TaiKhoanController {	
	@Autowired
	private TaiKhoanRepository tkRepo;
	
//	@GetMapping("alogin")
//	public String login(Model model) {
//		model.addAttribute("account", new TaiKhoan());
//		return "index";
//	}
	
	@GetMapping(value = "/alogin")
	public String login(Model model, @ModelAttribute("account") TaiKhoan tk, BindingResult result) {
		if(result.hasErrors()) {
			return "index";
		}
		if(tk.getUsername().equals("admin") && tk.getPassword().equals("123")) {
			return "home-admin";
		}
		TaiKhoan taiKhoan = findUser(tk.getUsername(), tk.getPassword());
		
		if(taiKhoan == null) {
			model.addAttribute("message", "Invalid username or password");
			return "index";
		}
		
		model.addAttribute("username", taiKhoan.getUsername());
		if(taiKhoan.getIsAdmin() == 1) {
			return "home-admin";
		}
		return "home";
	}
	
	private TaiKhoan findUser(String username, String password) {
		Optional<TaiKhoan> optTaiKhoan = tkRepo.findById(username);
		if(optTaiKhoan.isPresent() && password.equals(optTaiKhoan.get().getPassword())) {
			optTaiKhoan.get().setPassword("");
			return optTaiKhoan.get();
		}
		return null;
	}
	
	@GetMapping("/myprofile")
	public String account(Model model) {
		model.addAttribute("myAccount", new TaiKhoan());
		return "account";
	}
	@PostMapping("/change")
	public String changePass(@ModelAttribute(name = "myAccount") TaiKhoan taiKhoan) {
		tkRepo.save(taiKhoan);
		return "account";
	}
}
