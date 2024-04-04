package com.ohgiraffers.common;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository("dao")
public class MemberDAO {
    //Database Access Object

    private final Map<Integer, MemberDTO> memberMap;        //가상을 먼저 만든다

    public MemberDAO(){
        this.memberMap =new HashMap<>();        //초기화

        this.memberMap.put(1,new MemberDTO(1,"user01","pass01","eunsook"));
        this.memberMap.put(2,new MemberDTO(2,"user02","pass02","eunsook2"));
    }

    public MemberDTO findMemberBySequence(int sequence){
        return memberMap.get(sequence);
    }       //난 sequence로 정보를 받아오겠어

    public boolean save(MemberDTO member){

        int before = memberMap.size();

        memberMap.put(member.getSequence(),member);

        int after = memberMap.size();

        return after>before? true : false;

    }
}
