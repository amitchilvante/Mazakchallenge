package com.example.demo.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Data {

	@Id
	private Integer id;
	
	private Date timestamp;
	
	private String status;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "operating_param_id",referencedColumnName = "id")
	private OperatingParams operatingParams;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="asset_id")
	private Asset asset;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Parent_id")
	private Parent parent;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public OperatingParams getOperatingParams() {
		return operatingParams;
	}

	public void setOperatingParams(OperatingParams operatingParams) {
		this.operatingParams = operatingParams;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Data [id=" + id + ", timestamp=" + timestamp + ", status=" + status + ", operatingParams="
				+ operatingParams + ", asset=" + asset + ", parent=" + parent + "]";
	}
}
