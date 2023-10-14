package hospital.backend.entities.dtos;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AveragePriceByFrequencyDto {
	
	@Id
	@Column(name="frequency")
	private int frequency;
	
	@Column(name="avgPrice")
	private double avgPrice;
}