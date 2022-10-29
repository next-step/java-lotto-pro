package lotto.model.winning.numbers;

import lotto.constant.utils.StringUtils;

/**
 * 사용자가 입력한 당첨 번호 리스트의 개별 숫자를 저장하는 객체
 */
public class WinningNumberEach {
    private static final int LOTTO_MINIMUM_NUMBER = 1;
    private static final int LOTTO_MAXIMUM_NUMBER = 45;
    private final int value;

    public WinningNumberEach(String token) {
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
        value = tokenValue;
    }

    private boolean isValidLottoNumber(int tokenValue) {
        return LOTTO_MINIMUM_NUMBER <= tokenValue && tokenValue <= LOTTO_MAXIMUM_NUMBER;
    }
}
