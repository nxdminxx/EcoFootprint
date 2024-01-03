package my.ip.ecofootprint.service;

import java.util.List;

import my.ip.ecofootprint.model.Electricity;

public interface ElectricityService {

	 List<Electricity> getAllElectricity();
	 Electricity getElectricityById(int electricityId);
	 Electricity addElectricity(final Electricity electricity);
	 Electricity updateElectricity(final Electricity electricity);
	 public boolean deleteElectricity(int electricityId);
}
