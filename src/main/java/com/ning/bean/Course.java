package com.ning.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    private Integer id;

    private String name;

    private Integer hours;

    private Integer sid;

    private String image;


}
