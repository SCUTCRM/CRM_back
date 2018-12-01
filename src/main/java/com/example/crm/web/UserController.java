package com.example.crm.web;

import com.example.crm.contants.SessionAttributeContants;
import com.example.crm.dto.UserResult;
import com.example.crm.entity.User;
import com.example.crm.enums.SystemErrorEnum;
import com.example.crm.enums.UserResultEnum;
import com.example.crm.exception.UserException;
import com.example.crm.service.UserService;
import com.example.crm.util.DateUtil;
import com.example.crm.util.HttpServletRequestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/26 9:35
 * @ Description：用户操作相关控制层类
 * @ Modified By：
 */
@RestController
@RequestMapping("")
public class UserController {
    @Autowired
    private UserService userService;

    //判断用户是否存在
    @GetMapping("/users/usersexit")
    private HashMap<String,Object> userExitOrNot(HttpServletRequest request){
        HashMap<String,Object> resultMap = new HashMap<>();
        try{
            String userName = HttpServletRequestUtil.getString(request,"userName");
            UserResult userResult = userService.userExitOrNot(userName);
            if (userResult.getCode() == UserResultEnum.SUCCESS.getCode()){
                resultMap.put("success",true);
                resultMap.put("user",userResult.getUser());
            } else {
                resultMap.put("success",false);
            }
            resultMap.put("code",userResult.getCode());
            resultMap.put("msg",userResult.getMsg());
        }catch (UserException e){
            resultMap.put("success",false);
            resultMap.put("msg",e.getMessage());
            resultMap.put("code",e.getCode());
        }
        return resultMap;
    }

    @PostMapping("/users/changePassword")
    private HashMap<String,Object> changePassWord(HttpServletRequest request){
        HashMap<String,Object> resultMap = new HashMap<>();
        //1.比较验证码是否一致或者超时
        String sessionCode = (String) request.getSession().getAttribute("code");
        if (sessionCode == null){
            resultMap.put("success",false);
            resultMap.put("msg","请先获取验证码");
            return resultMap;
        }
        //获取前端传递过来的code参数
        String code = HttpServletRequestUtil.getString(request,"code");
        if (code != null && code.equals(sessionCode)) {
            //判断验证码是否过期
            Date sendTime = (Date) request.getSession().getAttribute("codeTime");
            long seconds = DateUtil.getDifferenceSeconds(sendTime,new Date());
            if (seconds > SessionAttributeContants.OVERDUESECONDS) {
                resultMap.put("success",false);
                resultMap.put("msg","验证码已过期");
                return resultMap;
            }
        } else {
            resultMap.put("success",false);
            resultMap.put("msg","验证码不正确");
            return resultMap;
        }
        //获取user对应的json字符串
        String userStr = HttpServletRequestUtil.getString(request,"user");
        ObjectMapper mapper = new ObjectMapper();
        User user = null;
        try {
            user = mapper.readValue(userStr,User.class);
        } catch (IOException e) {
            resultMap.put("success",false);
            resultMap.put("msg", SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg());
            return resultMap;
        }
        //2.调用userService更新用户密码信息
        try {
            UserResult result = userService.updateUser(user);
            if (result.getCode() == UserResultEnum.SUCCESS.getCode()) {
                resultMap.put("success",true);
            } else {
                resultMap.put("success",false);
            }
            resultMap.put("code",result.getCode());
            resultMap.put("msg",result.getMsg());
            return resultMap;
        }catch (UserException e) {
            resultMap.put("success",false);
            resultMap.put("code",e.getCode());
            resultMap.put("msg",e.getMessage());
            return resultMap;
        }
    }

    @GetMapping("/users/list")
    private HashMap<String,Object> list(HttpServletRequest request,String name,String phone,Integer pageNo,Integer pageSize) {
        HashMap<String,Object> resultMap = new HashMap<>();
        Map para = new HashMap();
        para.put("name",name);
        para.put("phone",phone);
        PageInfo<User> pageInfo = userService.getUserList(para,pageNo,pageSize);
        resultMap.put("success",true);
        resultMap.put("msg","获取成功");
        resultMap.put("tableData",pageInfo == null ? null : pageInfo.getList());
        resultMap.put("total",pageInfo == null ? 0 : pageInfo.getTotal());
        return resultMap;
    }

    @PostMapping("/users/update")
    private HashMap<String,Object> update(HttpServletRequest request, @RequestBody User user) {
        HashMap<String,Object> resultMap = new HashMap<>();
        try {
            UserResult userResult = userService.updateUser(user);
            if (userResult.getCode() == UserResultEnum.SUCCESS.getCode()) {
                resultMap.put("success",true);
            } else {
                resultMap.put("success",false);
            }
            resultMap.put("code",userResult.getCode());
            resultMap.put("msg",userResult.getMsg());
            return resultMap;
        }catch (UserException ex) {
            resultMap.put("success",false);
            resultMap.put("code",ex.getCode());
            resultMap.put("msg",ex.getMessage());
            return resultMap;
        }
    }

    @PostMapping("/users/delete")
    private HashMap<String,Object> delete(HttpServletRequest request) {
        HashMap<String,Object> resultMap = new HashMap<>();
        Integer id = HttpServletRequestUtil.getInt(request,"id");
        try {
            int result = userService.deleteUser(id);
            if (result == 0) {
                resultMap.put("success",false);
                resultMap.put("msg","删除失败");
            } else {
                resultMap.put("success",true);
                resultMap.put("msg","删除成功");
            }
        } catch (RuntimeException e) {
            resultMap.put("success",false);
            resultMap.put("msg",e.getMessage());
        }
        return resultMap;
    }
}
