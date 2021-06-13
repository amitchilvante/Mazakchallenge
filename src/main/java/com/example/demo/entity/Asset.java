package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Asset {

	@Id
	private Integer id;
	
	private String alias;
	
	@JsonIgnore
	@OneToMany(mappedBy = "asset")
	private List<Data> dataList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}


	public List<Data> getDataList() {
		return dataList;
	}

	public void setDataList(List<Data> dataList) {
		this.dataList = dataList;
	}

	@Override
	public String toString() {
		return "Asset [id=" + id + ", alias=" + alias + "]";
	}
}
