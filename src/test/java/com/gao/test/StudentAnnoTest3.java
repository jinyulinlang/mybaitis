package com.gao.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gao.mappers.TAddressMapper;
import com.gao.mappers.TGradeAnnoMapper;
import com.gao.mappers.TStudentAnnMapper;
import com.gao.mappers.TStudentMapper;
import com.gao.model.TAddress;
import com.gao.model.TGrade;
import com.gao.model.TStudent;
import com.gao.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

public class StudentAnnoTest3 {
    private static final Logger log = LoggerFactory.getLogger(StudentAnnoTest3.class);
    private static SqlSession sqlSession;
    private TStudentAnnMapper tStudentAnnMapper;
    private TGradeAnnoMapper tGradeAnnoMapper;

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
        tStudentAnnMapper = sqlSession.getMapper(TStudentAnnMapper.class);
        tGradeAnnoMapper = sqlSession.getMapper(TGradeAnnoMapper.class);
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

    @Test
    public void testFindWithAnno() {
        TStudent tStudent = tStudentAnnMapper.findWithAnotationById(1);
        String s = JSONObject.toJSONString(tStudent);
        System.out.println(s);
    }

    /**
     * 根据年级查询
     */
    @Test
    public void testFindWithAnnoOneTOMayById() {
        TGrade tGrade = tGradeAnnoMapper.findWithAnnoById(1);
        JSONObject o = (JSONObject) JSONObject.toJSON(tGrade);
        String s2 = o.toJSONString();
        System.out.println(s2);

    }

    /**
     * 根据年级查询
     */
    @Test
    public void testFindWithAnnoAndAddressAndGradeById() {
        TStudent tStudent = tStudentAnnMapper.findWithAnnoAndAddressAndGradeById(1);
        JSONObject o = (JSONObject) JSONObject.toJSON(tStudent);
        String s2 = o.toJSONString();
        System.out.println(s2);

    }

    @Test
    public void testInserStudentByProvder() {
        TStudent tStudent = new TStudent();
        tStudent.setAge(13);
        tStudent.setName("王十四");
        TGrade tGrade = new TGrade();
        tGrade.setId(1);
        tStudent.settGrade(tGrade);
        TAddress tAddress = new TAddress();
        tAddress.setId(2);
        tStudent.settAddress(tAddress);
        int i = tStudentAnnMapper.insertStudent(tStudent);
        if (i > 0) {
            log.info("保存成功！");
            sqlSession.commit();
        }

    }


    @Test
    public void testUpdateStudent() {
        TStudent tStudent = tStudentAnnMapper.findWithAnotationById(1);

        tStudent.setName("张三三");
        String s = JSONObject.toJSONString(tStudent);
        System.out.println(s);
        int i = tStudentAnnMapper.updateStudent(tStudent);
        if (i > 0) {
            log.info("更新成功！");
            sqlSession.commit();

        }
    }


    @Test
    public void testDeleteStudent() {
        int i = tStudentAnnMapper.deleteStudent(19);
        if (i > 0) {
            log.info("删除成功！");
            sqlSession.commit();
        }
    }

    @Test
    public void testFindStudent() {
        TStudent ts = tStudentAnnMapper.findStudentById(10);
        Object o = (JSONObject) JSONObject.toJSON(ts);
        String s = ((JSONObject) o).toJSONString();
        System.out.println(s);

    }

    @Test
    public void testFindStudents() {
//        声明一个map
        Map<String, Object> bean = new HashMap<>();
//        bean.put("age", 13);
        List<TStudent> students = tStudentAnnMapper.findStudents(bean);
        Object o = (JSONArray) JSONObject.toJSON(students);
        String s = ((JSONArray) o).toJSONString();
        System.out.println(s);

    }

}
