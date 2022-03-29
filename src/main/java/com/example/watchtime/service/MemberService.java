package com.example.watchtime.service;

import com.example.watchtime.dao.MemberDAO;
import com.example.watchtime.model.Member;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberService {

    private final MemberDAO memberDAO;

    public void addMember(Member newMember) {
        memberDAO.saveMember(newMember);
    }
}
