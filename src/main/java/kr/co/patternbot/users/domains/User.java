package kr.co.patternbot.users.domains;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import kr.co.patternbot.orders.domains.Orders;
import kr.co.patternbot.settings.domains.Setting;
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
    @GeneratedValue private long userid; //유저id
    @Column private  String username; //유저네임
    @Column private  String email; // 이메일
    @Column private String password; //비밀번호
    @Column private  String birth; //생일
    @Column private  String name; //이름
    @Column private  String mobile; //전화번호
    @Column private String token; //토큰
    //@Column(name = "reg_date") private String regDate; 회원가입날짜

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    List<Setting> settings = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    List<Orders> orders = new ArrayList<>();

    //EAGER는 등급에 맞는 토큰을 준다고 생각하면 됨
    @ElementCollection(fetch = FetchType.EAGER)
    public List<Role> roles;

}
