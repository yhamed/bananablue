package com.company.bananablue.repository;

import com.company.bananablue.entities.CarouselEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarouselEntryRepository extends CrudRepository<CarouselEntry, Long> {
}
