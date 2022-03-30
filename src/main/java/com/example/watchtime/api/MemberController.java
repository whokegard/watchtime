package com.example.watchtime.api;

import com.example.watchtime.model.Member;
import com.example.watchtime.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/members")
@AllArgsConstructor
public class MemberController {

    @Autowired
    private final MemberService memberService;

    @PostMapping
    public void addMember(@RequestBody Member newMember) {
        memberService.addMember(newMember);
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable("id") long id) {
        return memberService.getMemberByID(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMemberById(@PathVariable("id") long id) {
        memberService.deleteMemberById(id);
    }

}
