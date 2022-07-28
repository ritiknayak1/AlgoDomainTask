package com.example.assignment.vo;

public class ProductPriceRangeVo {
	
	private int minPrice;
	private int maxPrice;
	public int getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}
	public int getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}
	@Override
	public String toString() {
		return "ProductPriceRangeVo [minPrice=" + minPrice + ", maxPrice=" + maxPrice + "]";
	}
	public ProductPriceRangeVo(int minPrice, int maxPrice) {
		super();
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
	}
	public ProductPriceRangeVo() {
		super();
	}
	

}
