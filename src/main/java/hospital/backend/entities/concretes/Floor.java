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
@Table(name="floor")
@AllArgsConstructor
@NoArgsConstructor
public class Floor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="kat_id")
	private int katId;
	
	@Column(name="kat")
	private int kat;
	
	@Column(name="oda_no")
	private String odaNo;
	
	@Column(name="durum")
	private String durum;
	 
	@Column(name="bilgi")
	private String bilgi;
	
	
	
	
}