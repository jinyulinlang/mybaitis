package com.gao.test;

import com.alibaba.fastjson.JSONObject;
import com.gao.mappers.TAddressMapper;
import com.gao.mappers.TEmployeeMapper;
import com.gao.mappers.TGradeMapper;
import com.gao.mappers.TStudentMapper;
import com.gao.model.TEmployee;
import com.gao.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class TEmployeeTest {
    private static final Logger log = LoggerFactory.getLogger(TEmployeeTest.class);
    private static SqlSession sqlSession;
    private TEmployeeMapper tEmployeeMapper;


    @Before
    public void setUp() throws Exception {
        if (sqlSession == null) {
            sqlSession = SqlSessionFactoryUtil.openSession();
            tEmployeeMapper = sqlSession.getMapper(TEmployeeMapper.class);
        }
    }

    @After
    public void tearDown() throws Exception {
        sqlSession.close();
    }

    @Test
    public void testInsertEmployee() {
        int a = tEmployeeMapper.insertSelective(new TEmployee("张三", 1356972, 1));
        int b = tEmployeeMapper.insertSelective(new TEmployee("张四", 1356973, 1));
        int c = tEmployeeMapper.insertSelective(new TEmployee("张五", 1356974, 1));
        int d = tEmployeeMapper.insertSelective(new TEmployee("王三", 1356975, 2));
        int e = tEmployeeMapper.insertSelective(new TEmployee("王四", 1356976, 2));
        int f = tEmployeeMapper.insertSelective(new TEmployee("李三", 1356977, 3));
        int g = tEmployeeMapper.insertSelective(new TEmployee("李四", 1356978, 3));
        sqlSession.commit();
        log.info("--------添加成功！------------");
    }

    @Test
    public void testFindEmployees1() {
        Map<String, Object> bean = new HashMap<String, Object>();
//        bean.put("id", 8);
//        bean.put("name", "李四");
//        bean.put("employeeNo", 1356978);
        bean.put("deptNo", 1);
        List<TEmployee> employees = tEmployeeMapper.findEmployees1(bean);
        String s = JSONObject.toJSONString(employees);
        System.out.println(s);
    }

    @Test
    public void testFindEmployees2() {
        Map<String, Object> bean = new HashMap<String, Object>();
        bean.put("flag", "name");
        //  bean.put("flag", "employeeNo");
        //   bean.put("flag", "fff");
        bean.put("id", 8);
        bean.put("name", "李四");
        bean.put("employeeNo", 1356978);
        bean.put("deptNo", 1);
        List<TEmployee> employees = tEmployeeMapper.findEmployees2(bean);
        String s = JSONObject.toJSONString(employees);
        System.out.println(s);
    }

    @Test
    public void testFindEmployees3() {
        Map<String, Object> bean = new HashMap<String, Object>();
        bean.put("name", "李四");
        bean.put("employeeNo", 1356978);
        // bean.put("deptNo", 1);
        // bean.put("id", 8);
        List<TEmployee> employees = tEmployeeMapper.findEmployees3(bean);
        String s = JSONObject.toJSONString(employees);
        System.out.println(s);

    }

    @Test
    public void testFindEmployees4() {
        Map<String, Object> bean = new HashMap<String, Object>();
        bean.put("name", "李四");
        bean.put("employeeNo", 1356978);
        // bean.put("deptNo", 1);
        //   bean.put("id", 8);
        List<TEmployee> employees = tEmployeeMapper.findEmployees4(bean);
        String s = JSONObject.toJSONString(employees);
        System.out.println(s);
    }


    @Test
    public void testFindEmployees5() {
        Map<String, Object> bean = new HashMap<String, Object>();
        List<Integer> employeeNos = new ArrayList<Integer>();
        employeeNos.add(1356972);
        employeeNos.add(1356973);
     /*   employeeNos.add(1);
        employeeNos.add(2);*/
        //  bean.put("name", "李四");
        //  bean.put("employeeNo", 1356978);
        //  bean.put("deptNo", 1);
//        bean.put("id", 8);
        bean.put("employeeNos", employeeNos);
        List<TEmployee> employees = tEmployeeMapper.findEmployees5(bean);
        String s = JSONObject.toJSONString(employees);
        System.out.println(s);
    }

    @Test
    public void testUpdate() {
        Map<String, Object> bean = new HashMap<String, Object>();
//        bean.put("id", 8);
//        bean.put("name", "李四");
//        bean.put("employeeNo", 1356978);
//        bean.put("deptNo", 1);

        // bean.put("deptNo", 1);
        // bean.put("id", 8);
        tEmployeeMapper.update(new TEmployee(8, "燕子李三", null, null));
        bean.put("id", 8);
        sqlSession.commit();
        List<TEmployee> employees = tEmployeeMapper.findEmployees1(bean);
        String s = JSONObject.toJSONString(employees);
        System.out.println(s);
    }
}
