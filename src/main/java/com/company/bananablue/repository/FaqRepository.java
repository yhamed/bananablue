package com.company.bananablue.repository;

import com.company.bananablue.entities.Faq;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaqRepository extends CrudRepository<Faq, Long> {
}
