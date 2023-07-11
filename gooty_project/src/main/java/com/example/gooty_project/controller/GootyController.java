package com.example.gooty_project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.gooty_project.model.Gooty;
import com.example.gooty_project.repository.GootyRepository; 

// @CrossOrigin(origins="*")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController    //here we using mappings that's why used for restmap
@RequestMapping("/api")
public class GootyController {

    @Autowired
    GootyRepository GootyRepository;


    @GetMapping("/gooty")
    public ResponseEntity<List<Gooty>> getAllGooty(@RequestParam(required = false) String FirstName,String LastName) {
        // <Gooty> ---> It is generics
         List<Gooty> gooty = new ArrayList<Gooty>();                           
         GootyRepository.findAll().forEach(gooty::add);

         return  new ResponseEntity<>(gooty, HttpStatus.OK);

    }
    //create a details rest api
    @PostMapping("/gooty")
    public ResponseEntity<Gooty> CreateGooty(@RequestBody Gooty gooty) {
        Gooty _gooty = GootyRepository.save(new Gooty(gooty.getFirstName(),gooty.getLastName(),gooty.getEmail(),gooty.getPassword(),gooty.getConfirmPassword()));

        return new ResponseEntity<>(_gooty, HttpStatus.CREATED);
    }

    @PutMapping("/gooty/{id}")
    public ResponseEntity<Gooty> updateGooty(@PathVariable("id") long id, @RequestBody Gooty gooty) {
        Optional<Gooty> gootyData = GootyRepository.findById(id);

        Gooty _gooty = gootyData.get();
        _gooty.setFirstName(gooty.getFirstName());
        _gooty.setLastName(gooty.getLastName());
        _gooty.setEmail(gooty.getEmail());
        _gooty.setPassword(gooty.getPassword());
        _gooty.setConfirmPassword(gooty.getConfirmPassword());
        return new ResponseEntity<>(GootyRepository.save(_gooty), HttpStatus.OK);
        
    }

    @DeleteMapping("/gooty/{id}")
    public ResponseEntity<HttpStatus> deleteGooty(@PathVariable("id") long id) {
        try {
			GootyRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    @DeleteMapping("/gooty")
	public ResponseEntity<HttpStatus> deleteAllGooty() {
		try {
			GootyRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
