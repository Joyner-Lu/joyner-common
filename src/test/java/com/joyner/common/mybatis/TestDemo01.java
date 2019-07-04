package com.joyner.common.mybatis;

import com.joyner.mybatis.mapper.BlogMapper;
import com.joyner.mybatis.po.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class TestDemo01 {

    @Test
    public void testDemoXml() throws Exception {
        String resource = "mybatis-config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        Blog blog = session.selectOne(
                "org.mybatis.example.BlogMapper.selectBlog", 1);
        System.out.println(blog);
        session.close();
    }
    @Test
    public void testDemoMapperClass() throws Exception {
        String resource = "mybatis-config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        BlogMapper blogMapper = session.getMapper(BlogMapper.class);
        Blog blog = blogMapper.selectBlog(1);
        System.out.println(blog);
        session.close();
    }
}
