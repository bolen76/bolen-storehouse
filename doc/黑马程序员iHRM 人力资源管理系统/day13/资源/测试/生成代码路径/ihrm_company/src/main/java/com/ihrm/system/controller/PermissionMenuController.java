package com.ihrm.system.controller;

import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.common.exception.CommonException;


import com.ihrm.system.service.PermissionMenuService;
import com.ihrm.system.pojo.PermissionMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//解决跨域问题
@CrossOrigin
@RestController
@RequestMapping(value="/permissionMenu")
public class PermissionMenuController {

    @Autowired
    private PermissionMenuService permissionMenuService;

    //保存
    @RequestMapping(value="",method = RequestMethod.POST)
    public Result save(@RequestBody PermissionMenu permissionMenu)  {
        //业务操作
        permissionMenuService.add(permissionMenu);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id更新
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result update(@PathVariable(value="id") String id, @RequestBody PermissionMenu permissionMenu ) {
        //业务操作
        permissionMenu.setId(id);
        permissionMenuService.update(permissionMenu);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id删除
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable(value="id") String id) {
        permissionMenuService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id查询
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable(value="id") String id) throws CommonException {
        PermissionMenu permissionMenu = permissionMenuService.findById(id);
        return new Result(ResultCode.SUCCESS,permissionMenu);
    }

    //查询全部
    @RequestMapping(value="",method = RequestMethod.GET)
    public Result findAll() {
        List<PermissionMenu> list = permissionMenuService.findAll();
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(list);
        return result;
    }
}
