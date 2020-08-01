package com.powerschool.converter.writer;

import com.powerschool.converter.model.Course;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
class CSVWriter implements Writer{
    @Override
    public void writer(List<Course> data,String file) throws IOException {
        File fileObject = new File(file);
        FileOutputStream outputStream = new FileOutputStream(fileObject);

        writeRow(outputStream, "Course Title", "Course Code", "Section Title", "Section Code");

        for(Course course: data){
            writeRow(outputStream, course.getCourseTitle(), course.getCourseCode(), course.getSectionTitle(), course.getSectionCode());
        }

        outputStream.close();
    }

    private void writeRow(FileOutputStream outputStream, String s, String s2, String s3, String s4) throws IOException {
        outputStream
                .write(constructString
                        (s, s2,
                                s3, s4)
                        .getBytes());
    }

    private String constructString(String courseTitle,String courseCode,String sectionTitle,String sectionCode) {
        StringBuilder str = new StringBuilder();
        str.append(courseTitle+",");
        str.append(courseCode+",");
        str.append(sectionTitle+",");
        str.append(sectionCode+"\n");
        return str.toString();
    }
}
