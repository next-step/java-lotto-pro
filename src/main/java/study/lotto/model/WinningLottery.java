package study.lotto.model;

import study.lotto.model.exception.DuplicatedBonusLottoNumberException;
import study.lotto.model.exception.EmptyBonusLottoNumberException;

import java.util.Set;

public class WinningLottery extends Lottery {

    private static final String DUPLICATED_ERROR_MESSAGE = "보너스 번호는 기존에 당첨번호와 중복될 수 없습니다.";
    public static final String NOT_NULL_ERROR_MESSAGE = "보너스 번호는 필수 입니다.";

    private final LottoNumber bonusLottoNumber;

    private WinningLottery(final Set<LottoNumber> lottoNumbers, final LottoNumber bonusLottoNumber) {
        super(lottoNumbers);
        validateBonusNumber(bonusLottoNumber);
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public static WinningLottery valueOf(final Set<LottoNumber> lottoNumbers, final LottoNumber bonusLottoNumber) {
        return new WinningLottery(lottoNumbers, bonusLottoNumber);
    }

    private void validateBonusNumber(LottoNumber bonusLottoNumber) {
        validateNotNullBonusLottoNumber(bonusLottoNumber);
        validateDuplicateBonusLottoNumber(bonusLottoNumber);
    }

    private void validateNotNullBonusLottoNumber(final LottoNumber bonusLottoNumber) {
        if (bonusLottoNumber == null) {
            throw new EmptyBonusLottoNumberException(NOT_NULL_ERROR_MESSAGE);
        }
    }

    private void validateDuplicateBonusLottoNumber(final LottoNumber bonusLottoNumber) {
        if (super.getLottoNumbers().contains(bonusLottoNumber)) {
            throw new DuplicatedBonusLottoNumberException(DUPLICATED_ERROR_MESSAGE);
        }
    }

    public LottoNumber getBonusLottoNumber() {
        return bonusLottoNumber;
    }
}
