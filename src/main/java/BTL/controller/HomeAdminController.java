package BTL.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeAdminController {
	@GetMapping("/home-admin")
	public String homeAdmin() {
		return "home-admin";
	}
}
