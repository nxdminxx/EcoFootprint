package my.ip.ecofootprint.model;

public class Electricity {
	private int electricityId;
	private int electrictyNumOfDays;
	private double electricityUsageRM;
	private double electricityUsageKWH;
	private String electricityMethods;
	private String electricityPractices;
	private String electricityMonth;
	private long electricityPropFactor;
	private byte[] electricityBill;
	
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
}