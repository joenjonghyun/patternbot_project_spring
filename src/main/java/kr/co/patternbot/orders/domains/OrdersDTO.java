package kr.co.patternbot.orders.domains;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * packageName    : kr.co.patternbot.orders.domains
 * fileName       : OrdersDTO
 * author         : j2022
 * date           : 2022-07-01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-01        j2022       최초 생성
 */
@Component @Data
public class OrdersDTO {
    @ApiModelProperty(position = 1) private long ordersid;
    @ApiModelProperty(position = 2) String tradeDateUtc;
    @ApiModelProperty(position = 3) String tradeTimeUtc;
    @ApiModelProperty(position = 4) String timeStamp;
    @ApiModelProperty(position = 5) String tradePrice;
    @ApiModelProperty(position = 6) String tradeVolume;
    @ApiModelProperty(position = 7) String askBid;
    @ApiModelProperty(position = 8) String orderState;
}
