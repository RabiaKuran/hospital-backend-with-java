package hospital.backend.entities.concretes;

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
@Table(name = "mbl_user_table")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MblUserTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "user_password")
	private String password;
	
	@Column(name = "user_email")
	private String eMail;
	
	@Column(name = "telefon")
	private Long telefon;


}
