package kr.co.patternbot.user.domains;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

//swagger 다운받아야함

@Component @Data @ToString
public class UserDTO {
    @ApiModelProperty(position = 1) private long userid;
    @ApiModelProperty(position = 2) String username;
    @ApiModelProperty(position = 3) String password;
    @ApiModelProperty(position = 4) String email;
    @ApiModelProperty(position = 5) private String regDate;
    @ApiModelProperty(position = 6) private String token;
    @ApiModelProperty(position = 7) private List<Role> roles;
    @ApiModelProperty(position = 8) String name;
}
