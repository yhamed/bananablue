package com.company.bananablue.repository;

import com.company.bananablue.entities.Carousel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarouselRepository extends CrudRepository<Carousel, Long> {
}
