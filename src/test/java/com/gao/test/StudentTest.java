package com.gao.test;

import com.gao.mappers.TStudentMapper;
import com.gao.model.TStudent;
import com.gao.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentTest {
    private static final Logger log = LoggerFactory.getLogger(StudentTest.class);
    private static SqlSession sqlSession = null;

    @Before
    public void init() {
        if (sqlSession == null) {
            sqlSession = SqlSessionFactoryUtil.openSession();
        }
    }

    @Test
    public void testInsert() {
        TStudentMapper tStudentMapper = sqlSession.getMapper(TStudentMapper.class);
        int result = tStudentMapper.insert(new TStudent("李四", 12));
        sqlSession.commit();
        if (result > 0) {
            System.out.println("添加成功");
            System.out.println(result);
        }
    }

    @Test
    public void testInsertSelective() {
        TStudentMapper tStudentMapper = sqlSession.getMapper(TStudentMapper.class);
        int reslut = tStudentMapper.insertSelective(new TStudent("王五", 13));
        sqlSession.commit();
        if (reslut > 0) {
            System.out.println("添加成功");
        }
    }

    @Test
    public void testInsertSelective2() {
        TStudentMapper tStudentMapper = sqlSession.getMapper(TStudentMapper.class);
        int reslut = tStudentMapper.insertSelective(new TStudent("王六", 13));
        sqlSession.commit();
        if (reslut > 0) {
            System.out.println("添加成功");
        }
    }

    @Test
    public void testInsertSelective3() {
        TStudentMapper tStudentMapper = sqlSession.getMapper(TStudentMapper.class);
        int reslut = tStudentMapper.insertSelective(new TStudent("王七", 13));
        sqlSession.commit();
        if (reslut > 0) {
            System.out.println("添加成功");
        }
    }

    @Test
    public void testInsertSelective4() {
        TStudentMapper tStudentMapper = sqlSession.getMapper(TStudentMapper.class);
        int reslut = tStudentMapper.insertSelective(new TStudent("王九", 13));
        sqlSession.commit();
        if (reslut > 0) {
            System.out.println("添加成功");
        }
    }

    @Test
    public void testInsertSelective5() {
        TStudentMapper tStudentMapper = sqlSession.getMapper(TStudentMapper.class);
        int reslut = tStudentMapper.insertSelective(new TStudent("王十三", 13));
        sqlSession.commit();
        if (reslut > 0) {
            log.info("添加成功！");
        }
    }
}
