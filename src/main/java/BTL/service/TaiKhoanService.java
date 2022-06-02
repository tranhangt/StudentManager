package BTL.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import BTL.entity.TaiKhoan;
import BTL.repository.TaiKhoanRepository;

public class TaiKhoanService {
	@Autowired
	private TaiKhoanRepository tkRepo;
	
	public TaiKhoan login(String username, String password) {
		Optional<TaiKhoan> optTaiKhoan = tkRepo.findById(username);
		if(optTaiKhoan.isPresent() && password.equals(optTaiKhoan.get().getPassword())) {
			optTaiKhoan.get().setPassword("");
			return optTaiKhoan.get();
		}
		return null;
	}
}
