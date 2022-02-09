package com.ihrm.audit.controller;

import com.ihrm.audit.service.ProcessService;
import com.ihrm.common.controller.BaseController;
import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 流程控制的controller
 */
@CrossOrigin
@RestController
@RequestMapping(value="/user/process")
public class ProcessController extends BaseController {

	@Autowired
	private ProcessService processService;

	/**
	 * 部署新流程
	 *     前端将绘制好的流程模型图(bpmn)文件上传到方法中
	 *     参数 : 上传的文件
	 *          MultipartFile
	 */
	@RequestMapping(value = "/deploy",method = RequestMethod.POST)
	public Result deployProcess(@RequestParam("file") MultipartFile file) throws IOException {
		processService.deployProcess(file,companyId);
		return new Result(ResultCode.SUCCESS);
	}
}
