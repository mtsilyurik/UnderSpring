package ru.potroshitel.quotes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        TerminationQuoter quoter = context.getBean(TerminationQuoter.class, "quoter");


    }
}
