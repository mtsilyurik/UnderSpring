package ru.potroshitel.quotes;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

// Отвечает за обработку спрингом всех аннотаций InjectRandomInt

public class InjectRandomIntAnnotationPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields =  bean.getClass().getDeclaredFields();
        injectValue(fields, bean);
        return bean;
//        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    public void injectValue(Field[] fields, Object bean) {
        for(Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if(annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                Random random = new Random();
                int value = random.nextInt(max - min) + min;
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, value);
            }
        }
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
//        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }


}

