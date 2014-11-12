
package com.SpringHibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

/**
	@aurthor indianic
 */
@Repository
@Entity
@Table(name="city_master")
public class CityMaster {
	
	@Id
	@GeneratedValue
	@Column(name="city_id")
	private int city_id;
	
	@Column(name="city_name")
	private String city_name;
	
	@ManyToOne
	@JoinColumn(name="state_id")
	private StateMaster state_master;
	
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public StateMaster getState_master() {
		return state_master;
	}
	public void setState_master(StateMaster state_master) {
		this.state_master = state_master;
	}
}
