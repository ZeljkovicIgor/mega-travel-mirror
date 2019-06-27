package com.megatravel.mainbackend.dto;

import java.util.List;

public class SearchAccommodationDTO {
	
	private String city;
	private String startDate;
	private String endDate;
	private int people;
	private Long accTypeId;
	private Long categoryId;
	private List<Long> addServices;
	
	public SearchAccommodationDTO() {
		super();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public Long getAccTypeId() {
		return accTypeId;
	}

	public void setAccTypeId(Long accTypeId) {
		this.accTypeId = accTypeId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public List<Long> getAddServices() {
		return addServices;
	}

	public void setAddServices(List<Long> addServices) {
		this.addServices = addServices;
	}
	
}
