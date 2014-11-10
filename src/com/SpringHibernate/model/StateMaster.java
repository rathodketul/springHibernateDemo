
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
@Table(name="state_master")
public class StateMaster {
	int state_id;
	String state_name;
	
	@Id
	@GeneratedValue
	@Column(name="state_id")
	public int getState_id() {
		return state_id;
	}
	public void setState_id(int state_id) {
		this.state_id = state_id;
	}
	
	@Column(name="state_name")
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	
	
	
}
