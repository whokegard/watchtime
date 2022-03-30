package com.example.watchtime.repository;

import com.example.watchtime.model.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
