package garage.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import garage.spring.entities.GarageEntity;
import garage.spring.repository.IGarageRepository;
import garage.spring.service.IGarageService;
@Service

public class GarageService implements IGarageService{

	@Autowired
	private IGarageRepository garageRepository;
	
	@Override
	public List<GarageEntity> getAllGarage() {
		List<GarageEntity> list=garageRepository.findAll();
		return list;
	}

	@Override
	public void deleteGarage(Long id) {
		garageRepository.deleteById(id);
		
	}

	@Override
	public GarageEntity saveGarage(GarageEntity g) {
		GarageEntity garage=garageRepository.save(g);
		return garage;
	}

	@Override
	public GarageEntity updateGarage(GarageEntity g) {
		GarageEntity garage=garageRepository.save(g);
		return garage ;
	}

	@Override
	public GarageEntity getOneGarage(Long id) {
		GarageEntity g=garageRepository.findById(id).orElse(new GarageEntity());
		return g ;
	}

}
