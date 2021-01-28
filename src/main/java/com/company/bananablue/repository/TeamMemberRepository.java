package com.company.bananablue.repository;

import com.company.bananablue.entities.TeamMember;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMemberRepository  extends CrudRepository<TeamMember, Long> {
}
