package com.SpringHibernate.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name="user_detail")
public class UserMaster {
	
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="email_address")
	private String email_address;
	
	@Column(name="password")
	private String password;
	
	@Column(name="address")
	private String address;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="state_id")
	private StateMaster state_master;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="city_id")
	private CityMaster city_master;
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public StateMaster getState_master() {
		return state_master;
	}

	public void setState_master(StateMaster state_master) {
		this.state_master = state_master;
	}

	public CityMaster getCity_master() {
		return city_master;
	}

	public void setCity_master(CityMaster city_master) {
		this.city_master = city_master;
	}
}
