package com.company.bananablue.repository;

import com.company.bananablue.entities.Apropos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AproposRepository extends CrudRepository<Apropos, Long> {
}
