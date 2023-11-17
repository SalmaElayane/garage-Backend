package garage.spring.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import garage.spring.entities.CollaborateurEntity;
@Service
@Transactional

public class UserDetailsService  implements org.springframework.security.core.userdetails.UserDetailsService {
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CollaborateurEntity collaborateurEntity = userService.findCollaborateurByUsername(username);
		System.out.println(collaborateurEntity.toString());
		Collection<GrantedAuthority> roles = new ArrayList<>();
		collaborateurEntity.getRoles().forEach(r -> {
			roles.add(new SimpleGrantedAuthority(r.getNomRole()));
		});
		return new User(collaborateurEntity.getUsername(), collaborateurEntity.getPassword(), roles);
	}
	
}
