package com.abc.service.iservice;

import com.abc.common.Res;
import com.abc.controller.vo.DeptEmpVo;
import com.abc.service.dto.DeptEmpDTO;

import java.util.List;

public interface IReportService {
    //封装报表DeptEmpDTO 返回的是集合
    Res<List<DeptEmpDTO>> makeReportForDeptEmp(DeptEmpVo deptEmpVo);
}
