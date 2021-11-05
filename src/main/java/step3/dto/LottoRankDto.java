package step3.dto;

import step3.domain.constance.LottoConstant;

public class LottoRankDto {
    public static final String LOTTO_RANK_FORMAT = "%s개 일치 (%d원)- %d개";

    private int matchCount;
    private int matchNumber;
    private Long prize;

    public LottoRankDto(int matchCount, int matchNumber, Long prize) {
        this.matchCount = matchCount;// 당첨된 로또 갯수
        this.matchNumber = matchNumber;// 일치하는 로또번호 갯수
        this.prize = prize;
    }

    @Override
    public String toString() {
        return String.format(LottoConstant.LOTTO_REPORT_FORMAT, matchNumber, prize, matchCount);
    }
}
