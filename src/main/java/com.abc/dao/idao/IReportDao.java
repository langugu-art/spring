package com.abc.dao.idao;

import com.abc.controller.vo.DeptEmpVo;
import com.abc.service.dto.DeptEmpDTO;

import java.util.List;

public interface IReportDao {
    List<DeptEmpDTO> makeReportForDeptEmp(DeptEmpVo deptEmpVo)throws  Exception;
}
