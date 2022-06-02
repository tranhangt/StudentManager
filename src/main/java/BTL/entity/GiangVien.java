package BTL.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;
@Data
@Entity
public class GiangVien {
	@Id
	private String maGV;
	@NotBlank(message = "Full Name is required")
	private String tenGV;
	@NotBlank(message = "Email is required")
	private String emailGV;
	@NotBlank(message = "Khoa is required")
	private String khoa;
	@NotBlank(message = "Bac Luong is required")
	private float bacLuong;
	@NotBlank(message = "Luong is required")
	private float luong;
}
