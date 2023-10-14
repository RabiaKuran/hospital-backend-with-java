package hospital.backend.requests;

import lombok.Data;

@Data
public class UserRequest {

	String adSoyad;
	String userName;
	String password;
}