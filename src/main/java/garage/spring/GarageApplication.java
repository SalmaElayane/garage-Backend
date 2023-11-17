package garage.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import garage.spring.entities.CollaborateurEntity;
import garage.spring.entities.GarageEntity;
import garage.spring.entities.RoleEntity;
import garage.spring.repository.ICollaborateurRepository;
import garage.spring.repository.IGarageRepository;
import garage.spring.repository.IRoleRepository;

@SpringBootApplication
public class GarageApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GarageApplication.class, args);
	}
	
	@Autowired
	ICollaborateurRepository collaborateurRepository;
	@Autowired
	IRoleRepository roleRepository;
	
	@Autowired
	IGarageRepository garageRepository;
	
	@Autowired
	 PasswordEncoder passwordEncoder;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		GarageEntity g1=new GarageEntity();
		g1.setDescriptions("garage lmard");
		g1.setLieux("rabat");
		g1.setNomGarage("hamoda");
		
		RoleEntity r=new RoleEntity();
		r.setDescription("admin");

		r.setNomRole("admin");
		
		roleRepository.save(r);
		RoleEntity r1=new RoleEntity();
		r1.setDescription("salma");

		r1.setNomRole("salma");
		
		roleRepository.save(r1);
		
		GarageEntity g2=new GarageEntity();
		g2.setDescriptions("garage lwil");
		g2.setLieux("sla");
		g2.setNomGarage("rahma");
		garageRepository.save(g1);
		garageRepository.save(g2);
		
		CollaborateurEntity c1=new CollaborateurEntity();
		c1.setUsername("admin");
		c1.setPassword(passwordEncoder.encode("admin"));
		c1.setGarage(g2);
		c1.setGarage(g1);
		c1.getRoles().add(r);
		c1.getRoles().add(r1);
		collaborateurRepository.save(c1);
		
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
