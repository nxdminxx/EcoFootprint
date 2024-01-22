package my.utm.ip.ecofootprint.model.DAO;

public class ElectricityDAO {
	
	private int electricityId;
	private int electricityNumOfDays;
	private double electricityUsageRM;
	private double electricityUsageKWH;
	private String electricityMethods;
	private String electricityPractices;
	private String electricityMonth;
	private long electricityPropFactor;
	private byte[] electricityBill;
	private double carbonResult;
	
	public ElectricityDAO() {
			
	    }
	
	public ElectricityDAO(int electricityId ,int electricityNumOfDays, double electricityUsageRM, double electricityUsageM3, String electricityMethods, String electricityPractices, String electricityMonth, long electricityPropFactor, byte[] electricityBill) {
		  this.electricityId = electricityId;
		  this.electricityNumOfDays = electricityNumOfDays;
		  this.electricityUsageRM = electricityUsageRM;
		  this.electricityUsageKWH = electricityUsageM3;
		  this.electricityMethods = electricityMethods;
		  this.electricityPractices = electricityPractices;
		  this.electricityMonth = electricityMonth;
		  this.electricityPropFactor = electricityPropFactor;
		  this.electricityBill = electricityBill;
	}
	
	public int getElectricityId() {
		return electricityId;
	}
	public void setElectricityId(int electricityId) {
		this.electricityId = electricityId;
	}
	
	public int getElectricityNumOfDays() {
		return electricityNumOfDays;
	}

	public void setElectricityNumOfDays(int electrictyNumOfDays) {
		this.electricityNumOfDays = electrictyNumOfDays;
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
