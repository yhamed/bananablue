package com.company.bananablue.restful;

import com.company.bananablue.entities.Category;
import com.company.bananablue.entities.GridHome;
import com.company.bananablue.entities.Sponsor;
import com.company.bananablue.repository.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/sponsor")
public class SponserResource {

    @Autowired
    private SponsorRepository sponsorRepository;

    @GetMapping(value = "/findall")
    public ResponseEntity<List<Sponsor>> findAllSponsor() {
        return new ResponseEntity(ResourceUtils.toList(sponsorRepository.findAll()), HttpStatus.OK);
    }
    @PostMapping(value = "/create")
    public ResponseEntity<Sponsor> createSponsor(@RequestBody Sponsor sponsor) {
        return new ResponseEntity(sponsorRepository.save(sponsor), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Category> deleteSponsor(@PathVariable(value = "id") Long id) {
        try {
            sponsorRepository.deleteById(id);
        } catch (Exception ex) {
            return  new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
