package kr.co.patternbot.coins.domains;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * packageName    : kr.co.patternbot.coins.domains
 * fileName       : CoinDTO
 * author         : j2022
 * date           : 2022-07-01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-01        j2022       최초 생성
 */
@Component @Data
public class CoinDTO {
    @ApiModelProperty(position = 1) private long coinid;
    @ApiModelProperty(position = 2) String market;
    @ApiModelProperty(position = 3) String candleDateTimeUtc;
    @ApiModelProperty(position = 4) String candleDateTimeKst;
    @ApiModelProperty(position = 5) String openingPrice;
    @ApiModelProperty(position = 6) String highPrice;
    @ApiModelProperty(position = 7) String lowPrice;
    @ApiModelProperty(position = 8) String tradePrice;
    @ApiModelProperty(position = 9) String changePrice;
    @ApiModelProperty(position = 10) String changeRate;
    @ApiModelProperty(position = 11) String timestamp;
    @ApiModelProperty(position = 12) String candleAccTradePrice;
    @ApiModelProperty(position = 13) String candleAccTradeVolume;
    @ApiModelProperty(position = 14) String prevClosingPrice;
    @ApiModelProperty(position = 15) String unit;
}
