package com.cqgc.mapper;

import com.cqgc.pojo.Departement;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {
    @Insert("insert into department (deptId,deptName) values (#{departement.deptId},#{departement.deptName})")
    int insertDept(@Param("departement")Departement departement);

    @Select("select * from department ")
    List<Departement> deptSelectAll();

    @Update("update department set deptName =#{departement.deptName} where deptId = #{departement.deptId}")
    int xGdept(@Param("departement")Departement departement );
}
