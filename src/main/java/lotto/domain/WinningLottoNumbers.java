package lotto.domain;

import java.util.List;
import java.util.Optional;

public class WinningLottoNumbers extends LottoNumbers{
    private BonusNumber bonusNumber;

    public WinningLottoNumbers(List<String> lottoNumbers, BonusNumber bonusNumber) {
        super(lottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    public LottoNumber getBonusNumber() {
        Optional.ofNullable(bonusNumber).orElseThrow(
                () -> new RuntimeException("보너스 번호가 존재하지 않습니다."));
        return bonusNumber.getBonusNumber();
    }
}
