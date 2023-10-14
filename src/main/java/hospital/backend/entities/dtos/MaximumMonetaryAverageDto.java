package hospital.backend.entities.dtos;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaximumMonetaryAverageDto {
	
	@Id
	@Column(name="label")
	private String label;
	
	@Column(name="monetary_avg")
	private double monetaryAvg;
}