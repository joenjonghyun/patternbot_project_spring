package kr.co.patternbot.coin.domains;

import com.sun.istack.NotNull;
import kr.co.patternbot.invest.domains.Invest;
import kr.co.patternbot.user.domains.User;
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
@Table(name = "coins")
public class Coin {
    @Id @Column(name = "coinid")
    @GeneratedValue private long coinid;
    @Column private @NotNull String market;
    @Column private @NotNull String candleDateTimeUtc;
    @Column private @NotNull String candleDateTimeKst;
    @Column private @NotNull String openingPrice;
    @Column private @NotNull String highPrice;
    @Column private @NotNull String lowPrice;
    @Column private @NotNull String tradePrice;
    @Column private @NotNull String timestamp;
    @Column private @NotNull String candleAccTradePrice;
    @Column private @NotNull String candleAccTradeVolume;
    @Column private @NotNull String prevClosingPrice;
    @Column private @NotNull String changePrice;
    @Column private @NotNull String changeRate;

    @OneToMany(mappedBy = "coin")
    List<Invest> a = new ArrayList<>();
}
