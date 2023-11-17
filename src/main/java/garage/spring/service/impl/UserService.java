package garage.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import garage.spring.entities.CollaborateurEntity;
import garage.spring.repository.ICollaborateurRepository;
import garage.spring.service.ICollaborateurService;

@Service
public class UserService implements ICollaborateurService {
	@Autowired
	private ICollaborateurRepository collaborateurRepository;



	@Override
	public CollaborateurEntity findCollaborateurByUsername(String username) {
		CollaborateurEntity user = null;
		try {
			user = collaborateurRepository.findUserByUsername(username);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
	}
}
