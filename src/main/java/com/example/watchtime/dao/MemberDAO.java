package com.example.watchtime.dao;

import com.example.watchtime.model.Member;
import com.example.watchtime.model.Movie;
import com.example.watchtime.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class MemberDAO {

    private final MemberRepository memberRepository;

    public Member saveMember(Member newMember) {
        return memberRepository.save(newMember);
    }

    public Optional<Member> findMemberByID(long id) {
        return memberRepository.findById(id);
    }

    public void deleteMemberById(long id) {
        memberRepository.deleteById(id);
    }

    public Iterable<Member> getAllMembers() {
        return memberRepository.findAll();
    }
}
