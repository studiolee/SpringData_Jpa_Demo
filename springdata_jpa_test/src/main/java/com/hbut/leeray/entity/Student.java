package com.hbut.leeray.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table
public class Student {
    @Id//主键标识
    @GeneratedValue(strategy = GenerationType.IDENTITY)//设置主键自增，如果不是自增可以不写
    private Integer id;
    private Integer gender;
    private String name;
    private Date birth;
    @Transient//告诉spring不要为banId做属性到字段的映射
    private Integer banId;

    //一对一关系
    @OneToOne(mappedBy = "student")
    private StuInfo stuInfo;

    //配置多对一关系
    @ManyToOne(targetEntity = Ban.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "banId")
    private Ban ban;

    //配置课程对学生的多对多关系映射，选择课程为维护端。
    @ManyToMany
    @JoinTable(
            name = "student_course",//指定中间表名
            joinColumns = {@JoinColumn(name = "sId",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "cId",referencedColumnName = "cId")}
    )
    private List<Course> courses;
    //重写toString()方法
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", gender=" + gender +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", banId=" + banId +
                '}';
    }
}
