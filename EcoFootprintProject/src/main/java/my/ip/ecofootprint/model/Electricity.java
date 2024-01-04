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
	
<<<<<<< Updated upstream
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

=======
	
	public Electricity(int electricityId, int electricityNumOfDays,double electricityUsageRM, double electricityUsageKWH, String electricityMethods, String electricityPractices, String electricityMonth, long electricityPropFactor, byte [] electricityBill ) {
		this.electricityId = electricityId;
		this.electrictyNumOfDays = electrictyNumOfDays;
		this.electricityUsageRM = electricityUsageRM;
		this.electricityUsageKWH = electricityUsageKWH;
		this.electricityMethods = electricityMethods;
		this.electricityPractices = electricityPractices;
		this.electricityMonth = electricityMonth;
		this.electricityPropFactor = electricityPropFactor;
		this.electricityBill = electricityBill;
		
	}
	public Electricity() {
	    this.electricityId=0;
	    this.electrictyNumOfDays=0;
	    this.electricityUsageRM=0;
	    this.electricityUsageKWH=0;
	    this.electricityMethods="";
	    this.electricityPractices="";
	    this.electricityMonth="";
	    this.electricityPropFactor= 0;
	    this.electricityBill= null;
	    

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
>>>>>>> Stashed changes
	public void setElectricityPractices(String electricityPractices) {
		this.electricityPractices = electricityPractices;
	}
	public String getElectricityMonth() {
		return electricityMonth;
	}
<<<<<<< Updated upstream

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
=======
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
>>>>>>> Stashed changes
