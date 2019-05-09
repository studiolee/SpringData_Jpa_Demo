package com.hbut.leeray;

import com.hbut.leeray.entity.Ban;
import com.hbut.leeray.entity.Course;
import com.hbut.leeray.entity.StuInfo;
import com.hbut.leeray.entity.Student;
import com.hbut.leeray.repository.BanRepository;
import com.hbut.leeray.repository.CourseRepository;
import com.hbut.leeray.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDataJpaApplicationTests {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    BanRepository banRepository;
    @Autowired
    CourseRepository courseRepository;

    @Transactional
    @Test
    public void test1() {
        //通过学生id查找学生的班级信息
        Student s1 = studentRepository.findOne(10);
        System.out.println("学生信息：" + s1.toString());
        Ban b1 = s1.getBan();
        System.out.println("学生班级信息：" + b1.toString());
    }

    @Transactional
    @Test
    public void test2() {
        //查找班级id为1里所有的所有学生
        Ban b1 = banRepository.findOne(1);
        System.out.println("班级信息：" + b1.toString());
        System.out.println("班级下的所有学生：");
        /**
         * 默认开启懒加载
         * 在不加@Transactional注解的时候会发送懒加载异常
         * 就是在hibernante的会话session在查找完b1后就会关闭，然后我们再想获得b1的学生列表属性。
         * 由于是懒加载，所以学生列表要现查，但是此时会话已经关闭，就查不到了。
         * 使用@Transactional标记为事务即可解决
         */
        List<Student> list = b1.getStudents();
        for (Student s : list) {
            System.out.println(s);
        }
    }

    //自定义查询,查询出生年份在2019年之前的所有学生姓名和他们的老师
    @Test
    public void test3() {
        List<Object[]> list = studentRepository.findOldStus();
        for (int i = 0; i < list.size(); i++) {
            Object[] obj = list.get(i);
            System.out.println(obj[0] + ":" + obj[1]);
        }
    }

    @Transactional
    @Test
    public void test4() {
        //多对多查询
        //查询学习1002课程的所有学生
        Course c = courseRepository.findOne(1002);
        List<Student> list = c.getStudents();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Transactional
    @Test
    public void test5() {
        //通过学生信息查询详细信息
        Student s = studentRepository.findOne(5);
        System.out.println("学生基本信息："+s);
        StuInfo info = s.getStuInfo();
        System.out.println("学生详细信息："+info);
    }
}
