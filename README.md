package Group1.MyShell.MVC.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cryptocurrency")
public class CryptocurrencyBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name = "Date")
	private String date;

	@Column(name = "Name_of_Cryptocurrency")
	private String nameOfCryptocurrency;

	@Column(name = "Symbol_of_Cryptocurrency")
	private String symbolOfCryptocurrency;

	@Column(name = "Slug_of_Cryptocurrency")
	private String slugOfCryptocurrency;

	@Column(name = "Max_Supply")
	private Integer maxSupply;

	@Column(name = "Circulating_Supply")
	private Integer circulatingSupply;

	@Column(name = "Percent_Change_1h")
	private double percentChange1h;

	@Column(name = "Percent_Change_24h")
	private double percentChange24h;

	@Column(name = "Percent_Change_7d")
	private double percentChange7d;

	@Column(name = "Percent_Change_30d")
	private double percentChange30d;

	@Column(name = "Percent_Change_60d")
	private double percentChange60d;

	@Column(name = "Percent_Change_90d")
	private double percentChange90d;

	@Column(name = "TWD_Price_of_Cryptocurrency")
	private double TWDpriceOfCryptocurrency;

	@Column(name = "TWD_Market_Cap")
	private double TWDmarketCap;

	@Column(name = "TWD_Fully_Diluted_Market_Cap")
	private double TWDfullyDilutedMarketCap;

	@Column(name = "USD_Price_of_Cryptocurrency")
	private double USDpriceOfCryptocurrency;

	@Column(name = "USD_Market_Cap")
	private double USDmarketCap;

	@Column(name = "USD_Fully_Diluted_Market_Cap")
	private double USDfullyDilutedMarketCap;

	@Column(name = "CNY_Price_of_Cryptocurrency")
	private double CNYpriceOfCryptocurrency;

	@Column(name = "CNY_Market_Cap")
	private double CNYmarketCap;

	@Column(name = "CNY_Fully_Diluted_Market_Cap")
	private double CNYfullyDilutedMarketCap;

	@Column(name = "JPY_Price_of_Cryptocurrency")
	private double JPYpriceOfCryptocurrency;

	@Column(name = "JPY_Market_Cap")
	private double JPYmarketCap;

	@Column(name = "JPY_Fully_Diluted_Market_Cap")
	private double JPYfullyDilutedMarketCap;

	@Column(name = "EUR_Price_of_Cryptocurrency")
	private double EURpriceOfCryptocurrency;

	@Column(name = "EUR_Market_Cap")
	private double EURmarketCap;

	@Column(name = "EUR_Fully_Diluted_Market_Cap")
	private double EURfullyDilutedMarketCap;

	public CryptocurrencyBean(String date, String nameOfCryptocurrency, String symbolOfCryptocurrency,
			String slugOfCryptocurrency, Integer maxSupply, Integer circulatingSupply, double percentChange1h,
			double percentChange24h, double percentChange7d, double percentChange30d, double percentChange60d,
			double percentChange90d, double cNYpriceOfCryptocurrency, double cNYmarketCap,
			double cNYfullyDilutedMarketCap, double eURpriceOfCryptocurrency, double eURmarketCap,
			double eURfullyDilutedMarketCap, double tWDpriceOfCryptocurrency, double tWDmarketCap,
			double tWDfullyDilutedMarketCap, double uSDpriceOfCryptocurrency, double uSDNYmarketCap,
			double uSDfullyDilutedMarketCap, double jPYpriceOfCryptocurrency, double jPYmarketCap,
			double jPYfullyDilutedMarketCap) {
		super();
		this.date = date;
		this.nameOfCryptocurrency = nameOfCryptocurrency;
		this.symbolOfCryptocurrency = symbolOfCryptocurrency;
		this.slugOfCryptocurrency = slugOfCryptocurrency;
		this.maxSupply = maxSupply;
		this.circulatingSupply = circulatingSupply;
		this.percentChange1h = percentChange1h;
		this.percentChange24h = percentChange24h;
		this.percentChange7d = percentChange7d;
		this.percentChange30d = percentChange30d;
		this.percentChange60d = percentChange60d;
		this.percentChange90d = percentChange90d;
		CNYpriceOfCryptocurrency = cNYpriceOfCryptocurrency;
		CNYmarketCap = cNYmarketCap;
		CNYfullyDilutedMarketCap = cNYfullyDilutedMarketCap;
		EURpriceOfCryptocurrency = eURpriceOfCryptocurrency;
		EURmarketCap = eURmarketCap;
		EURfullyDilutedMarketCap = eURfullyDilutedMarketCap;
		TWDpriceOfCryptocurrency = tWDpriceOfCryptocurrency;
		TWDmarketCap = tWDmarketCap;
		TWDfullyDilutedMarketCap = tWDfullyDilutedMarketCap;
		USDpriceOfCryptocurrency = uSDpriceOfCryptocurrency;
		USDmarketCap = uSDNYmarketCap;
		USDfullyDilutedMarketCap = uSDfullyDilutedMarketCap;
		JPYpriceOfCryptocurrency = jPYpriceOfCryptocurrency;
		JPYmarketCap = jPYmarketCap;
		JPYfullyDilutedMarketCap = jPYfullyDilutedMarketCap;
	}

	public CryptocurrencyBean() {
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CryptocurrencyBean [date=");
		builder.append(date);
		builder.append(", nameOfCryptocurrency=");
		builder.append(nameOfCryptocurrency);
		builder.append(", symbolOfCryptocurrency=");
		builder.append(symbolOfCryptocurrency);
		builder.append(", slugOfCryptocurrency=");
		builder.append(slugOfCryptocurrency);
		builder.append(", maxSupply=");
		builder.append(maxSupply);
		builder.append(", circulatingSupply=");
		builder.append(circulatingSupply);
		builder.append(", percentChange1h=");
		builder.append(percentChange1h);
		builder.append(", percentChange24h=");
		builder.append(percentChange24h);
		builder.append(", percentChange7d=");
		builder.append(percentChange7d);
		builder.append(", percentChange30d=");
		builder.append(percentChange30d);
		builder.append(", percentChange60d=");
		builder.append(percentChange60d);
		builder.append(", percentChange90d=");
		builder.append(percentChange90d);
		builder.append(", CNYpriceOfCryptocurrency=");
		builder.append(CNYpriceOfCryptocurrency);
		builder.append(", CNYmarketCap=");
		builder.append(CNYmarketCap);
		builder.append(", CNYfullyDilutedMarketCap=");
		builder.append(CNYfullyDilutedMarketCap);
		builder.append(", EURpriceOfCryptocurrency=");
		builder.append(EURpriceOfCryptocurrency);
		builder.append(", EURmarketCap=");
		builder.append(EURmarketCap);
		builder.append(", EURfullyDilutedMarketCap=");
		builder.append(EURfullyDilutedMarketCap);
		builder.append(", TWDpriceOfCryptocurrency=");
		builder.append(TWDpriceOfCryptocurrency);
		builder.append(", TWDmarketCap=");
		builder.append(TWDmarketCap);
		builder.append(", TWDfullyDilutedMarketCap=");
		builder.append(TWDfullyDilutedMarketCap);
		builder.append(", USDpriceOfCryptocurrency=");
		builder.append(USDpriceOfCryptocurrency);
		builder.append(", USDNYmarketCap=");
		builder.append(USDmarketCap);
		builder.append(", USDfullyDilutedMarketCap=");
		builder.append(USDfullyDilutedMarketCap);
		builder.append(", JPYpriceOfCryptocurrency=");
		builder.append(JPYpriceOfCryptocurrency);
		builder.append(", JPYmarketCap=");
		builder.append(JPYmarketCap);
		builder.append(", JPYfullyDilutedMarketCap=");
		builder.append(JPYfullyDilutedMarketCap);
		builder.append("]");
		return builder.toString();
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNameOfCryptocurrency() {
		return nameOfCryptocurrency;
	}

	public void setNameOfCryptocurrency(String nameOfCryptocurrency) {
		this.nameOfCryptocurrency = nameOfCryptocurrency;
	}

	public String getSymbolOfCryptocurrency() {
		return symbolOfCryptocurrency;
	}

	public void setSymbolOfCryptocurrency(String symbolOfCryptocurrency) {
		this.symbolOfCryptocurrency = symbolOfCryptocurrency;
	}

	public String getSlugOfCryptocurrency() {
		return slugOfCryptocurrency;
	}

	public void setSlugOfCryptocurrency(String slugOfCryptocurrency) {
		this.slugOfCryptocurrency = slugOfCryptocurrency;
	}

	public Integer getMaxSupply() {
		return maxSupply;
	}

	public void setMaxSupply(Integer maxSupply) {
		this.maxSupply = maxSupply;
	}

	public Integer getCirculatingSupply() {
		return circulatingSupply;
	}

	public void setCirculatingSupply(Integer circulatingSupply) {
		this.circulatingSupply = circulatingSupply;
	}

	public double getPercentChange1h() {
		return percentChange1h;
	}

	public void setPercentChange1h(double percentChange1h) {
		this.percentChange1h = percentChange1h;
	}

	public double getPercentChange24h() {
		return percentChange24h;
	}

	public void setPercentChange24h(double percentChange24h) {
		this.percentChange24h = percentChange24h;
	}

	public double getPercentChange7d() {
		return percentChange7d;
	}

	public void setPercentChange7d(double percentChange7d) {
		this.percentChange7d = percentChange7d;
	}

	public double getPercentChange30d() {
		return percentChange30d;
	}

	public void setPercentChange30d(double percentChange30d) {
		this.percentChange30d = percentChange30d;
	}

	public double getPercentChange60d() {
		return percentChange60d;
	}

	public void setPercentChange60d(double percentChange60d) {
		this.percentChange60d = percentChange60d;
	}

	public double getPercentChange90d() {
		return percentChange90d;
	}

	public void setPercentChange90d(double percentChange90d) {
		this.percentChange90d = percentChange90d;
	}

	public double getCNYpriceOfCryptocurrency() {
		return CNYpriceOfCryptocurrency;
	}

	public void setCNYpriceOfCryptocurrency(double cNYpriceOfCryptocurrency) {
		CNYpriceOfCryptocurrency = cNYpriceOfCryptocurrency;
	}

	public double getCNYmarketCap() {
		return CNYmarketCap;
	}

	public void setCNYmarketCap(double cNYmarketCap) {
		CNYmarketCap = cNYmarketCap;
	}

	public double getCNYfullyDilutedMarketCap() {
		return CNYfullyDilutedMarketCap;
	}

	public void setCNYfullyDilutedMarketCap(double cNYfullyDilutedMarketCap) {
		CNYfullyDilutedMarketCap = cNYfullyDilutedMarketCap;
	}

	public double getEURpriceOfCryptocurrency() {
		return EURpriceOfCryptocurrency;
	}

	public void setEURpriceOfCryptocurrency(double eURpriceOfCryptocurrency) {
		EURpriceOfCryptocurrency = eURpriceOfCryptocurrency;
	}

	public double getEURmarketCap() {
		return EURmarketCap;
	}

	public void setEURmarketCap(double eURmarketCap) {
		EURmarketCap = eURmarketCap;
	}

	public double getEURfullyDilutedMarketCap() {
		return EURfullyDilutedMarketCap;
	}

	public void setEURfullyDilutedMarketCap(double eURfullyDilutedMarketCap) {
		EURfullyDilutedMarketCap = eURfullyDilutedMarketCap;
	}

	public double getTWDpriceOfCryptocurrency() {
		return TWDpriceOfCryptocurrency;
	}

	public void setTWDpriceOfCryptocurrency(double tWDpriceOfCryptocurrency) {
		TWDpriceOfCryptocurrency = tWDpriceOfCryptocurrency;
	}

	public double getTWDmarketCap() {
		return TWDmarketCap;
	}

	public void setTWDmarketCap(double tWDmarketCap) {
		TWDmarketCap = tWDmarketCap;
	}

	public double getTWDfullyDilutedMarketCap() {
		return TWDfullyDilutedMarketCap;
	}

	public void setTWDfullyDilutedMarketCap(double tWDfullyDilutedMarketCap) {
		TWDfullyDilutedMarketCap = tWDfullyDilutedMarketCap;
	}

	public double getUSDpriceOfCryptocurrency() {
		return USDpriceOfCryptocurrency;
	}

	public void setUSDpriceOfCryptocurrency(double uSDpriceOfCryptocurrency) {
		USDpriceOfCryptocurrency = uSDpriceOfCryptocurrency;
	}

	public double getUSDmarketCap() {
		return USDmarketCap;
	}

	public void setUSDmarketCap(double uSDNYmarketCap) {
		USDmarketCap = uSDNYmarketCap;
	}

	public double getUSDfullyDilutedMarketCap() {
		return USDfullyDilutedMarketCap;
	}

	public void setUSDfullyDilutedMarketCap(double uSDfullyDilutedMarketCap) {
		USDfullyDilutedMarketCap = uSDfullyDilutedMarketCap;
	}

	public double getJPYpriceOfCryptocurrency() {
		return JPYpriceOfCryptocurrency;
	}

	public void setJPYpriceOfCryptocurrency(double jPYpriceOfCryptocurrency) {
		JPYpriceOfCryptocurrency = jPYpriceOfCryptocurrency;
	}

	public double getJPYmarketCap() {
		return JPYmarketCap;
	}

	public void setJPYmarketCap(double jPYmarketCap) {
		JPYmarketCap = jPYmarketCap;
	}

	public double getJPYfullyDilutedMarketCap() {
		return JPYfullyDilutedMarketCap;
	}

	public void setJPYfullyDilutedMarketCap(double jPYfullyDilutedMarketCap) {
		JPYfullyDilutedMarketCap = jPYfullyDilutedMarketCap;
	}

}
