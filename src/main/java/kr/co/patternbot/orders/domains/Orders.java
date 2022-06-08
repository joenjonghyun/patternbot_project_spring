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
    @Column private @NotNull String buyDate;
    @Column private @NotNull String sellDate;
    @Column private @NotNull String unitPrice;
    @Column private @NotNull String amount;
    @Column private @NotNull String buyPrice;
    @Column private @NotNull String marketPrice;
    @Column private @NotNull String orderState;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coinid")
    private Coin coin;
}
