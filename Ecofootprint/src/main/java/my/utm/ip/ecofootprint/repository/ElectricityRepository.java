package my.utm.ip.ecofootprint.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import my.utm.ip.ecofootprint.model.DAO.ElectricityDAO;

@Repository
public interface ElectricityRepository {

	List<ElectricityDAO> getAllElectricity();

	ElectricityDAO getElectricityById(int electricityId);

	ElectricityDAO addElectricity(ElectricityDAO electricity);

	ElectricityDAO updateElectricity(ElectricityDAO electricity);

	public boolean deleteElectricity(int electricityId);

    int getElectricityIdByUserId(int userId);
    
}

