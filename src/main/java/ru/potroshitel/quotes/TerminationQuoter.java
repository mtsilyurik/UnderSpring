package ru.potroshitel.quotes;

import javax.annotation.PostConstruct;

public class TerminationQuoter implements Quoter {
    @InjectRandomInt(min=2, max=7)
    private int repeat;

    private String message;


    // Аннтоация обрабатывается бином CommonAnnotationBeanPostProccesor
    @PostConstruct
    public void init(){
        System.out.println("Phase 2");
        System.out.println(repeat);
    }

    public TerminationQuoter() {
        System.out.println("Phase 1");
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    @PostProxy // Все методы PostProxy запускаются сами после сборки бина
    public void sayQuote() {
        System.out.println("Phase 3");
        for(int i=0; i<repeat; i++) {
            System.out.println(message);
        }
    }
}
