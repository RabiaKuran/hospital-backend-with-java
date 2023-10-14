package hospital.backend.responses;

import java.util.Set;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AuthResponse {
	
	String message;
	Long userId;
	String accessToken;
	String refreshToken;
	@SuppressWarnings("rawtypes")
	Set role;
}