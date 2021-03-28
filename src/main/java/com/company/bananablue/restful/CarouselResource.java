package com.company.bananablue.restful;

import com.company.bananablue.entities.Carousel;
import com.company.bananablue.entities.CarouselEntry;
import com.company.bananablue.repository.CarouselEntryRepository;
import com.company.bananablue.repository.CarouselRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/carousel")
public class CarouselResource {

    @Autowired
    private CarouselRepository carouselRepository;

    @Autowired
    private CarouselEntryRepository carouselEntryRepository;

    @GetMapping(value = "/findall")
    public ResponseEntity<List<Carousel>> getCarousels() {
        return new ResponseEntity<>(ResourceUtils.toList(carouselRepository.findAll()), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Carousel> createCarousel(@RequestBody Carousel carousel) {
       return new ResponseEntity(carouselRepository.save(carousel), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteCarousel(@PathVariable(value = "id") Long id) {
        try {
            carouselRepository.deleteById(id);
        } catch (Exception ex) {
            return  new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }


    @PostMapping(value = "/create/item/{id}")
    public ResponseEntity createCarouselItem(@RequestBody CarouselEntry carouselEntry, @PathVariable(value = "id") Long id) {
       try {
           carouselEntry.setCarousel(carouselRepository.findById(id).orElseThrow());
           carouselEntryRepository.save(carouselEntry);
       } catch (Exception ex) {
           return  new ResponseEntity(HttpStatus.BAD_REQUEST);
       }
        return new ResponseEntity(HttpStatus.OK);

    }

    @GetMapping(value = "/findall/item/{id}")
    public ResponseEntity<List<CarouselEntry>> findAllCarouselItems(@PathVariable(value = "id") Long id) {
        List<CarouselEntry> carouselEntries = new ArrayList<>();
        try {
            carouselEntries=  carouselRepository.findById(id).orElseThrow(() -> new Exception()).getItems();
           if(carouselEntries.isEmpty()) {
               throw new Exception("No carousel entries found");
           }
        } catch (Exception ex) {
            return  new ResponseEntity(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(carouselEntries, HttpStatus.OK);

    }

    @DeleteMapping(value = "/delete/item/{id}")
    public ResponseEntity deleteCarouselItem(@PathVariable(value = "id") Long id) {
        try {
            carouselEntryRepository.deleteById(id);
        } catch (Exception ex) {
            return  new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
