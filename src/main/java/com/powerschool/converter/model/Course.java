package com.powerschool.converter.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Course {
    private String courseTitle;
    private String courseCode;
    private String sectionTitle;
    private String sectionCode;
}
