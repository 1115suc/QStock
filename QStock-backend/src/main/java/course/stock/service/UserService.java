package course.stock.service;

import course.stock.pojo.vo.req.LoginReqVo;
import course.stock.pojo.vo.resp.LoginRespVo;
import course.stock.pojo.vo.resp.R;

import java.util.Map;

public interface UserService {
    // 用户登录功能实现
    R<LoginRespVo> login(LoginReqVo vo);
    // 生成登录校验码的访问接口
    R<Map> getCaptchaCode();
}