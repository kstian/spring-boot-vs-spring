package com.github.ktarou.blogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @author Jim
 */
@Configuration
@ComponentScan(basePackages = "com.github.ktarou.blogs")
public class Application implements ApplicationRunner{

    @Autowired
    private ReportWriter reportWriter;

    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        context.getBean(ApplicationRunner.class).run(args);
    }

    @Override
    public void run(String... args) {
        List<String> datas = Arrays.asList("Data1", "Data2", "Data3");
        reportWriter.write(datas);
    }
}

interface ApplicationRunner{
    void run(String... args);
}
