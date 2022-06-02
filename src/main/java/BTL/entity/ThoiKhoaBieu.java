package BTL.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ThoiKhoaBieu {
	@Id
	private String maSV;
	private String maKH;
	private float diem;
}
