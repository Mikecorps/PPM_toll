package com.example.ppmtoll.web;

import javax.validation.Valid;
import com.example.ppmtoll.domain.Project;
import com.example.ppmtoll.services.MapValidationErrorService;
import com.example.ppmtoll.services.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
     return new ResponseEntity<Project>(projectservice.saveOrUpdaProject(project),HttpStatus.CREATED);   
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable String projectId){
        Project project = projectservice.findProjectByIdentifier(projectId);
        return new ResponseEntity<Project>(project,HttpStatus.OK);
    }
    @GetMapping("/all")
    public Iterable<Project> getAllProject(){
        return projectservice.findAllProjects();
    }
    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteProjectt(@PathVariable String projectId){
      projectservice.deleteProjectByIdentifier(projectId);
      return new ResponseEntity<String>("Project with Id:'" +projectId + "' was deleted", HttpStatus.OK);
    }
}
