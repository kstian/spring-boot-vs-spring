package com.github.ktarou.blogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author Jeff
 */
@SpringBootApplication
public class Application implements CommandLineRunner{
    @Autowired
    private ReportWriter reportWriter;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<String> datas = jdbcTemplate.query("SELECT name FROM employee", (rs, rowNum) -> rs.getString("name"));
        reportWriter.write(datas);
    }
}
