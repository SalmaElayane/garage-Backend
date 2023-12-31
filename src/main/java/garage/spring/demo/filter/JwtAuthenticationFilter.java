package garage.spring.demo.filter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import garage.spring.entities.CollaborateurEntity;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
private AuthenticationManager authenticationManager;
	
	public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		CollaborateurEntity collaborateurEntity=null;
		
		try {
			collaborateurEntity = new ObjectMapper().readValue(request.getInputStream(), CollaborateurEntity.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(collaborateurEntity.getUsername(),collaborateurEntity.getPassword()));
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		System.out.println("successfulAuthentication");

		User user = (User) authResult.getPrincipal();
		Algorithm algorithm = Algorithm.HMAC256("MySalma");
		String jwtAccessToken = JWT.create().withSubject(user.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis() + 50 * 60 * 1000))
				.withIssuer(request.getRequestURL().toString())
				.withClaim("username", user.getUsername())
						.withClaim("roles",
						user.getAuthorities().stream().map(ga -> ga.getAuthority()).collect(Collectors.toList()))
				.sign(algorithm);
			String jwtRefreshToken = JWT.create().withSubject(user.getUsername())
					.withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
					.withIssuer(request.getRequestURL().toString()).sign(algorithm);

		java.util.Map<String, String> idToken = new HashMap<>();
		idToken.put("jwt-access-token", jwtAccessToken);
		idToken.put("jwt-refresh-token", jwtRefreshToken);
		response.setContentType("application/json");
		new ObjectMapper().writeValue(response.getOutputStream(), idToken);
	}	
}
