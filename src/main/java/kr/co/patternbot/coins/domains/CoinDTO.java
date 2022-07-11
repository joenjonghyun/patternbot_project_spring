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
    @ApiModelProperty(position = 5) Double openingPrice;
    @ApiModelProperty(position = 6) Double highPrice;
    @ApiModelProperty(position = 7) Double lowPrice;
    @ApiModelProperty(position = 8) Double tradePrice;
    @ApiModelProperty(position = 9) String changePrice;
    @ApiModelProperty(position = 10) String changeRate;
    @ApiModelProperty(position = 11) Long timestamp;
    @ApiModelProperty(position = 12) Double candleAccTradePrice;
    @ApiModelProperty(position = 13) Double candleAccTradeVolume;
    @ApiModelProperty(position = 14) String prevClosingPrice;
    @ApiModelProperty(position = 15) Integer unit;
}
