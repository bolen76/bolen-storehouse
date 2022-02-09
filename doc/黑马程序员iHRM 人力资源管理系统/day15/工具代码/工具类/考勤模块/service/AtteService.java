package com.ihrm.atte.service;

import com.alibaba.fastjson.JSONObject;
import com.ihrm.atte.client.SystemFeignClient;
import com.ihrm.atte.dao.*;
import com.ihrm.common.entity.PageResult;
import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.common.exception.CommonException;
import com.ihrm.common.utils.BeanConvert;
import com.ihrm.common.utils.DateUtil;
import com.ihrm.common.utils.IdWorker;
import com.ihrm.domain.atte.bo.*;
import com.ihrm.domain.atte.entity.Attendance;
import com.ihrm.domain.atte.entity.AttendanceConfig;
import com.ihrm.domain.atte.entity.DeductionDict;
import com.ihrm.domain.atte.enums.DeductionEnum;
import com.ihrm.domain.atte.vo.AttePageVO;
import com.ihrm.domain.atte.vo.AtteSalaryStatisticsVO;
import com.ihrm.domain.employee.EmployeeArchive;
import com.ihrm.domain.system.User;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AtteService  {

	@Autowired
	private IdWorker idWorker;

    @Autowired
    private AttendanceDao attendanceDao;

    @Autowired
    private AtteStatisDao atteStatisDao;

    @Autowired
    private AtteReportDao atteReportDao;

    @Autowired
    private DeductionDictDao deductionDictDao;

    @Autowired
    private DaysMonthlyDao daysMonthlyDao;

    @Autowired
    private DepartmentDao departmentDao;
	
    @Autowired
    private UserDao userDao;

    @Autowired
    private AttendanceConfigDao attendanceConfigDao;
}
