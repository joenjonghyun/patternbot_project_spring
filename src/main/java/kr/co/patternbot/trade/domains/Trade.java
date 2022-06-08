package kr.co.patternbot.trade.domains;

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
@Table(name = "trades")
public class Trade {
    @Id
    @Column(name = "tradeid")
    @GeneratedValue private long tradeid;
    @Column private String amount;
    @Column private String profitRatio;
    @Column private String lossRatio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coinid")
    private Coin coin;
}