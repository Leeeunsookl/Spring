package com.ohgiraffers.section03.javaconfig;

import com.ohgiraffers.common.MemberDAO;
import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        /* 필기.
        *   @ComponentScan : base package로 설정된 하위 경로에 특정 annotation을 갖고 있는 클래스를
        *   bean으로 등록해 주는 기능. 위에서부터 쫙 훑어서 찿아냄.
        *   @Component 어노테이션이 작성된 클래스를 인식하여 bean으로 등록해준다.
        *   목적에 따라서 세부 기능을 제공하는
        *   @Controller, @Service, @Repository, @Configuration 등을 사용한다.
        *  */

        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();
        for(String beanName : beanNames){
            System.out.println("beanName = " + beanName);
        }

        MemberDAO memberDAO = context.getBean("dao", MemberDAO.class);

        System.out.println(memberDAO.findMemberBySequence(1));
        System.out.println(memberDAO.save(new MemberDTO(3,"user03","pass3","eunsook3")));
        System.out.println(memberDAO.findMemberBySequence(3));
    }

}
