package commom.demo;
/**
 * 工作经历情况表
 * */
public class Storycircs {
	private int storyCircsId;//工作经历情况Id
	private int vindicatorID;//维护人员ID
	private String StartTime;//开始时间
	private String endTime;//结束时间
	private String jobAdress;//任职企业
	private String business;//职务
	private String dimission;//离职原因
	public int getStoryCircsId() {
		return storyCircsId;
	}
	public void setStoryCircsId(int storyCircsId) {
		this.storyCircsId = storyCircsId;
	}
	public int getVindicatorID() {
		return vindicatorID;
	}
	public void setVindicatorID(int vindicatorID) {
		this.vindicatorID = vindicatorID;
	}
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getJobAdress() {
		return jobAdress;
	}
	public void setJobAdress(String jobAdress) {
		this.jobAdress = jobAdress;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	public String getDimission() {
		return dimission;
	}
	public void setDimission(String dimission) {
		this.dimission = dimission;
	}
}
