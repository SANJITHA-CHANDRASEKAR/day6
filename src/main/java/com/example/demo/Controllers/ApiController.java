package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Child;
import com.example.demo.Repository.ChildRepo;
import com.example.demo.Service.ApiService;

@RestController
public class ApiController {
	
	    @Autowired
	        ChildRepo rep;
	    @Autowired
	        ApiService ser;
	    
	    @PostMapping("/")
	        public Child posting(@PathVariable Child obj){
	            return rep.save(obj);
	        }
	    @GetMapping("/{field}")
	        public List<Child> getbyfeild (@PathVariable String field){
	            return ser.sorting(field);
	        }
	    @GetMapping("/{offet}/{pagesize}")
	        public List<Child> pagination(@PathVariable int offset, @PathVariable int pagesize){
	            return ser.setPage(offset, pagesize);
	        }
	    @GetMapping("/{offset}/{pagesize}/{field}")
	        public Page<Child> pageField(@PathVariable int offset, @PathVariable int pagesize, @PathVariable String field){
	            return ser.pageFields(offset,pagesize,field);
	        }
}
