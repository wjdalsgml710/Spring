package DI06;

public class Family {
	String papaName;
	String mamiName;
	String siseterName;
	String brotherName;
	
	public Family(String papaName, String mamiName) {
		this.papaName = papaName;
		this.mamiName = mamiName;
	}

	public String getPapaName() {
		return papaName;
	}

	public void setPapaName(String papaName) {
		this.papaName = papaName;
	}

	public String getMamiName() {
		return mamiName;
	}

	public void setMamiName(String mamiName) {
		this.mamiName = mamiName;
	}

	public String getSiseterName() {
		return siseterName;
	}

	public void setSiseterName(String siseterName) {
		this.siseterName = siseterName;
	}

	public String getBrotherName() {
		return brotherName;
	}

	public void setBrotherName(String brotherName) {
		this.brotherName = brotherName;
	}

}
