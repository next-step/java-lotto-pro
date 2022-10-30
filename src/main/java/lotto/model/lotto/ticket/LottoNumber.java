package lotto.model.lotto.ticket;

import lotto.constant.numbers.LottoConstant;
import lotto.constant.utils.StringUtils;

public class LottoNumber {
    private final int value;

    public LottoNumber(String token) {
        if (StringUtils.isNullOrEmpty(token)) {
            throw new NumberFormatException("올바르지 않은 값을 개별 당첨 번호에 사용했습니다.");
        }
        final String trimmedToken = token.trim();
        int tokenValue;
        try {
            tokenValue = Integer.parseInt(trimmedToken);
        } catch (Exception e) {
            throw new NumberFormatException("개별 당첨 번호는 반드시 숫자여야 합니다.");
        }
        if (!isValidLottoNumber(tokenValue)) {
            throw new NumberFormatException("개별 당첨 번호는 1 이상 45 이하의 숫자 중에 하나여야 합니다.");
        }
        this.value = tokenValue;
    }

    public LottoNumber(int value) {
        this.value = value;
    }

    private boolean isValidLottoNumber(int tokenValue) {
        return LottoConstant.LOTTO_MINIMUM_NUMBER <= tokenValue && tokenValue <= LottoConstant.LOTTO_MAXIMUM_NUMBER;
    }
}
