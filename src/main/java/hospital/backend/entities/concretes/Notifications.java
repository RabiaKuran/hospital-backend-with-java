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
@Table(name="notifications")
@AllArgsConstructor
@NoArgsConstructor
public class Notifications {
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
	
	@Column(name="notifications")
	private String notifications;
	
	@Column(name="durum")
	private String durum;
	
	@Column(name="tarih")
	private String tarih;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="odaNo")
	private String odaNo;
	
	
}
