package hospital.backend.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hospital.backend.business.concretes.RefreshTokenManager;
import hospital.backend.business.concretes.UserManager;
import hospital.backend.dataAccess.abstracts.UsersRolesDao;
import hospital.backend.entities.concretes.RefreshToken;
import hospital.backend.entities.concretes.UserTable;
import hospital.backend.entities.concretes.UsersRoles;
import hospital.backend.requests.RefreshRequest;
import hospital.backend.requests.UserRequest;
import hospital.backend.responses.AuthResponse;
import hospital.backend.security.JwtTokenProvider;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
	
	private AuthenticationManager authenticationManager;
	private JwtTokenProvider jwtTokenProvider;
	private PasswordEncoder passwordEncoder;
	private RefreshTokenManager refreshTokenManager;
	private UserManager userManager;
	private UsersRolesDao userRolesDao;
	
	 @Autowired
	public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider,
			PasswordEncoder passwordEncoder, RefreshTokenManager refreshTokenManager, UserManager userManager,
			UsersRolesDao userRolesDao) {
		super();
		this.authenticationManager = authenticationManager;
		this.jwtTokenProvider = jwtTokenProvider;
		this.passwordEncoder = passwordEncoder;
		this.refreshTokenManager = refreshTokenManager;
		this.userManager = userManager;
		this.userRolesDao = userRolesDao;
	}

	@PostMapping("/login")
	public AuthResponse  login(@RequestBody UserRequest loginRequest) {
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword());
		Authentication auth = authenticationManager.authenticate(authToken);	
		SecurityContextHolder.getContext().setAuthentication(auth);
		String jwtToken = jwtTokenProvider.generateJwtToken(auth);
		UserTable user = userManager.getOneUserByUserName(loginRequest.getUserName());
		AuthResponse authResponse = new AuthResponse();
		authResponse.setAccessToken("Bearer " + jwtToken);
		authResponse.setRefreshToken(refreshTokenManager.createRefreshToken(user));
		authResponse.setUserId(user.getId());
		authResponse.setRole(user.getRole());
		System.out.println("The operation is successful.");
		System.out.println(user.getUserName());
		return authResponse;
	}
	
	@PostMapping("/register")
	public ResponseEntity<AuthResponse> register(@RequestBody UserRequest registerRequest) {
		AuthResponse authResponse = new AuthResponse();
		if(userManager.getOneUserByUserName(registerRequest.getUserName()) != null) {
			authResponse.setMessage("Username already in use.");
			return new ResponseEntity<>(authResponse, HttpStatus.BAD_REQUEST);
		}
	
		UserTable user = new UserTable();
		user.setUserName(registerRequest.getUserName());
		user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
	
		userManager.saveOneUser(user);
		
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(registerRequest.getUserName(), registerRequest.getPassword());
		Authentication auth = authenticationManager.authenticate(authToken);
		SecurityContextHolder.getContext().setAuthentication(auth);
		String jwtToken = jwtTokenProvider.generateJwtToken(auth);
		
		authResponse.setMessage("User successfully registered.");
		authResponse.setAccessToken("Bearer " + jwtToken);
		authResponse.setRefreshToken(refreshTokenManager.createRefreshToken(user));
		authResponse.setUserId(user.getId());	
 
		return new ResponseEntity<>(authResponse, HttpStatus.CREATED);		
	}
	
	@PostMapping("/updateRole")
	public void updateRole(@RequestBody UsersRoles userRoles) {
		userRolesDao.save(userRoles);
	}
	
	@PostMapping("/refresh")
	public ResponseEntity<AuthResponse> refresh(@RequestBody RefreshRequest refreshRequest) {
		AuthResponse response = new AuthResponse();
		RefreshToken token = refreshTokenManager.getByUser(refreshRequest.getUserId());
		if(token.getToken().equals(refreshRequest.getRefreshToken()) &&
				!refreshTokenManager.isRefreshExpired(token)) {

			UserTable user = token.getUser();
			String jwtToken = jwtTokenProvider.generateJwtTokenByUserId(user.getId());
			response.setMessage("Token successfully refreshed.");
			response.setAccessToken("Bearer " + jwtToken);
			response.setUserId(user.getId());
			return new ResponseEntity<>(response, HttpStatus.OK);		
		} else {
			response.setMessage("Refresh token is not valid.");
			return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
		}
	}
}