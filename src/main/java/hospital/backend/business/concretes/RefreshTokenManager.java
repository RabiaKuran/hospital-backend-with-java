package hospital.backend.business.concretes;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import hospital.backend.dataAccess.abstracts.RefreshTokenDao;
import hospital.backend.entities.concretes.RefreshToken;
import hospital.backend.entities.concretes.UserTable;

@Service
public class RefreshTokenManager {

	@Value("${refresh.token.expires.in}")
	Long expireSeconds;
	
	private RefreshTokenDao refreshTokenDao;

	public RefreshTokenManager(RefreshTokenDao refreshTokenDao) {
		super();
		this.refreshTokenDao = refreshTokenDao;
	}
	
	public String createRefreshToken(UserTable user) {
		RefreshToken token = refreshTokenDao.findByUserId(user.getId());
		if(token == null) {
			token =	new RefreshToken();
			token.setUser(user);
		}
		token.setToken(UUID.randomUUID().toString());
		token.setExpiryDate(Date.from(Instant.now().plusSeconds(expireSeconds)));
		refreshTokenDao.save(token);
		return token.getToken();
	}
	
	public boolean isRefreshExpired(RefreshToken token) {
		return token.getExpiryDate().before(new Date());
	}
	
	public RefreshToken getByUser(Long userId) {
		return refreshTokenDao.findByUserId(userId);	
	}
}