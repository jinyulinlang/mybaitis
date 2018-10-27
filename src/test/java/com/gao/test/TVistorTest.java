package com.gao.test;

import com.alibaba.fastjson.JSONObject;
import com.gao.mappers.TAddressMapper;
import com.gao.mappers.TGradeMapper;
import com.gao.mappers.TStudentMapper;
import com.gao.mappers.TVistorMapper;
import com.gao.model.TGrade;
import com.gao.model.TVistor;
import com.gao.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TVistorTest {

    private static final Logger log = LoggerFactory.getLogger(TVistorTest.class);
    private static SqlSession sqlSession;
    private TVistorMapper tVistorMapper;


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
        tVistorMapper = sqlSession.getMapper(TVistorMapper.class);
        TVistor tVistor = new TVistor();
        tVistor.setAge(18);
        tVistor.setName("张六");
        int a = tVistorMapper.insert(tVistor);
        sqlSession.commit();
        if (a > 0) {
            log.info("添加成功！");
        }
    }

    @Test
    public void testUpdate() {
        tVistorMapper = sqlSession.getMapper(TVistorMapper.class);
        TVistor tVistor = new TVistor();
        tVistor.setId(2);
        tVistor.setAge(18);
        tVistor.setName("张四");
        int a = tVistorMapper.update(tVistor);
        sqlSession.commit();
        if (a > 0) {
            log.info("更新成功！");
        }
    }

    @Test
    public void testFind() {
        tVistorMapper = sqlSession.getMapper(TVistorMapper.class);
        TVistor tVistor = new TVistor();
        List<TVistor> all = tVistorMapper.findAll();
        String s = JSONObject.toJSONString(all);
        System.out.println(s);

    }
    @Test
    public void testFindById() {
        tVistorMapper = sqlSession.getMapper(TVistorMapper.class);
        TVistor tVistor = new TVistor();
        TVistor tVistor1 = tVistorMapper.findById(3);
        String s = JSONObject.toJSONString(tVistor1);
        System.out.println(s);

    }
    @Test
    public void testDelete() {
        tVistorMapper = sqlSession.getMapper(TVistorMapper.class);
        TVistor tVistor = new TVistor();
        int delete = tVistorMapper.delete(2);
        if (delete > 0) {
            log.info("删除成功！");
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
    }
}
