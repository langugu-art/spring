package com.abc.service.impl;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.common.ResEnum;
import com.abc.controller.vo.DeptEmpVo;
import com.abc.dao.factory.DaoFactory;
import com.abc.dao.idao.IReportDao;
import com.abc.service.dto.DeptEmpDTO;
import com.abc.service.iservice.IReportService;

import java.util.List;

public class DeptEmpServiceImpl implements IReportService {
    IReportDao reportDao;

    public DeptEmpServiceImpl() {
        reportDao = (IReportDao) DaoFactory.getInstance(Comm.DEPT_EMP_REPORT);
    }

    @Override
    public Res<List<DeptEmpDTO>> makeReportForDeptEmp(DeptEmpVo deptEmpVo) {
        List<DeptEmpDTO> result = null;
        try {
            result = reportDao.makeReportForDeptEmp(deptEmpVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (result != null && result.size() > 0) ? Res.success(ResEnum.SUCCESSS, result) : Res.error();
    }
}