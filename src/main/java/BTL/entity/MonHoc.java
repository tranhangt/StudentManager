package BTL.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class MonHoc {
	@Id
	private String maMH;
	@NotBlank(message = "Ten Mon Hoc is required")
	private String tenMH;
}
