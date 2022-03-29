package com.example.watchtime.dao;

import com.example.watchtime.model.Member;
import com.example.watchtime.reprository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class MemberDAO {

    private final MemberRepository memberRepository;

    public void saveMember(Member newMember) {
        memberRepository.save(newMember);
    }
}
