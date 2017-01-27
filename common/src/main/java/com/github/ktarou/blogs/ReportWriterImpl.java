package com.github.ktarou.blogs;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class ReportWriterImpl implements ReportWriter{

    @Override
    public void write(List<String> datas) {
        for (String data : datas) {
            System.out.println(data);
        }
    }
}
