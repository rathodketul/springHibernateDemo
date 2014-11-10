
package com.SpringHibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

/**
@aurthor indianic
 */
@Repository
@Entity
@Table(name="city_master")
public class CityMaster {
	int city_id;
	String city_name;
	int state_id;
	
	@Id
	@GeneratedValue
	@Column(name="city_id")
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	
	@Column(name="city_name")
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	
	@Column(name="state_id")
	public int getState_id() {
		return state_id;
	}
	public void setState_id(int state_id) {
		this.state_id = state_id;
	}
}
