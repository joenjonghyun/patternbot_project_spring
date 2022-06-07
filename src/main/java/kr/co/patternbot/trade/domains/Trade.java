package kr.co.patternbot.trade.domains;

import com.sun.istack.NotNull;
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
    @GeneratedValue
    private long tradeid;
    @Column private @NotNull String coinName;
    @Column private String investmentAmount;
    @Column private String profitRatio;
    @Column private String lossRatio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private User user;
}