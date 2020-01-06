package com.lanou.mybatis.mybatis;

import com.lanou.mybatis.bean.Student;

import java.util.List;

public interface TestMapper {

    Student queryOne();
    List<Student> queryAll();
    Student queryById( Integer id);
    int insert(Student student);
    void deleteStudent(Integer num);
    void updateStudent(Student student);
}
