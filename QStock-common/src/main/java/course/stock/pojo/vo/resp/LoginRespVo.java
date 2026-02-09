package course.stock.pojo.vo.resp;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRespVo {
    // 用户ID
    @ApiModelProperty("用户ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    // 电话
    @ApiModelProperty("电话")
    private String phone;
    // 用户名
    @ApiModelProperty("用户名")
    private String username;
    // 昵称
    @ApiModelProperty("昵称")
    private String nickName;

}
