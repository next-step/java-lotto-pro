package study.lotto.controller.dto;

import study.lotto.model.LottoNumber;
import study.lotto.model.WinningLottery;

import java.util.HashSet;
import java.util.Set;

public class LottoWinningNumberRequestDto {

    private final Set<Integer> lottoWinningNumbers;

    public LottoWinningNumberRequestDto(final Set<Integer> lottoWinningNumbers) {
        this.lottoWinningNumbers = lottoWinningNumbers;
    }

    public WinningLottery toEntity() {
        final Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (Integer lottoNumber : lottoWinningNumbers) {
            lottoNumbers.add(LottoNumber.valueOf(lottoNumber));
        }
        return WinningLottery.valueOf(lottoNumbers);
    }
}
