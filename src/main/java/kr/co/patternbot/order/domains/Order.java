package kr.co.patternbot.order.domains;


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
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "orderid")
    @GeneratedValue private long orderid;
    @Column private @NotNull String buyDate;
    @Column private @NotNull String sellDate;
    @Column private @NotNull String coinName;
    @Column private @NotNull String unitPrice;
    @Column private @NotNull String amount;
    @Column private @NotNull String buyPrice;
    @Column private @NotNull String sellPrice;
    @Column private @NotNull String marketPrice;
    @Column private @NotNull String orderState;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private User user;
}
