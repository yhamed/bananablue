package com.company.bananablue.restful;

import com.company.bananablue.entities.Category;
import com.company.bananablue.entities.Faq;
import com.company.bananablue.entities.GridHome;
import com.company.bananablue.repository.GridhomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/grid")
public class GridHomeResource {

    @Autowired
    private GridhomeRepository gridhomeRepository;

    @GetMapping(value = "/findall")
    public ResponseEntity<List<GridHome>> findAllGrids() {
        return new ResponseEntity(ResourceUtils.toList(gridhomeRepository.findAll()), HttpStatus.OK);
    }
    @PostMapping(value = "/create")
    public ResponseEntity<GridHome> createGrid(@RequestBody GridHome gridHome) {
        return new ResponseEntity(gridhomeRepository.save(gridHome), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Category> deleteGrid(@PathVariable(value = "id") Long id) {
        try {
            gridhomeRepository.deleteById(id);
        } catch (Exception ex) {
            return  new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
