package com.lanou.mybatis;


import com.lanou.mybatis.bean.Student;
import com.lanou.mybatis.mybatis.TestMapper;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {

            InputStream is= Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactory  sqlSessionFactory = (SqlSessionFactory) new SqlSessionFactoryBuilder().build(is);
            SqlSession  sqlSession =  sqlSessionFactory.openSession(true);
            TestMapper testMapper =   sqlSession.getMapper(TestMapper.class);

           //selectOne(testMapper);
           selectAll(testMapper);
           // selectbyId(testMapper);
           // inset(testMapper);
           // delete(testMapper);
             //update(testMapper);
    }

    public  static void selectOne(TestMapper testMapper){
        Student res = testMapper.queryOne();
         System.out.println(ReflectionToStringBuilder.toString(res));
    }

    public  static void selectAll(TestMapper testMapper){
        List<Student> list = testMapper.queryAll();
        for(Student student:list){
            System.out.println(ReflectionToStringBuilder.toString(student));
        }
    }

    public  static void selectbyId(TestMapper testMapper){
        Student res = testMapper.queryById(1);
        System.out.println(ReflectionToStringBuilder.toString(res));
    }

    public  static void inset(TestMapper testMapper){
        Student student = new Student();
        student.setName("张三");
        student.setSex("男");
        student.setAge(25);
        testMapper.insert(student);
        System.out.println("自增的num值是： " + student.getNum());
    }

    public  static void  delete(TestMapper testMapper){
         testMapper.deleteStudent(44);
    }

    public  static void update(TestMapper testMapper){
        Student student = new Student();
        student.setName("张俊涛");
        student.setNum(37);
        testMapper.updateStudent(student);

    }


}
