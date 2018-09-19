package com.hniu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hniu.constant.StateCode;
import com.hniu.entity.CourseType;
import com.hniu.service.CurriculumStatisticsService;
import com.hniu.util.State;

/*
 * 课程类别管理管理
 */

@RestController
public class CourseManagementController {

	@Autowired
	private CurriculumStatisticsService curriculumStatisticsService;
	
	public Base base;
	
	public StateCode StateCode;
	
	@PostMapping("/insertcurriculum")
	public  State<Object> insertcurriculum(@RequestBody CourseType courseType) {
		if(courseType == null) {
	    	return base.packaging(StateCode.FAIL, "参数不能为空",courseType);
	    }
		return curriculumStatisticsService.insertcurriculum(courseType);
	}
	
	@GetMapping("/getcurriculum")
	public State<Object> getcurriculum(Integer id) {
		if(id == null) {
	    	return base.packaging(StateCode.FAIL, "参数不能为空",id);
	    }
		return curriculumStatisticsService.getcurriculum(id);
	}
	
	@PutMapping("/updatecurriculum")
    public State<Object> updatecurriculum(@RequestBody CourseType courseType) {
		if(courseType == null) {
	    	return base.packaging(StateCode.FAIL, "参数不能为空",courseType);
	    }
		return curriculumStatisticsService.updatecurriculum(courseType);
	}
	
	@PutMapping("/deletecurriculum")
    public State<Object> deletecurriculum(Integer id) {
		if (id == null) {
			return base.packaging(StateCode.FAIL, "参数不能为空",id);
		}
		return curriculumStatisticsService.deletecurriculum(id);
	}
	
	
	
}