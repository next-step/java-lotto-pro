package lotto.controller.converter;

import lotto.controller.dto.WinningLottoDTO;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.WinningLotto;

public class WinningLottoConverter {

    public static WinningLotto convert(WinningLottoDTO dto) {
        return WinningLotto.of(
                LottoNumbers.from(dto.getLottoNumbers()),
                LottoNumber.from(dto.getBonusNumber())
                );
    }
}
