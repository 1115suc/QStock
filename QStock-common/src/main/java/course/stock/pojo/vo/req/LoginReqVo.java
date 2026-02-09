package course.stock.pojo.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class LoginReqVo {
    // 用户名
    @ApiModelProperty("用户名")
    private String username;
    // 密码
    @ApiModelProperty("密码")
    private String password;
    // 验证码
    @ApiModelProperty("验证码")
    private String code;
    // 存入redis的随机码的key
    @ApiModelProperty("sessionId")
    private String sessionId;
}
