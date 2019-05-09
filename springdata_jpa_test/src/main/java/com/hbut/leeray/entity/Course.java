package com.hbut.leeray.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class Course {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)//设置主键自增，不要自增了,改用uuid
    private Integer cId;//课程ID
    private String cName;//课程名称
    private String place;//上课地点
    private Double credit;//学分

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
}
