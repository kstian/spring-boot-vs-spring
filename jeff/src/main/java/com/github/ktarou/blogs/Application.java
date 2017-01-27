package com.github.ktarou.blogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

/**
 * @author Jeff
 */
@SpringBootApplication
public class Application implements CommandLineRunner{
    @Autowired
    private ReportWriter reportWriter;

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<String> datas = Arrays.asList("Data1", "Data2", "Data3");
        reportWriter.write(datas);
    }
}
