package entitites;

import java.util.Objects;

public class Sale {
	private Integer month;
	private Integer year;
	private String seller;
	private Integer items;
	private Double Total;
	
	public Sale() {
		
	}

	public Sale(Integer month, Integer year, String seller, Integer items, Double total) {
		
		this.month = month;
		this.year = year;
		this.seller = seller;
		this.items = items;
		Total = total;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public Integer getItems() {
		return items;
	}

	public void setItens(Integer items) {
		this.items = items;
	}

	public Double getTotal() {
		return Total;
	}
	
	public Double avaragePrice() {
		
		return Total / items;
		
	}
	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(seller);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		return Objects.equals(seller, other.seller);
	}

	@Override
	public String toString() {
		return  seller 
				+ ", $R: " 
				+ Total;
				
	}
}
