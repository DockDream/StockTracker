package code;

import org.json.*;

public class Stock {
	
	// total number of stocks in the database
	static int numberOfStocks = 0;
	
	// individual stock attributes
	private String symbol;
	private String sector; // might be able to use an int here instead
	private double score;
	private double dayHigh;
	private double dayLow;
	private double sevenDayHigh;
	private double sevenDayLow;
	private double thirtyDayHigh;
	private double thirtyDayLow;
	private double volume;
	private double peRatio;
	private double eps;
	private double growthRate;
	private double debtAsset;
	private double assetLiability;
	
	public Stock(String symbol) {
		this.symbol = symbol;
	} // end default constructor
	
	
	// TODO - build full constructor after determing parsing order of metrics
	
	

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public double getDayHigh() {
		return dayHigh;
	}

	public void setDayHigh(double dayHigh) {
		this.dayHigh = dayHigh;
	}

	public double getDayLow() {
		return dayLow;
	}

	public void setDayLow(double dayLow) {
		this.dayLow = dayLow;
	}

	public double getSevenDayHigh() {
		return sevenDayHigh;
	}

	public void setSevenDayHigh(double sevenDayHigh) {
		this.sevenDayHigh = sevenDayHigh;
	}

	public double getSevenDayLow() {
		return sevenDayLow;
	}

	public void setSevenDayLow(double sevenDayLow) {
		this.sevenDayLow = sevenDayLow;
	}

	public double getThirtyDayHigh() {
		return thirtyDayHigh;
	}

	public void setThirtyDayHigh(double thirtyDayHigh) {
		this.thirtyDayHigh = thirtyDayHigh;
	}

	public double getThirtyDayLow() {
		return thirtyDayLow;
	}

	public void setThirtyDayLow(double thirtyDayLow) {
		this.thirtyDayLow = thirtyDayLow;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getPeRatio() {
		return peRatio;
	}

	public void setPeRatio(double peRatio) {
		this.peRatio = peRatio;
	}

	public double getEps() {
		return eps;
	}

	public void setEps(double eps) {
		this.eps = eps;
	}

	public double getGrowthRate() {
		return growthRate;
	}

	public void setGrowthRate(double growthRate) {
		this.growthRate = growthRate;
	}

	public double getDebtAsset() {
		return debtAsset;
	}

	public void setDebtAsset(double debtAsset) {
		this.debtAsset = debtAsset;
	}

	public double getAssetLiability() {
		return assetLiability;
	}

	public void setAssetLiability(double assetLiability) {
		this.assetLiability = assetLiability;
	}
	

} // end Stock class
