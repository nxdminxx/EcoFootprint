package my.utm.ip.ecofootprint.model.DAO;

public class WaterDAO {

	private int waterId;
	private int waterNumOfDays;
	private double waterUsageRM;
	private double waterUsageM3;
	private String waterMethods;
	private String waterPractices;
	private String waterMonth;
	private long waterPropFactor;
	private byte[] waterBill;
	private double carbonResult;
	
	public WaterDAO() {
		
    }
	
	public WaterDAO(int waterId ,int waterNumOfDays, double waterUsageRM, double waterUsageM3, String waterMethods, String waterPractices, String waterMonth, long waterPropFactor, byte[] waterBill, double carbonResult) {
		  this.waterId = waterId;
		  this.waterNumOfDays = waterNumOfDays;
		  this.waterUsageRM = waterUsageRM;
		  this.waterUsageM3 = waterUsageM3;
		  this.waterMethods = waterMethods;
		  this.waterPractices = waterPractices;
		  this.waterMonth = waterMonth;
		  this.waterPropFactor = waterPropFactor;
		  this.waterBill = waterBill;
		  this.carbonResult = carbonResult;
	}

	public int getWaterId() {
		return waterId;
	}
	
	public void setWaterId(int waterId) {
		this.waterId = waterId;
	}
	
	public int getWaterNumOfDays() {
		return waterNumOfDays;
	}
	
	public void setWaterNumOfDays(int waterNumOfDays) {
		this.waterNumOfDays = waterNumOfDays;
	}
	
	public double getWaterUsageRM() {
		return waterUsageRM;
	}
	
	public void setWaterUsageRM(double waterUsageRM) {
		this.waterUsageRM = waterUsageRM;
	}
	
	public double getWaterUsageM3() {
		return waterUsageM3;
	}
	
	public void setWaterUsageM3(double waterUsageM3) {
		this.waterUsageM3 = waterUsageM3;
	}
	
	public String getWaterMethods() {
		return waterMethods;
	}
	
	public void setWaterMethods(String waterMethods) {
		this.waterMethods = waterMethods;
	}
	public String getWaterPractices() {
		return waterPractices;
	}
	
	public void setWaterPractices(String waterPractices) {
		this.waterPractices = waterPractices;
	}
	
	public String getWaterMonth() {
		return waterMonth;
	}
	
	public void setWaterMonth(String waterMonth) {
		this.waterMonth = waterMonth;
	}
	
	public long getWaterPropFactor() {
		return waterPropFactor;
	}
	
	public void setWaterPropFactor(long waterPropFactor) {
		this.waterPropFactor = waterPropFactor;
	}
	
	public byte[] getWaterBill() {
		return waterBill;
	}
	
	public void setWaterBill(byte[] waterBill) {
		this.waterBill = waterBill;
	}
	
	 public double getCarbonResult() {
	    return carbonResult;
	 }

	 public void setCarbonResult(double carbonResult) {
		 this.carbonResult = carbonResult;
	 }
	
}

