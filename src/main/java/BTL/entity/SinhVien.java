package BTL.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class SinhVien {
	@Id
	private String maSV;
	@NotBlank(message = "Full Name is required")
	private String tenSV;
	@NotBlank(message = "Email is required")
	private String emailSV;
}
