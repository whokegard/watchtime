package com.example.watchtime.service;

import com.example.watchtime.dao.MemberDAO;
import com.example.watchtime.model.Member;
import com.example.watchtime.model.Movie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MemberService {

    private final MemberDAO memberDAO;

    public void addMember(Member newMember) {
        memberDAO.saveMember(newMember);
    }

    public Member getMemberByID(long id) {
        return memberDAO.findMemberByID(id).orElse(null);
    }

    public void deleteMemberById(long id) {
        Member member = getMemberByID(id);
        if (member == null)
            return;

        memberDAO.deleteMemberById(id);
    }
}
