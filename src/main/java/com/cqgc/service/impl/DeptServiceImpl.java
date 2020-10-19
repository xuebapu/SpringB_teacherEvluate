package com.cqgc.service.impl;

import com.cqgc.mapper.DeptMapper;
import com.cqgc.pojo.Departement;
import com.cqgc.service.DeptServiec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeptServiceImpl implements DeptServiec {

    @Autowired
    DeptMapper deptMapper;

    @Override
    public int insertDept(Departement departement) {
        return deptMapper.insertDept(departement);
    }

    @Override
    public List<Departement> deptSelectAll() {
        return  deptMapper.deptSelectAll();
    }

    @Override
    public int xGdept(Departement departement) {
        return deptMapper.xGdept(departement);
    }

}
