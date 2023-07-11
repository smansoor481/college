package com.example.gooty_project.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.gooty_project.model.Gooty;



public interface GootyRepository extends CrudRepository<Gooty, Long> {
    
}
