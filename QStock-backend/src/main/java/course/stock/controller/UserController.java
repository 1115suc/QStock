package course.stock.controller;

import course.stock.pojo.vo.req.LoginReqVo;
import course.stock.pojo.vo.resp.LoginRespVo;
import course.stock.pojo.vo.resp.R;
import course.stock.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(value = "用户认证相关接口定义", tags = "用户功能")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    // 用户登录功能实现
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "LoginReqVo", name = "vo", value = "", required = true)
    })
    @ApiOperation(value = "用户登录功能实现", notes = "用户登录功能实现", httpMethod = "POST")
    @PostMapping()
    public R<LoginRespVo> login(@RequestBody LoginReqVo vo){
        R<LoginRespVo> r= this.userService.login(vo);
        return r;
    }

    // 生成登录校验码的访问接口
    @ApiOperation(value = "生成登录校验码的访问接口", notes = "生成登录校验码的访问接口", httpMethod = "GET")
    @GetMapping()
    public R<Map> getCaptchaCode(){
        return userService.getCaptchaCode();
    }
}