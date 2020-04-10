package com.goldenlibrary.mgtsystem.controllers;

import java.util.Optional;

import com.goldenlibrary.mgtsystem.models.Member;
import com.goldenlibrary.mgtsystem.repositories.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MemberController {
    @Autowired
    MemberRepository memberRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/members")
    public Iterable<Member> member() {
        return memberRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/members")
    public Member save(@RequestBody Member member) {
        memberRepository.save(member);
        return member;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/members/{id}")
    public Optional<Member> show(@PathVariable String id) {
        return memberRepository.findById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "members/{id}")
    public Member update(@PathVariable String id, @RequestBody Member member) {
        Optional<Member> optMember = memberRepository.findById(id);
        Member m = optMember.get();

        if (member.getFname() != null) {
            m.setFname(member.getFname());
        }

        if (member.getLname() != null) {
            m.setLname(member.getLname());
        }

        if (member.getAddress() != null) {
            m.setAddress(member.getAddress());
        }

        if (member.getContactNo() != null) {
            m.setContactNo(member.getContactNo());
        }

        if (member.getDob() != null) {
            m.setDob(member.getDob());
        }

        if (member.getEmail() != null) {
            m.setEmail(member.getEmail());
        }

        memberRepository.save(m);

        return m;
    }

    public String delete(@PathVariable String id) {
        Optional<Member> optMember = memberRepository.findById(id);
        Member m = optMember.get();

        memberRepository.delete(m);

        return "deleted";
    }

}