package hospital.backend.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="products")
@AllArgsConstructor
@NoArgsConstructor
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="urun_id")
	private int urunId;
	
	@Column(name="urun_kategori")
	private String urunKategori;
	
	@Column(name="urun_adi")
	private String urunAdi;
	
	@Column(name="urun_adedi")
	private int urunAdedi;
	
	@Column(name="urun_bilgi")
	private String urunBilgi;
	
	@Column(name="urun_tarih")
	private String urunTarih;
	
	@Column(name="urun_resmi")
	private String urunResmi;
	
}