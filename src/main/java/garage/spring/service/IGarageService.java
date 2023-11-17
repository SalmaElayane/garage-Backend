package garage.spring.service;

import java.util.List;

import garage.spring.entities.GarageEntity;


public interface IGarageService {
	public List<GarageEntity> getAllGarage();
	public void deleteGarage(Long id);
	public GarageEntity saveGarage(GarageEntity g);
	public GarageEntity updateGarage(GarageEntity g);
	public GarageEntity getOneGarage(Long id);
	
}
