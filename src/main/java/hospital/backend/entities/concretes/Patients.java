package hospital.backend.entities.concretes;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name="patient")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Patients {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="h_id")
	private int hId;
	
	@Column(name="rad_soyad")
	private String radSoyad;
	
	@Column(name="ad_soyad")
	private String adSoyad;
	
	@Column(name="cad_soyad")
	private String cadSoyad;
	
	@Column(name="yatis_sebebi")
	private String yatisSebebi;
	
	@Column(name="oda_no")
	private String odaNo;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name = "telefon")
	private Long telefon;
	
	@Column(name = "birth_date")
	private String birthDate;
	
	@Column(name = "giris_tarihi")
	private String girisTarihi;
	
	
	
	
	
}