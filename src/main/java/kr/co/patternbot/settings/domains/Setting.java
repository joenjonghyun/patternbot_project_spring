package kr.co.patternbot.settings.domains;

import kr.co.patternbot.coins.domains.Coin;
import kr.co.patternbot.users.domains.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Entity
@Table(name = "settings")
public class Setting {
    @Id
    @Column(name = "settingid")
    @GeneratedValue private long settingid; //설정id
    @Column private @NotNull String amount; //투자금액
    @Column private String profitRatio; //목표이익률
    @Column private String lossRatio; //손해률

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coinid")
    private Coin coin;
}