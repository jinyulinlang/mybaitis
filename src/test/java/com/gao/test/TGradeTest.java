package com.gao.test;

import com.alibaba.fastjson.JSONObject;
import com.gao.mappers.TAddressMapper;
import com.gao.mappers.TGradeMapper;
import com.gao.mappers.TStudentMapper;
import com.gao.model.TAddress;
import com.gao.model.TGrade;
import com.gao.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TGradeTest {

    private static final Logger log = LoggerFactory.getLogger(TGradeTest.class);
    private static SqlSession sqlSession;
    private TStudentMapper tStudentMapper;
    private TAddressMapper tAddressMapper;
    private TGradeMapper tGradeMapper;

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
        tGradeMapper = sqlSession.getMapper(TGradeMapper.class);
        int a = tGradeMapper.insert(new TGrade("大学一年级"));
        int b = tGradeMapper.insert(new TGrade("大学二年级"));
        int c = tGradeMapper.insert(new TGrade("大学三年级"));
        int d = tGradeMapper.insert(new TGrade("大学四年级"));
        sqlSession.commit();
        if (b > 0 & a > 0 & c > 0 & d > 0) {
            log.info("添加成功！");
        }
    }


    /**
     * 新增
     */
    @Test
    public void testFindGradeById2() {
        tGradeMapper = sqlSession.getMapper(TGradeMapper.class);
        TGrade tGrade = tGradeMapper.findGradeById2(2);
        String s = JSONObject.toJSONString(tGrade);
        System.out.println(s);
    }
    /**
     * 新增
     */
    @Test
    public void testFindGradeById3() {
        tGradeMapper = sqlSession.getMapper(TGradeMapper.class);
        TGrade tGrade = tGradeMapper.findGadeById3(1);
        String s = JSONObject.toJSONString(tGrade);
        System.out.println(s);
    }
}
