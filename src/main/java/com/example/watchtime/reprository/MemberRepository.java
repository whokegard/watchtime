package com.example.watchtime.reprository;

import com.example.watchtime.model.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
