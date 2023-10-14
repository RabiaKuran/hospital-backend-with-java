package hospital.backend.entities.dtos;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerLifetimeValueDto {
	
	@Id
	@Column(name="thousand")
	private long thousand;
	
	@Column(name="five_thousand")
	private long fiveThousand;
	
	@Column(name="ten_thousand")
	private long tenThousand;
	
	@Column(name="fifteen_thousand")
	private long fifteenThousand;
	
	@Column(name="twenty_thousand")
	private long twentyThousand;
	
	@Column(name="twentyfive_thousand")
	private long twentyfiveThousand;
	
	@Column(name="thirty_thousand")
	private long thirtyThousand;
}