package step3.dto;

import java.util.List;

import step3.domain.LottoNumber;
import step3.domain.LottoNumbers;
import step3.domain.WinningLotto;

public class LottoStatisticsRequestDto {
    private final List<LottoNumbers> buyLottoList;
    private final WinningLotto winningLotto;

    public LottoStatisticsRequestDto(List<LottoNumbers> buyLottoList, LottoNumbers winLottoNumbers,
        LottoNumber bonusLottoNumber) {
        this.buyLottoList = buyLottoList;
        this.winningLotto = new WinningLotto(winLottoNumbers, bonusLottoNumber);
    }

    public List<LottoNumbers> getBuyLottoList() {
        return buyLottoList;
    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }
}
