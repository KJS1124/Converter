package com.powerschool.converter;

import com.powerschool.converter.model.Course;
import com.powerschool.converter.reader.Reader;
import com.powerschool.converter.writer.Writer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@SpringBootApplication
public class ConverterApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(ConverterApplication.class, args);
    }

    @Autowired
    Reader reader;

    @Autowired
    Writer writer;

    @Override
    public void run(ApplicationArguments args) throws IOException {
        String jsonFile = "C:\\Users\\Karanjot Singh\\IdeaProjects\\converter\\Data.json";
        String csvFile = "C:\\Users\\Karanjot Singh\\IdeaProjects\\converter\\Output.csv";
        String data = new String(Files.readAllBytes(Paths.get(jsonFile)));

        List<Course> courses = reader.read(data);
        writer.writer(courses,csvFile);

    }
}
