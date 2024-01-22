package my.utm.ip.ecofootprint.model;

import my.utm.ip.ecofootprint.model.DAO.ElectricityDAO;

public class Electricity {

	// DTO
	private int electricityId;
	private int electrictyNumOfDays;
	private double electricityUsageRM;
	private double electricityUsageKWH;
	private String electricityMethods;
	private String electricityPractices;
	private String electricityMonth;
	private long electricityPropFactor;
	private byte[] electricityBill;
	private double carbonResult;

	// DB -> Repo -> DAO -> Service -> DTO -> Controller -> view
	// view -> controller -> DTO -> Service -> DAO -> Repo -> DB

	public Electricity() {

	}

	// convert DAO to DTO obj
	public Electricity(ElectricityDAO dao) {
		this.electricityId = dao.getElectricityId();
		this.electrictyNumOfDays = dao.getElectricityNumOfDays();
		this.electricityUsageRM = dao.getElectricityUsageRM();
		this.electricityUsageKWH = dao.getElectricityUsageKWH();
		this.electricityMethods = dao.getElectrictiyMethods();
		this.electricityPractices = dao.getElectricityPractices();
		this.electricityMonth = dao.getElectricityMonth();
		this.electricityPropFactor = dao.getElectricityPropFactor();
		this.electricityBill = dao.getElectricityBill();
		this.carbonResult = dao.getCarbonResult();
	}

	// convert DTO to DAO
	public ElectricityDAO toDAO() {
		ElectricityDAO dao = new ElectricityDAO();
		dao.setElectricityId(electricityId);
		return dao;
	}

	public Electricity(int electricityId, int electrictyNumOfDays, double electricityUsageRM,
			double electricityUsageKWH, String electricityMethods, String electricityPractices, String electricityMonth,
			long electricityPropFactor, byte[] electricityBill, double carbonResult) {
		this.electricityId = electricityId;
		this.electrictyNumOfDays = electrictyNumOfDays;
		this.electricityUsageRM = electricityUsageRM;
		this.electricityUsageKWH = electricityUsageKWH;
		this.electricityMethods = electricityMethods;
		this.electricityPractices = electricityPractices;
		this.electricityMonth = electricityMonth;
		this.electricityPropFactor = electricityPropFactor;
		this.electricityBill = electricityBill;
		this.carbonResult = carbonResult;
	}

	public int getElectricityId() {
		return electricityId;
	}

	public void setElectricityId(int electricityId) {
		this.electricityId = electricityId;
	}

	public int getElectrictyNumOfDays() {
		return electrictyNumOfDays;
	}

	public void setElectrictyNumOfDays(int electrictyNumOfDays) {
		this.electrictyNumOfDays = electrictyNumOfDays;
	}

	public double getElectricityUsageRM() {
		return electricityUsageRM;
	}

	public void setElectricityUsageRM(double electrictyUsageRM) {
		this.electricityUsageRM = electrictyUsageRM;
	}

	public double getElectricityUsageKWH() {
		return electricityUsageKWH;
	}

	public void setElectricityUsageKWH(double electrictyUsageKWH) {
		this.electricityUsageKWH = electrictyUsageKWH;
	}

	public String getElectrictiyMethods() {
		return electricityMethods;
	}

	public void setElectricityMethods(String electrictyMethods) {
		this.electricityMethods = electrictyMethods;
	}

	public String getElectricityPractices() {
		return electricityPractices;
	}

	public void setElectricityPractices(String electricityPractices) {
		this.electricityPractices = electricityPractices;
	}

	public String getElectricityMonth() {
		return electricityMonth;
	}

	public void setElectricityMonth(String electricityMonth) {
		this.electricityMonth = electricityMonth;
	}

	public long getElectricityPropFactor() {
		return electricityPropFactor;
	}

	public void setElectricityPropFactor(long electricityPropFactor) {
		this.electricityPropFactor = electricityPropFactor;
	}

	public byte[] getElectricityBill() {
		return electricityBill;
	}

	public void setElectricityBill(byte[] electricityBill) {
		this.electricityBill = electricityBill;
	}

	public double getCarbonResult() {
		return carbonResult;
	}

	public void setCarbonResult(double carbonResult) {
		this.carbonResult = carbonResult;
	}
}
