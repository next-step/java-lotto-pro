package lotto.domain;

import static lotto.constants.LottoConstants.MAX;
import static lotto.constants.LottoConstants.MIN;

import java.util.Objects;
import lotto.domain.validator.LottoNumberValidatorGroup;
import lotto.exception.ExceptionType;

public class LottoNo {
    private final int lottoNo;
    private final LottoNumberValidatorGroup validatorGroup = LottoNumberValidatorGroup.getInstance();

    public LottoNo(String lottoNo) {
        validatorGroup.validate(lottoNo);
        this.lottoNo = Integer.parseInt(lottoNo);
    }

    public LottoNo(int lottoNo) {
        if (isLottoNumberSize(lottoNo)) {
            throw new IllegalArgumentException(ExceptionType.INVALID_NUMBER_SIZE.getMessage());
        }

        this.lottoNo = lottoNo;
    }

    public static boolean isLottoNumberSize(int number) {
        return number > MAX || number < MIN;
    }

    public int getLottoNo() {
        return lottoNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNo lottoNo1 = (LottoNo) o;
        return getLottoNo() == lottoNo1.getLottoNo() && Objects.equals(validatorGroup,
            lottoNo1.validatorGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLottoNo(), validatorGroup);
    }
}
