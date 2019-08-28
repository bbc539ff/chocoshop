package com.chocoshop.service;

import com.chocoshop.mapper.MemberMapper;
import com.chocoshop.model.Member;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MemberService {

    @Autowired
    MemberMapper memberMapper;

    public List<Member> showAllMembers(){
        return memberMapper.selectAll();
    }

    public int addMember(Member member){
        return memberMapper.insert(member);
    }

    public int deleteMember(Member member){
        return memberMapper.delete(member);
    }

    public int updateMember(Member member){
        return memberMapper.updateByPrimaryKeySelective(member);
    }
}
