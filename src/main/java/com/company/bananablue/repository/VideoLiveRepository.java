package com.company.bananablue.repository;

import com.company.bananablue.entities.Videolive;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoLiveRepository extends CrudRepository<Videolive, Long> {
}
