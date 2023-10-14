package hospital.backend.requests;

import lombok.Data;

@Data
public class RefreshRequest {
	
	Long userId;
	String refreshToken;
}