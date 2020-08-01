package com.powerschool.converter.reader;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.powerschool.converter.model.Course;
import com.powerschool.converter.util.Parser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JsonReader implements Reader{

    @Value("${course.cTitle}")
    private String courseTitle;
    @Value("${course.cCode}")
    private String courseCode;
    @Value("${course.sTitle}")
    private String sectionTitle;
    @Value("${course.sCode}")
    private String sectionCode;



    @Override
    public List<Course> read(String data) {
        List<Course> result = new LinkedList<>();
        JsonElement root = Parser.parse(data);
        Set<Map.Entry<String, JsonElement>> entries = root.getAsJsonObject().entrySet();
        for(Map.Entry entry : entries){
            Course course = getCourse(entry);
            result.add(Integer.parseInt((String) entry.getKey()),course);
        }
        return result;
    }

    private Course getCourse(Map.Entry entry) {
        Course course = new Course();
        JsonObject object = ((JsonElement)entry.getValue()).getAsJsonObject();
        course.setCourseTitle(object.get(courseTitle).getAsString());
        course.setCourseCode(object.get(courseCode).getAsString());
        course.setSectionTitle(object.get(sectionTitle).getAsString());
        course.setSectionCode(object.get(sectionCode).getAsString());
        return course;
    }

}
