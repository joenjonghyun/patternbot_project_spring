package kr.co.patternbot.sale.domains;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
//디비로 가는건 유저
@ToString
@Setter
@Entity
@Table(name = "sales")
public class Sale {
    @Id @Column(name = "saleid")
    @GeneratedValue private long saleid;
    @Column private @NotNull String pucnasedate;
    @Column private @NotNull String events;
    @Column private @NotNull String unitprice;
    @Column private @NotNull String amount;
    @Column private @NotNull String purchaseamount;
    @Column private @NotNull String marketprice;
    @Column private @NotNull String profitloss;
}
