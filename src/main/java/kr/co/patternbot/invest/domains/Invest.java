package kr.co.patternbot.invest.domains;


import com.sun.istack.NotNull;
import kr.co.patternbot.coin.domains.Coin;
import kr.co.patternbot.user.domains.User;
import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Entity
@Table(name = "invests")
public class Invest {
    @Id @Column(name = "investid")
    @GeneratedValue private long investid;
    @Column private @NotNull String buyDate;
    @Column private @NotNull String coinName;
    @Column private @NotNull String unitPrice;
    @Column private @NotNull String amount;
    @Column private @NotNull String marketPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    @JoinColumn(name = "coinid")
    private User user;
    private Coin coin;
}
