package com.example.ppmtoll.web;

import com.example.ppmtoll.domain.Project;
import com.example.ppmtoll.services.ProjectService;

import org.aspectj.apache.bcel.classfile.Module.Provide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    
    @Autowired
    private ProjectService projectservice;

    @PostMapping("")
    public ResponseEntity<Project> createNewproject(@RequestBody Project project){
     Project project2 = projectservice.saveOrUpdaProject(project);
     return new ResponseEntity<Project>(project,HttpStatus.CREATED);   
    }
}
