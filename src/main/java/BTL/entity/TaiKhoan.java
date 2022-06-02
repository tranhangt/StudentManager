package BTL.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class TaiKhoan {
	@Id
	private String username;
	@NotBlank(message = "Password is required")
	private String password;
	private int isAdmin;
}
