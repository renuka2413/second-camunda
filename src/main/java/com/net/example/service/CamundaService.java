package com.net.example.service;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.camunda.bpm.engine.runtime.ProcessInstantiationBuilder;
import org.camunda.bpm.engine.variable.VariableMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CamundaService {
        
	@Value("${employee}")
	public String emp;
	
	ProcessInstantiationBuilder instance;
	ProcessInstanceWithVariables response;

	public Object triggerProcess(String processKey) throws Exception{
		
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        instance = engine.getRuntimeService().createProcessInstanceByKey(processKey);
        instance.setVariable("employee", emp);
        response = instance.executeWithVariablesInReturn();
        VariableMap variables = response.getVariables();
        System.out.println(variables.get("getEmployee"));
        System.out.println("getEmp="+variables.get("getEmployee"));
        return  variables.get("getEmployee");
	}
	
	

	public String getEmployee(String varName) {
      
		System.out.println(varName);
		return varName;
	}
}
