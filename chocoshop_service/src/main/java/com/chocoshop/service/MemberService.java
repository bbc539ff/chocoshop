package com.chocoshop.service;

import com.chocoshop.mapper.MemberMapper;
import com.chocoshop.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    public List<Member> search(Member member){
        try {
            return memberMapper.search(member);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
