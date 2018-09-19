package com.hniu.controller;
/*
 * 用户管理
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hniu.constant.StateCode;
import com.hniu.entity.User;
import com.hniu.service.UserService;
import com.hniu.util.State;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	public Base base;
	
	public StateCode StateCode;
	
	@GetMapping("/getUserAll")
	public State<Object> getUserAll(){
		
		return userService.getUserAll();
	}
	
	@PostMapping("/insertUser")
	public State<Object> insertUser(@RequestBody User user) {
		if(user == null) {
	    	return base.packaging(StateCode.FAIL, "参数不能为空",user);
	    }
		return userService.insertUser(user);
	}
	
	@GetMapping("/getUserId")
    public State<Object> getUser(Integer id){
		if(id == null){
			return base.packaging(StateCode.FAIL, "参数不能为空",id);
		}
        return  userService.getUser(id);
    }
	
    @PutMapping("/updateUser")	
	public State<Object> updateUser(@RequestBody User user) {
    	if(user == null){
    		return base.packaging(StateCode.FAIL, "参数不能为空",user);
		}
		return userService.updateUser(user);
	}
    
    @DeleteMapping("/deleteUser")
    public State<Object> deleteUser(Integer id) {
    	if(id == null){
    		return base.packaging(StateCode.FAIL, "参数不能为空",id);
		}
    	return userService.deleteUser(id);
    }
	
	
}