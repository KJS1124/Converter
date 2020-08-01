package com.powerschool.converter.writer;

import com.powerschool.converter.model.Course;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface Writer {
    public void writer(List<Course> data,String file) throws IOException;
}
