package com.jerryboot.springbootdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jerryboot.springbootdemo.model.Customer;
import com.jerryboot.springbootdemo.model.CustomerDao;

@RestController // 表示本Class回傳的都是JSON格式
public class CustomerAPI {
	@Autowired
	private CustomerDao dao;

	@PostMapping("customer/insert")
	public Customer insertCustomer() {
		Customer cus = new Customer();
		cus.setName("館長");
		cus.setLevel(3);
		Customer resCus = dao.save(cus);
		return resCus;
	}

	@PostMapping("customer/insert2")
	public Customer insertCustomer2(@RequestBody Customer cus) {
		// @RequestBody:丟進來的傳到Controller內的
		// @ResponseBody:丟回去的。傳到Contrller外的
		Customer resCus = dao.save(cus);
		return resCus;
	}

//	public Customer insertCustomer2(@RequestBody Customer cus) {
//		Customer rescus = dao.save(cus);
//		return rescus;
//		
//	}

	@PostMapping("customer/insert3")
	public List<Customer> insertCustomer3(@RequestBody List<Customer> cus) {
		// @RequestBody:傳到Controller內的
		// @Respo nseBody:傳到Contrller外的
		List<Customer> resCus = dao.saveAll(cus);
		return resCus;
	}

//	@PostMapping("customer/insert3")
//	public List<Customer> insertCustomer3(@RequestBody List<Customer> cus){
//		List<Customer> rescus = dao.saveAll(cus);
//		return rescus;
//	}

//	@GetMapping("customer/get")
//	public Customer getCustomerById(@RequestParam("id") Integer id) {
//		// http://localhost:8080/myapp/customer/get?id=
//		Optional<Customer> optional = dao.findById(id);
//
//		if (optional.isPresent()) {
//			Customer resCus = optional.get();
//			return resCus;
//		}
//
//		return null;
//	}
	@GetMapping("/customer/get")
	public Customer getCustomerById(@RequestParam("id") Integer id) {
		Optional<Customer> optional = dao.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@GetMapping("customer/get2/{id}") // 路徑變數的寫法
	public Customer getCustomerById2(@PathVariable Integer id) {
		// http://localhost:8080/myapp/customer/get?id=
		Optional<Customer> optional = dao.findById(id);

		if (optional.isPresent()) {
			Customer resCus = optional.get();
			return resCus;
		}

		return null;
	}

	@GetMapping("customer/getall")
	public List<Customer> getAllCustomer() {
		// http://localhost:8080/myapp/customer/get?id=
		List<Customer> customerList = dao.findAll();

		if (customerList.isEmpty() != true) {
			return customerList;
		}

		return null;
	}

	@GetMapping("customer/delete/{id}") // 路徑變數寫法
	public void deleteCustomer(@PathVariable Integer id) {
		dao.deleteById(id);
	}

	@GetMapping("customer/delete2")
	public void deleteCustomer2(@RequestParam Integer id) {
		Customer cus = dao.getById(id);
		dao.delete(cus);
	}

	@GetMapping(value = "customer/page/{pageNumber}")
	public List<Customer> findByPage(@PathVariable Integer pageNumber) {
		PageRequest pgb = PageRequest.of(pageNumber - 1, 3, Sort.Direction.ASC, "id");
		Page<Customer> page = dao.findAll(pgb);
		List<Customer> list = page.getContent();
		return list;

	}

//	@GetMapping("customer/page/{pageNumber}")
//	public List<Customer> findByPage(@PathVariable Integer pageNumber) {
//		PageRequest pgb = PageRequest.of(pageNumber - 1, 3, Sort.Direction.ASC, "id");
//		// (頁數,一頁幾筆資料,排序方式,排序依照)
//		Page<Customer> page = dao.findAll(pgb);
//		List<Customer> list = page.getContent();
//		return list;
//	}
	@GetMapping("/customer/findbyName")
	public List<Customer> findByName(@RequestParam("name") String name) {
		List<Customer> list = dao.findCustomerByName(name);
		return list;
	}

//	@GetMapping("customer/findbyName")
//	public List<Customer> findByName(@RequestParam("name") String name) {
//		List<Customer> list = dao.findCustomerByName(name);
//		return list;
//	}

//	@GetMapping("customer/findbyName2")
//	public List<Customer> findByName2(@RequestParam("name") String name) {
//		List<Customer> list = dao.findCustomerByName2(name);
//		return list;
//	}
	@GetMapping("customer/findbyName2")
	public List<Customer> findByName2(@RequestParam("name") String name) {
		return dao.findCustomerByName2(name);
	}

	@GetMapping("customer/findbyName3")
	public List<Customer> findByName3(@RequestParam("name") String name, @RequestParam("level") Integer level) {
		List<Customer> list = dao.findCustomerByName3(name, level);
		return list;
	}

	@GetMapping("customer/delete")
	public boolean deleteCustomer(@RequestParam("name")String name) {
		List<Customer> findByName2 = findByName2(name);
		if(findByName2.isEmpty()==false) {
			dao.deleteCustomerByName(name);
			return true;
		}
		return false;
	}



	@GetMapping("customer/delete3")
	public boolean deleteCustomer3(@RequestParam("id") Integer id) {
		Optional<Customer> resCus = dao.findById(id);
		if (resCus.isPresent()) {
			Integer targetId = resCus.get().getId();
			dao.deleteCustomerById(targetId);
			return true;
		}
		return false;
	}

	@GetMapping("customer/level/{level}")
	public List<Customer> findBylevelOrderByIdDesc(@PathVariable("level") Integer level) {
		return dao.findBylevelOrderByIdDesc(level);
	}

}
