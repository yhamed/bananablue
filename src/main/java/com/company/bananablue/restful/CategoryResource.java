package com.company.bananablue.restful;

import com.company.bananablue.entities.Apropos;
import com.company.bananablue.entities.Category;
import com.company.bananablue.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/category")
public class CategoryResource {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping(value = "/findall")
    public ResponseEntity<List<Category>> findAllCategories() {
        return new ResponseEntity(ResourceUtils.toList(categoryRepository.findAll()), HttpStatus.OK);
    }
    @PostMapping(value = "/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return new ResponseEntity(categoryRepository.save(category), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable(value = "id") Long id) {
        try {
            categoryRepository.deleteById(id);
        } catch (Exception ex) {
            return  new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

}
