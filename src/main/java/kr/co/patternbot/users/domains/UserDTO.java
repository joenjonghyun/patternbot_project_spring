package kr.co.patternbot.users.domains;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

//swagger 다운받아야함
//@ToString 지우긴했는데 알아보자
@Component @Data
public class UserDTO {
    @ApiModelProperty(position = 1) private long userid;
    @ApiModelProperty(position = 2) String username;
    @ApiModelProperty(position = 3) String password;
    @ApiModelProperty(position = 4) String email;
    @ApiModelProperty(position = 5) String name;
    @ApiModelProperty(position = 6) String birth;
    @ApiModelProperty(position = 7) String mobile;
    //@ApiModelProperty(position = 5) private String regDate;
    @ApiModelProperty(position = 8) private String token;
    @ApiModelProperty(position = 9) private List<Role> roles;
}
