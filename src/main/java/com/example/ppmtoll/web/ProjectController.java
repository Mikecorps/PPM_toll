package com.example.ppmtoll.web;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import com.example.ppmtoll.domain.Project;
import com.example.ppmtoll.services.MapValidationErrorService;
import com.example.ppmtoll.services.ProjectService;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    
    @Autowired
    private ProjectService projectservice;

    @Autowired
    private MapValidationErrorService validationErrorService;
    @PostMapping("")
    public ResponseEntity<?> createNewproject(@Valid @RequestBody Project project, BindingResult result){
      
        ResponseEntity<?> errorMap = validationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;

     Project project2 = projectservice.saveOrUpdaProject(project);
     return new ResponseEntity<Project>(project,HttpStatus.CREATED);   
    }
}
