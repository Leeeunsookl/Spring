package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.Bean;

public class ContextConfiguration {

    @Bean
    public MemberDTO getMember(){
        return new MemberDTO(1,"user01","pass01","leeeunsook");
    }
}
