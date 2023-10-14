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
@Table(name="employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employees {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="employees_id")
	private int employeesId;
	
	@Column(name="ad_soyad")
	private String adSoyad;
	
	@Column(name="mail")
	private String mail;
	
	@Column(name="gorev")
	private String gorev;
	
	@Column(name="kat")
	private int kat;
	
	@Column(name="bolum")
	private String bolum;
	
	@Column(name="telefon")
	private Long telefon;
	
	@Column(name="state")
	private  String state;
	
	@Column(name="meslek")
	private String meslek;
	
	@Column(name="resim")
	private String resim;
	
	@Column(name="sira")
	private String sira;
	
	@Column(name="queue")
	private int queue;
	
	
}