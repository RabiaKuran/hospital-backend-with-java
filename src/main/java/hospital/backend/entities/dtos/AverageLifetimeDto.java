package hospital.backend.entities.dtos;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AverageLifetimeDto {
	
	@Id
	@Column(name="cltv_p_segment")
	private String cltvPSegment;
	
	@Column(name="cltv_p")
	private double cltvP;
}