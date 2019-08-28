package com.chocoshop.mapper;

import com.chocoshop.model.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberMapper extends tk.mybatis.mapper.common.Mapper<Member> {
}
