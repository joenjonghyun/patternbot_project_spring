package kr.co.patternbot.coin.domains;

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
    @Column private @NotNull String unit;

    @OneToMany(mappedBy = "coin")
    List<Setting> settings = new ArrayList<>();

    @OneToMany(mappedBy = "coin")
    List<Orders> orders = new ArrayList<>();
}
