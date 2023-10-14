package hospital.backend.entities.dtos;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AverageRecencyCltvPRecencyDto {
	
	@Id
	@Column(name="urunId")
	private int urunId;
	
	@Column(name="urun_kategori")
	private String urunKategori;	
	
	
	@Column(name="urun_adi")
	private String urunAdi;
	
	@Column(name="urun_adedi")
	private int urunAdedi;

}