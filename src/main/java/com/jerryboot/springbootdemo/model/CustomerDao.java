package com.jerryboot.springbootdemo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository // DAO都要寫
public interface CustomerDao extends JpaRepository<Customer, Integer> {

	// HQL語法
//	@Query(value="from Customer where name =:name0") // 指Customer的名字name=:name0要跟@Param("name0")對應到
//	public List<Customer> findCustomerByName(@Param("name0") String name);

	@Query(value = "from Customer where name=:name")
	public List<Customer> findCustomerByName(@Param("name") String name);

	// 原生SQL語法，要加nativeQuery=true來啟用原生SQL
//	@Query(value="SELECT * FROM customer WHERE name=:name1",nativeQuery = true)
//	public List<Customer> findCustomerByName2(@Param("name1") String name);

	@Query(value="SELECT * FROM customer WHERE name=:name1",nativeQuery = true)
	public List<Customer> findCustomerByName2(@Param("name1") String name);

	@Query(value = "SELECT * FROM customer WHERE name=:name2 AND level= :level", nativeQuery = true)
	public List<Customer> findCustomerByName3(@Param("name2") String name, @Param("level") Integer level);

//	?1=第一個參數
//	@Query(value = "DELETE FROM customer WHERE name=?1", nativeQuery = true)
//	@Transactional
//	@Modifying // 沒有Service Annotaion標註此項的話，要再修改資料的地方標註
//	public void deleteCustomerByName(String name);
	
	
	@Query(value="DELETE FROM customer WHERE name=:name",nativeQuery = true)
	@Modifying
	@Transactional //對方方法前後進行攔截，在執行完目標方法之後根據執行情況提交或是rollback
	public void deleteCustomerByName(String name);
	
	@Query(value="DELETE FROM customer WHERE id=:id",nativeQuery = true)
	@Transactional
	@Modifying
	public void deleteCustomerById(Integer id);
	

	public List<Customer> findBylevelOrderByIdDesc(Integer level);
}
