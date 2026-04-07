package com.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        try {
            Course fs = context.getBean("fullstack", Course.class);
            System.out.println(fs.getProgramName());
        } finally {
            context.close();
        }


    }

}
