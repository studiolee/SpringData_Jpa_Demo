package com.hbut.leeray.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class StuInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增
    private Integer id;
    private String addr;//地址
    private String nation;//名族
    private String telphone;//电话号码
    private String qq;//qq号
    private String email;//电子邮箱
    @Transient
    private Integer sId;
    //配置一对一关系
    //一个学生只能有一个详细信息表
    @OneToOne(fetch = FetchType.LAZY)//懒加载
    @JoinColumn(name = "sId",unique = true)//查询结果集为单个
    private Student student;

    @Override
    public String toString() {
        return "StuInfo{" +
                "id=" + id +
                ", addr='" + addr + '\'' +
                ", nation='" + nation + '\'' +
                ", telphone='" + telphone + '\'' +
                ", qq='" + qq + '\'' +
                ", email='" + email + '\'' +
                ", sId=" + sId +
                '}';
    }
}
