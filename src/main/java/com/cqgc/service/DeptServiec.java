package com.cqgc.service;


import com.cqgc.pojo.Departement;

import java.util.List;

public interface DeptServiec {

    int insertDept(Departement departement);

    List<Departement> deptSelectAll();

    int xGdept(Departement departement );

}
