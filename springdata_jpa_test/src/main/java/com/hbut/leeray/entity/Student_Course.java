package com.hbut.leeray.entity;

import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Data
@Entity
@Table
public class Student_Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer s_cId;
    private Integer sId;
    private Integer cId;
}
