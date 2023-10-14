package hospital.backend.business.concretes;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hospital.backend.dataAccess.abstracts.UserDao;
import hospital.backend.entities.concretes.UserTable;
import hospital.backend.security.JwtUserDetails;

@Service
public class UserDetailsManager implements UserDetailsService {

	private UserDao userDao;
	
	public UserDetailsManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserTable user = userDao.findByUserName(username);
		return JwtUserDetails.create(user);
	}
	
	public UserDetails loadUserById(Long id) {
		UserTable user = userDao.findById(id).get();
		return JwtUserDetails.create(user);
	}
}