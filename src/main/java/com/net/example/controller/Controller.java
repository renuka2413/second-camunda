package com.net.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.net.example.service.CamundaService;

@RestController
@RequestMapping("/api")
public class Controller {
           
	@Autowired
	private CamundaService camundaService;
	
	@GetMapping("/process-instance/{processKey}")
    public Object getCamunda(@PathVariable String processKey) throws Exception {
        return camundaService.triggerProcess(processKey);
	}
	
	@GetMapping("/process-instance/getEmployee/{varName}")
    public String getEmployee(@PathVariable String varName) {
       return camundaService.getEmployee(varName);
	}
}
