package hospital.backend.entities.dtos;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChurnByPredictionDto {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="customer_id")
	private int customerId;
	
	@Column(name="prediction")
	private int prediction;
	
	@Column(name="pred_prob")
	private double predProb;
}