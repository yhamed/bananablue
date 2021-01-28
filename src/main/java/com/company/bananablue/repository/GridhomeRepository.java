package com.company.bananablue.repository;

import com.company.bananablue.entities.GridHome;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GridhomeRepository extends CrudRepository<GridHome, Long> {
}
