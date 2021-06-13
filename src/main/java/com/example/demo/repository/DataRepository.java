package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Data;

@Repository
public interface DataRepository extends JpaRepository<Data, Integer>{
	@Query(value="select * from data where status like %:status%",nativeQuery = true)
	public List<Data> findDataByStatus(@Param("status") String status);
	public Data findDataById(@Param("Id") Integer Id);
}
