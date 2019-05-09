package com.hbut.leeray.repository;

import com.hbut.leeray.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    //自定义查询
    //查询出生日期在2109年以前的学生姓名，并查询他们的班级。

    @Query(value = "SELECT s.name,b.ban_teacher from student s , ban b WHERE\n" +
            "s.ban_id = b.b_id and s.birth < '2019-1-1 00:00:00' ORDER BY s.birth ASC",
             nativeQuery = true)
    public List<Object[]> findOldStus();

}
