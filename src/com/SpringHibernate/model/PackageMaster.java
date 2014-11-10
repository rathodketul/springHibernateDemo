package com.SpringHibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Subscription_Master")
public class PackageMaster {
	int id;
	int state_id;
	int city_id;
	String package_title;
	String unit;
	int min_unit_charged;
	String journey_type;
	boolean status;
	
	@Id
	@GeneratedValue
	@Column(name="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="state_id")
	public int getState_id() {
		return state_id;
	}
	public void setState_id(int state_id) {
		this.state_id = state_id;
	}
	
	@Column(name="city_id")
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	
	@Column(name="package_title")
	public String getPackage_title() {
		return package_title;
	}
	public void setPackage_title(String package_title) {
		this.package_title = package_title;
	}
	
	@Column(name="unit")
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	@Column(name="min_unit_charged")
	public int getMin_unit_charged() {
		return min_unit_charged;
	}
	public void setMin_unit_charged(int min_unit_charged) {
		this.min_unit_charged = min_unit_charged;
	}
	
	@Column(name="journey_type")
	public String getJourney_type() {
		return journey_type;
	}
	public void setJourney_type(String journey_type) {
		this.journey_type = journey_type;
	}
	
	@Column(name="status")
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
