package step3.dto;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

import step3.domain.Amount;
import step3.domain.LottoRank;
import step3.domain.LottoRanks;
import step3.domain.constance.LottoConstant;

public class LottoRanksDto {
    public static final String TITLE = "당첨 통계\n";
    public static final String DIVIDE = "---------\n";
    public static final String LOTTO_LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    public static final String YIELD_MESSAGE_FORMAT = "총 수익률은 %s입니다";
    public static final int MIN_PRINT_RANK = 3;
    public static final int LOSS_VALUE = 1;

    private final List<LottoRankDto> lottoRanksDto;
    private final Long totalPrize;
    private final int amount;

    private LottoRanksDto(List<LottoRankDto> lottoRanksDto, Long totalPrize, int amount) {
        this.lottoRanksDto = lottoRanksDto;
        this.totalPrize = totalPrize;
        this.amount = amount;
    }

    public static LottoRanksDto of(LottoRanks lottoRanks, Amount amount) {
        List<LottoRankDto> lottoRanksDto = new ArrayList<>();
        for (LottoRank lottoRank : lottoRanks.values()) {
            if (lottoRank.matchNumber >= MIN_PRINT_RANK) {
                // 당첨된 로또 갯수    일치하는 로또번호 갯수  상금
                lottoRanksDto.add(new LottoRankDto(lottoRank.matchCount, lottoRank.matchNumber, lottoRank.prize));
            }
        }
        return new LottoRanksDto(lottoRanksDto, lottoRanks.totalPrize(), amount.getAmount());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TITLE).append(DIVIDE);
        for (LottoRankDto lottoRankDto : lottoRanksDto) {
            appendln(sb, lottoRankDto.toString());
        }
        double yield = (double)totalPrize / amount;

        append(sb, String.format(YIELD_MESSAGE_FORMAT, String.format("%.2f", yield)));
        if (yield < LOSS_VALUE) {
            appendln(sb, LOTTO_LOSS_MESSAGE);
        }

        return sb.toString();
    }

    private void appendln(StringBuilder sb, String message) {
        sb.append(message).append("\n");
    }

    private void append(StringBuilder sb, String message) {
        sb.append(message);
    }
}
