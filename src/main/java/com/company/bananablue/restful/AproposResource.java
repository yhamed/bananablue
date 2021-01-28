package com.company.bananablue.restful;

import com.company.bananablue.entities.Apropos;
import com.company.bananablue.entities.Carousel;
import com.company.bananablue.entities.CarouselEntry;
import com.company.bananablue.entities.TeamMember;
import com.company.bananablue.repository.AproposRepository;
import com.company.bananablue.repository.TeamMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/apropos")
public class AproposResource {
    @Autowired
    private AproposRepository aproposRepository;

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @GetMapping(value = "/findall")
    public ResponseEntity<List<Apropos>> getApropos() {
        return new ResponseEntity<>(ResourceUtils.toList(aproposRepository.findAll()), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Apropos> createApropos(@RequestBody Apropos apropos) {
        return new ResponseEntity(aproposRepository.save(apropos), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteApropos(@PathVariable(value = "id") Long id) {
        try {
            aproposRepository.deleteById(id);
        } catch (Exception ex) {
            return  new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }


    @PostMapping(value = "/create/item/{id}")
    public ResponseEntity createAproposTeamMember(@RequestBody TeamMember teamMemberRequest, @PathVariable(value = "id") Long id) {
        try {
           TeamMember teamMember = teamMemberRepository.save(teamMemberRequest);
           Optional<Apropos> aproposOptional = aproposRepository.findById(id);
           if(aproposOptional.isPresent()) {
               Apropos apropos = aproposOptional.get();
               apropos.getMemberList().add(teamMember);
           aproposRepository.save(apropos);
               return new ResponseEntity(teamMember,HttpStatus.OK);
           }
           throw new Exception("There was a problem creating the entity TeamMember");
        } catch (Exception ex) {
            return  new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/findall/item/{id}")
    public ResponseEntity<List<TeamMember>> findAllTeamMembers(@PathVariable(value = "id") Long id) {
        List<TeamMember> teamMembers = new ArrayList<>();
        try {
       Apropos apropos = aproposRepository.findById(id).orElseThrow();
       if(!apropos.getMemberList().isEmpty()) {
           return new ResponseEntity(apropos.getMemberList(), HttpStatus.OK);
       }
            throw new Exception("no TeamMember was found");
        } catch (Exception ex) {
            return  new ResponseEntity(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping(value = "/delete/item/{id}")
    public ResponseEntity deleteTeamMember(@PathVariable(value = "id") Long id) {
        try {
            teamMemberRepository.deleteById(id);
        } catch (Exception ex) {
            return  new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

}
