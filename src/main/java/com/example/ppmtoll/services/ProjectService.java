package com.example.ppmtoll.services;


import com.example.ppmtoll.domain.Project;
import com.example.ppmtoll.repository.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    
    @Autowired
    private ProjectRepository projectRepository;
    

    public Project saveOrUpdaProject(Project project) {

      return projectRepository.save(project);
    }
}
