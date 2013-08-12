package com.benwwest.notify.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HttpRequest")
public class Notification {
	
	private long id;
	private String params;
	private String headers;
	private String date;
	
	
	public Notification(){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
		date = sdf.format(cal.getTime());
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	
	@Column(name="PARAMS")
	public String getParams() {
		return params;
	}
	
	public void setParams(String params) {
		this.params = params;
	}

	@Column(name="HEADERS")
	public String getHeaders() {
		return headers;
	}

	public void setHeaders(String headers) {
		this.headers = headers;
	}

	@Column(name="NOWDATE")
	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}
	
	
}
