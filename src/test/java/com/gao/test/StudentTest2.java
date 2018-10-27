package com.gao.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gao.mappers.TStudentMapper;
import com.gao.model.TStudent;
import com.gao.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class StudentTest2 {
    private static final Logger log = LoggerFactory.getLogger(StudentTest2.class);
    private static SqlSession sqlSession;
    private TStudentMapper tStudentMapper;

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
        tStudentMapper = sqlSession.getMapper(TStudentMapper.class);
        int result = tStudentMapper.insert(new TStudent("赵二", 13));
        sqlSession.commit();
        if (result > 0) {
            log.info("添加成功！");

        }

    }

    /**
     * 更新
     */
    @Test
    public void testUpdate() {
        tStudentMapper = sqlSession.getMapper(TStudentMapper.class);
        int result = tStudentMapper.update(new TStudent(18, "赵二", 18));
        sqlSession.commit();
        if (result > 0) {
            log.info("更新成功！");
        }

    }

    /**
     * 删除
     */
    @Test
    public void testDelete() {
        tStudentMapper = sqlSession.getMapper(TStudentMapper.class);
        int result = tStudentMapper.delete(18);
        sqlSession.commit();
        if (result > 0) {
            log.info("删除成功！");
        }
    }

    /**
     * 根据Id查找相关信息
     */
    @Test
    public void testFindById() {
        tStudentMapper = sqlSession.getMapper(TStudentMapper.class);
        TStudent tStudent = tStudentMapper.findById(8);
        log.info(tStudent.toString());
    }

    /**
     * 找相关信息
     */
    @Test
    public void testFind() {
        log.info("查找所有的学生信息");
        tStudentMapper = sqlSession.getMapper(TStudentMapper.class);
        List<TStudent> tStudents = tStudentMapper.find();
        String s = JSONObject.toJSONString(tStudents);
        JSONArray objects = JSONObject.parseArray(s);
        objects.forEach(o -> {
            System.out.println(o);
        });

    }


    /**
     * 找相关信息
     */
    @Test
    public void testFindWithPage() {
        log.info("查找所有的学生信息");
        tStudentMapper = sqlSession.getMapper(TStudentMapper.class);
        int offset =2;
        int limit = 3;
        RowBounds rowBounds = new RowBounds(offset, limit);
        List<TStudent> tStudents = tStudentMapper.findStudentWithPage(rowBounds);
        String s = JSONObject.toJSONString(tStudents);
        JSONArray objects = JSONObject.parseArray(s);
        objects.forEach(o -> {
            System.out.println(o);
        });

    }
}