package com.example.watchtime.service;

import com.example.watchtime.dao.MemberDAO;
import com.example.watchtime.model.Member;
import com.example.watchtime.model.Movie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService {

    private final MemberDAO memberDAO;

    public void addMember(Member newMember) {
        memberDAO.saveMember(newMember);
    }

    public List<Member> getAllMembers() {
        return (List<Member>) memberDAO.getAllMembers();
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

    public Member getMemberByUsernameAndPass(String username, String password) {
        Optional<Member> potentialMember = getAllMembers().stream()
                .filter(member -> member.getUsername().equalsIgnoreCase(username))
                .filter(m -> m.getPassword().equals(password))
                .findFirst();

        return potentialMember.orElse(null);
    }
}
