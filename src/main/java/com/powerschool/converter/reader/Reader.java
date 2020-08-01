package com.powerschool.converter.reader;

import com.powerschool.converter.model.Course;

import java.util.List;

public interface Reader {
    public List<Course> read(String data);
}
