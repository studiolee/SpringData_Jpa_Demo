package com.hbut.leeray.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class Ban {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bId;
    private String banName;
    private String banTeacher;
    //被维护端
    @OneToMany(mappedBy = "ban")
    private List<Student> students;

    @Override
    public String toString() {
        return "Ban{" +
                "banId=" + bId +
                ", banName='" + banName + '\'' +
                ", banTeacher='" + banTeacher + '\'' +
                '}';
    }
}
