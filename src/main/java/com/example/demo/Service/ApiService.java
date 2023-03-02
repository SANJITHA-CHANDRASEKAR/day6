package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Model.Child;
import com.example.demo.Repository.ChildRepo;

@Service
public class ApiService {
	@Autowired 
	    ChildRepo repo;

	    public List<Child> sorting(String field){
	        return repo.findAll(Sort.by(Sort.Direction.ASC,field));
	    }

	    public List<Child> setPage(@PathVariable int offset, @PathVariable int pageSize){
	        Page<Child> p = repo.findAll(PageRequest.of(offset,pageSize));
	        return p.getContent();
	    }

	    public Page<Child> pageFields(@PathVariable int offset, @PathVariable int pagesize, @PathVariable String field){
	        Pageable page = PageRequest.of(offset, pagesize, Sort.Direction.ASC,field);
	        return repo.findAll(page);
	    }
	}