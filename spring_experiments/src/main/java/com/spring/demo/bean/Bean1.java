package com.spring.demo.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component(value="bean1")
public class Bean1 implements BeanInterface {

}
