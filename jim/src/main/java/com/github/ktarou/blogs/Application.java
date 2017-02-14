package com.github.ktarou.blogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        context.getBean(ApplicationRunner.class).run(args);
    }

    @Override
    public void run(String... args) {
        List<String> datas = jdbcTemplate.query("SELECT name FROM employee", (rs, rowNum) -> rs.getString("name"));
        reportWriter.write(datas);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        DataSource dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).build();
        return new JdbcTemplate(dataSource);
    }
}

interface ApplicationRunner{
    void run(String... args);
}
