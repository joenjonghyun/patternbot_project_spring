package kr.co.patternbot.orders.domains;


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
@Table(name = "orders")
public class Orders {
    @Id
    @Column(name = "ordersid")
    @GeneratedValue private long ordersid;
    @Column private @NotNull String tradeDateUtc;
    @Column private @NotNull String tradeTimeUtc;
    @Column private @NotNull String tradePrice;
    @Column private @NotNull String tradeVolume;
    @Column private @NotNull String askBid;
    @Column private @NotNull String orderState;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coinid")
    private Coin coin;
}
