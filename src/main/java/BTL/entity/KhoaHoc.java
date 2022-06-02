package BTL.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class KhoaHoc {
	@Id
	private String maKH;
	@NotBlank
	private String maMH;
	@NotBlank
	private String tenMH;
	@NotBlank
	private int thu;
	@NotBlank
	private int kip;
	@NotBlank
	private String tuan;	
}
