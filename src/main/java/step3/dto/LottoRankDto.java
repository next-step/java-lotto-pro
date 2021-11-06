package step3.dto;

import step3.domain.constance.LottoConstant;

public class LottoRankDto {

    private final int matchCount;
    private final int matchNumber;
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
