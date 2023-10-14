package hospital.backend.entities.dtos;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaxPriceDto {
	
	@Id
	@Column(name="total_product_quantity")
	private int totalProductQuantity;
	
	@Column(name="max_price_male")
	private double maxPriceMale;
	
	@Column(name="max_price_female")
	private double maxPriceFemale;
}