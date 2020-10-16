package com.cssl.service.impl;

import com.cssl.entity.Student;
import com.cssl.service.StudentService;
import com.cssl.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {


    //引入redis模板
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<Student> showAll() {
        List<Student> ls=null;
        if(redisUtil.exists("lst")){
            System.out.println("redis中有lst缓存");
            ls=( List<Student>)redisUtil.get("lst");
            for (Student s:ls) {
                System.out.println(s.getSid()+":"+s.getSname());
            }
        }else{
            System.out.println("redis中不存在");
            ls=studentDaoAllData();
            //保存到redis缓存中30秒
            redisUtil.set("lst",ls,60L);
        }

        return ls;
    }

    @Override
    public Student findById(Integer sid) {
        Student stu=null;
        if(redisUtil.exists("student")){
            System.out.println("redis中有student缓存");
            stu=( Student)redisUtil.get("student");

            System.out.println("从缓存中查询："+stu.getSid()+":"+stu.getSname());

        }else{
            System.out.println("redis中不存在student");
            stu=studentDaoOne();
            //保存到redis缓存中
            redisUtil.set("student",stu);
        }

        return stu;
    }


    @Override
    //@CachePut(value="user", key="#id", condition="#id%2==1", unless="#result==null")
    //@Cacheable(value="ss", key="#id", condition="#id%2==0", unless="#result==null")
    public Student findById2(Integer sid) {
        System.out.println("StudentServiceImpl缓存findById2");
        Student    stu=studentDaoOne();

        return stu;
    }


    //模拟数据访问层 查询出的数据
    public List<Student> studentDaoAllData(){
        try {
            Thread.sleep(1000);
            System.out.println("模拟数据查询延时....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Student> list=new ArrayList<Student>();
        list.add(new Student(101,"宋江",new Date()));
        list.add(new Student(102,"晁盖",new Date()));
        list.add(new Student(103,"林冲",new Date()));
        list.add(new Student(104,"花荣",new Date()));
        list.add(new Student(105,"鲁智深",new Date()));
        list.add(new Student(106,"武松",new Date()));
        System.out.println("从数据库查询返回对象集合："+list);
        return list;

    }

    //模拟数据访问层 查询出的数据
    public Student studentDaoOne(){
        try {
            Thread.sleep(1000);
            System.out.println("模拟数据查询延时....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Student student = new Student(106, "武松", new Date());
        System.out.println("从数据库查询返回一个对象："+student);

        return student ;

    }
}
