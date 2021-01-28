package com.company.bananablue.repository;

import com.company.bananablue.entities.Sponsor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SponsorRepository extends CrudRepository<Sponsor, Long> {
}
