package com.cqgc.mapper;


import com.cqgc.pojo.Nav;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NavMapper {


    @Select("select * from nav ")
    List<Nav> getNavAll();

    @Select("select * from nav where perms = #{perms} order BY id asc")
    List<Nav> getNav(@Param("perms") String perms);


    @Insert("insert into nav (name,level1,level2,perms,url) values(#{nav.name},#{nav.level1},#{nav.level2},#{nav.perms},#{nav.url})")
    int insertDept(@Param("nav") Nav nav);

    @Update("update nav set name = #{deptName} where name = #{oldName}")
    int xGdept(@Param("oldName") String oldName,@Param("deptName") String deptName );

    @Update("update nav set name = #{name},level1=#{level1},level2=#{level2},perms=#{perms},url=#{url} where id=#{id}")
    int upNav(@Param("nav") Nav nav);

}
