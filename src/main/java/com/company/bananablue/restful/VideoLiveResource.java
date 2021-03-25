package com.company.bananablue.restful;

import com.company.bananablue.entities.Category;
import com.company.bananablue.entities.Sponsor;
import com.company.bananablue.entities.Videolive;
import com.company.bananablue.repository.VideoLiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/live")
public class VideoLiveResource {

    @Autowired
    private VideoLiveRepository videoLiveRepository;

    @GetMapping(value = "/findall")
    public ResponseEntity<List<Videolive>> findAllVideoLive() {
        return new ResponseEntity(ResourceUtils.toList(videoLiveRepository.findAll()), HttpStatus.OK);
    }
    @PostMapping(value = "/create")
    public ResponseEntity<Videolive> createFaq(@RequestBody Videolive videolive) {
        return new ResponseEntity(videoLiveRepository.save(videolive), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable(value = "id") Long id) {
        try {
            videoLiveRepository.deleteById(id);
        } catch (Exception ex) {
            return  new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
