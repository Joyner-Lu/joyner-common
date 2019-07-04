package com.joyner.mybatis.mapper;

import com.joyner.mybatis.po.Blog;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface BlogMapper {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "articleTitle", column = "article_title"),
            @Result(property = "articleContent", column = "article_content"),
            @Result(property = "articleDate", column = "article_date"),
            @Result(property = "articleReadtime", column = "article_readtime"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "categoryName", column = "category_name")

    })

    @Select("SELECT * FROM blog WHERE id = #{id}")
    Blog selectBlog(int id);
}