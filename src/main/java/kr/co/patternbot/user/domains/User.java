package kr.co.patternbot.user.domains;


import com.sun.istack.NotNull;

import kr.co.patternbot.orders.domains.Orders;
import kr.co.patternbot.setting.domains.Setting;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id @Column(name = "userid")
    @GeneratedValue private long userid;
    @Column private @NotNull String username;
    @Column private @NotNull String email;
    @Column private @NotNull String password;
    @Column(name = "reg_date") @NotNull private String regDate;

    @OneToMany(mappedBy = "user")
    List<Setting> settings = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<Orders> orders = new ArrayList<>();

    //EAGER는 등급에 맞는 토큰을 준다고 생각하면 됨
    @ElementCollection(fetch = FetchType.EAGER)
    public List<Role> roles;

}
