package hospital.backend.entities.dtos;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotalCustomersDto {
	
	@Id
	@Column(name="total")
	private long total;
	
	@Column(name="total_male")
	private long totalMale;
	
	@Column(name="total_female")
	private long totalFemale;
}