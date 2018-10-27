package com.gao.test;

import com.alibaba.fastjson.JSONObject;
import com.gao.mappers.TAddressMapper;
import com.gao.mappers.TStudentMapper;
import com.gao.model.TAddress;
import com.gao.model.TStudent;
import com.gao.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class StudentTest3 {
    private static final Logger log = LoggerFactory.getLogger(StudentTest3.class);
    private static SqlSession sqlSession;
    private TStudentMapper tStudentMapper;
    private TAddressMapper tAddressMapper;

    /**
     * 测试方法前调用
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        if (sqlSession == null) {
            sqlSession = SqlSessionFactoryUtil.openSession();
        }
    }

    /**
     * 测试方法后调用
     *
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        sqlSession.close();
    }

    /**
     * 新增
     */
    @Test
    public void testInsert() {
        tAddressMapper = sqlSession.getMapper(TAddressMapper.class);
        int result = tAddressMapper.insert(new TAddress("江苏省", "苏州市", "姑苏区"));
        int a = tAddressMapper.insert(new TAddress("江苏省", "南京市", "鼓楼区"));
        sqlSession.commit();
        if (result > 0 & a > 0) {
            log.info("添加成功！");
        }

    }

    @Test
    public void testFindStudentWithAddress() {
        tStudentMapper = sqlSession.getMapper(TStudentMapper.class);
        TStudent tStudent = tStudentMapper.findStudentWithAddress(1);
        String s = JSONObject.toJSONString(tStudent);
        System.out.println(s);
    }

    @Test
    public void testFindStudentWithAddress3() {
        tStudentMapper = sqlSession.getMapper(TStudentMapper.class);
        TStudent tStudent = tStudentMapper.findStudentWithAddress3(1);
        String s = JSONObject.toJSONString(tStudent);
        System.out.println(s);
    }

    @Test
    public void testFindStudentWithAddress4() {
        tStudentMapper = sqlSession.getMapper(TStudentMapper.class);
        TStudent tStudent = tStudentMapper.findStudentWithAddress4(1);
        String s = JSONObject.toJSONString(tStudent);
        System.out.println(s);
    }

    @Test
    public void testFindStudentWithAddress5() {
        tStudentMapper = sqlSession.getMapper(TStudentMapper.class);
        TStudent tStudent = tStudentMapper.findStudentWithAddress5(13);
        String s = JSONObject.toJSONString(tStudent);
        System.out.println(s);
    }

    @Test
    public void testfindAddressById1() {
        tAddressMapper = sqlSession.getMapper(TAddressMapper.class);
        TAddress tAddress = tAddressMapper.findAddressById1(1);
        String s = JSONObject.toJSONString(tAddress);
        System.out.println(s);
    }

    @Test
    public void testfindAddressById2() {
        tAddressMapper = sqlSession.getMapper(TAddressMapper.class);
        TAddress tAddress = tAddressMapper.findAddressById2(1);
        String s = JSONObject.toJSONString(tAddress);
        System.out.println(s);
    }

    /**
     * 查詢学生信息带地址和年级
     */
    @Test
    public void testfindStudentWithAddressAndGradeById2() {
        tStudentMapper = sqlSession.getMapper(TStudentMapper.class);
        TStudent tStudent = tStudentMapper.findStudentWithAddressAndGradeById2(1);
        String s = JSONObject.toJSONString(tStudent);
        System.out.println(s);
    }
}
