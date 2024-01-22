package my.utm.ip.ecofootprint.model.DAO;

import java.util.Date;

public class RecycleDAO {
	
	private int recycleId;
	private Date recycleStartDate;
	private Date recycleEndDate;
	private String recycleType;
	private double recycleTotalInKG;
	private String recycleDescribeMethod;
	private String[] recycleHabits;
	private double recycelAccumulatedTotalInRM;
	private String recycleChallengePractice;
	private byte[] recycleProof;
	private double carbonResult;
	
	public RecycleDAO() {
		this.recycleId = 0;
        this.recycleStartDate = null;
        this.recycleEndDate = null;
        this.recycleType = "";
        this.recycleTotalInKG = 0.0;
        this.recycleDescribeMethod = "";
        this.recycleHabits = null;
        this.recycelAccumulatedTotalInRM = 0.0;
        this.recycleChallengePractice = "";
        this.recycleProof = null;
    }
	
	
	public RecycleDAO(int recycleId,Date recycleStartDate, Date recycleEndDate, String recycleType, double recycleTotalInKG,
			String recycleDescribeMethod, String[] recycleHabits, double recycelAccumulatedTotalInRM,
			String recycleChallengePractice, byte[] recycleProof) 
	{
		this.recycleId = recycleId;
		this.recycleStartDate = recycleStartDate;
		this.recycleEndDate = recycleEndDate;
		this.recycleType = recycleType;
		this.recycleTotalInKG = recycleTotalInKG;
		this.recycleDescribeMethod = recycleDescribeMethod;
		this.recycleHabits = recycleHabits;
		this.recycelAccumulatedTotalInRM = recycelAccumulatedTotalInRM;
		this.recycleChallengePractice = recycleChallengePractice;
		this.recycleProof = recycleProof;
	}

	public int getRecycleId() {
		return recycleId;
	}

	public void setRecycleId(int recycleId) {
		this.recycleId = recycleId;
	}
	
	

	public Date getRecycleStartDate() {
		return recycleStartDate;
	}

	public void setRecycleStartDate(Date recycleStartDate) {
		this.recycleStartDate = recycleStartDate;
	}
	
	

	public Date getRecycleEndDate() {
		return recycleEndDate;
	}

	public void setRecycleEndDate(Date recycleEndDate) {
		this.recycleEndDate = recycleEndDate;
	}
	
	

	public String getRecycleType() {
		return recycleType;
	}

	public void setRecycleType(String recycleType) {
		this.recycleType = recycleType;
	}
	
	

	public double getRecycleTotalInKG() {
		return recycleTotalInKG;
	}

	public void setRecycleTotalInKG(double recycleTotalInKG) {
		this.recycleTotalInKG = recycleTotalInKG;
	}
	
	

	public String getRecycleDescribeMethod() {
		return recycleDescribeMethod;
	}

	public void setRecycleDescribeMethod(String recycleDescribeMethod) {
		this.recycleDescribeMethod = recycleDescribeMethod;
	}
	
	

	public String[] getRecycleHabits() {
		return recycleHabits;
	}

	public void setRecycleHabits(String[] recycleHabits) {
		this.recycleHabits = recycleHabits;
	}
	
	

	public double getRecycelAccumulatedTotalInRM() {
		return recycelAccumulatedTotalInRM;
	}

	public void setRecycelAccumulatedTotalInRM(double recycelAccumulatedTotalInRM) {
		this.recycelAccumulatedTotalInRM = recycelAccumulatedTotalInRM;
	}
	
	

	public String getRecycleChallengePractice() {
		return recycleChallengePractice;
	}

	public void setRecycleChallengePractice(String recycleChallengePractice) {
		this.recycleChallengePractice = recycleChallengePractice;
	}
	
	

	public byte[] getRecycleProof() {
		return recycleProof;
	}

	public void setRecycleProof(byte[] recycleProof) {
		this.recycleProof = recycleProof;
	}
	
	 public double getCarbonResult() {
		    return carbonResult;
		 }

		 public void setCarbonResult(double carbonResult) {
			 this.carbonResult = carbonResult;
		 }

}

