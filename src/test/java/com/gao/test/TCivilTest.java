package com.gao.test;

import com.alibaba.fastjson.JSONObject;
import com.gao.mappers.TCivilMapper;
import com.gao.model.TCivil;
import com.gao.model.TCivilWithBLOBs;
import com.gao.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Base64;

public class TCivilTest {

    private static final Logger log = LoggerFactory.getLogger(TCivilTest.class);
    private static SqlSession sqlSession;
    private static TCivilMapper tCivilMapper = null;

    /**
     * 测试方法前调用
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        if (sqlSession == null) {
            sqlSession = SqlSessionFactoryUtil.openSession();
            tCivilMapper = sqlSession.getMapper(TCivilMapper.class);
        }
    }

    /**
     * 测试方法后调用
     *
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsert1() {
        log.info("添加学生----------");
        TCivilWithBLOBs tCivilWithBLOBs = new TCivilWithBLOBs();
        tCivilWithBLOBs.setName("张五");
        tCivilWithBLOBs.setAge(18);
        String url = "C:/Users/jinyulinlang/Pictures/风景图/7.png";
        byte[] bytes = null;
        try {
            bytes = savePic(url);
            tCivilWithBLOBs.setPic(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s = Base64.getEncoder().encodeToString(bytes);
        tCivilWithBLOBs.setRemark(s);
//        tCivilMapper.insertSelective(tCivilWithBLOBs);
        tCivilMapper.insertSelective(tCivilWithBLOBs);
    }

    public byte[] savePic1(String url) throws IOException {
        log.info("保存图片开始--------------");
        byte[] bytes = null;
        File file = new File(url);
        InputStream fis = null;
        ByteArrayOutputStream baos = null;
        try {
            fis = new FileInputStream(file);
            bytes = new byte[fis.available()];
            int r = fis.read(bytes);
            log.info("图片的二进制字节打下：" + baos.toByteArray().length);
            Assert.assertTrue("字节并不相等", 305298 == bytes.length);
            return bytes;
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        } finally {
            if (baos != null) {
                baos.close();
                baos = null;
            }
            if (fis != null) {
                fis.close();
                fis = null;
            }
        }

    }

    public byte[] savePic(String url) throws IOException {
        log.info("保存图片开始--------------");
        byte[] bytes = null;
        File file = new File(url);
        InputStream fis = null;
        ByteArrayOutputStream baos = null;
        try {
            fis = new FileInputStream(file);
            bytes = new byte[fis.available()];
            baos = new ByteArrayOutputStream();
            int r = fis.read(bytes);
            while (r != -1) {
                baos.write(bytes, 0, r);
                r = fis.read(bytes);
            }
            baos.flush();
            log.info("图片的二进制字节打下：" + baos.toByteArray().length);
            Assert.assertTrue("字节并不相等", 305298 == baos.toByteArray().length);
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        } finally {
            if (baos != null) {
                baos.close();
                baos = null;
            }
            if (fis != null) {
                fis.close();
                fis = null;
            }
        }

    }

    @Test
    public void testSavePic() {
        log.info("保存图片开始--------------");
        byte[] bytes = null;
        File file = new File("C:/Users/jinyulinlang/Pictures/风景图/7.png");
        InputStream fis = null;
        ByteArrayOutputStream baos = null;
        try {
            fis = new FileInputStream(file);
            bytes = new byte[fis.available()];
            baos = new ByteArrayOutputStream();
            fis.read(bytes);
            baos.write(bytes);
            baos.flush();
            log.info("图片的二进制字节：" + baos.toByteArray());
            byte[] b = baos.toByteArray();
            log.info("未经过base64编码的图片字节流的大小：" + b.length);
            String s = Base64.getEncoder().encodeToString(b);
            System.out.println(s);
//            log.info("经过Base64编码后的图片：" + s);
            log.info("经过Base64编码后的图片大小：" + s.length());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                if (baos != null) {
                    baos.close();
                    baos = null;
                }
                if (fis != null) {
                    fis.close();
                    fis = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testInsert2() {
        log.info("添加学生----------");
        TCivilWithBLOBs tCivilWithBLOBs = new TCivilWithBLOBs();
        tCivilWithBLOBs.setName("张五");
        tCivilWithBLOBs.setAge(18);
        String url = "C:/Users/jinyulinlang/Pictures/风景图/7.png";
        byte[] bytes = null;
        try {
            File file = new File(url);
            InputStream fis = new FileInputStream(file);
            bytes = new byte[fis.available()];
            fis.read(bytes);
            tCivilWithBLOBs.setPic(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s = Base64.getEncoder().encodeToString(bytes);
        tCivilWithBLOBs.setRemark(s);
//        tCivilMapper.insertSelective(tCivilWithBLOBs);
        tCivilMapper.insertSelective(tCivilWithBLOBs);
    }

    @Test
    public void testFindTCivilById1() {
        TCivilWithBLOBs tCivil = (TCivilWithBLOBs) tCivilMapper.findTCivilById1(1);
        String s = JSONObject.toJSONString(tCivil);
        System.out.println(s);
        byte[] pic = tCivil.getPic();
        File file = new File("D:/pic");
        try {
            OutputStream fos = new FileOutputStream(file);
            fos.write(pic);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
