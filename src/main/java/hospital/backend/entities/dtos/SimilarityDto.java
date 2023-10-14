package hospital.backend.entities.dtos;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimilarityDto {
	
	@Id
	@Column(name="id")
	private long id;
	
	@Column(name="antecedents")
	private String antecedents;
	
	@Column(name="consequents")
	private String consequents;
	
	@Column(name="support")
	private double support;
	
	@Column(name="confidence")
	private double confidence;
	
	@Column(name="lift")
	private double lift;
}