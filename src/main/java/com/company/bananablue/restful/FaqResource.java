package com.company.bananablue.restful;


import com.company.bananablue.entities.Category;
import com.company.bananablue.entities.Faq;
import com.company.bananablue.repository.FaqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/faq")
public class FaqResource {

    @Autowired
    private FaqRepository faqRepository;

    @GetMapping(value = "/findall")
    public ResponseEntity<List<Faq>> findAllFaq() {
        return new ResponseEntity(ResourceUtils.toList(faqRepository.findAll()), HttpStatus.OK);
    }
    @PostMapping(value = "/create")
    public ResponseEntity<Faq> createFaq(@RequestBody Faq faq) {
        return new ResponseEntity(faqRepository.save(faq), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Category> deleteFaq(@PathVariable(value = "id") Long id) {
        try {
            faqRepository.deleteById(id);
        } catch (Exception ex) {
            return  new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
