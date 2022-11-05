package lotto.model.lotto.ticket;

import lotto.constant.utils.StringUtils;

import java.util.Objects;

public class LottoNumber {
    private static final int LOTTO_MINIMUM_NUMBER = 1;
    private static final int LOTTO_MAXIMUM_NUMBER = 45;
    private final int value;

    public LottoNumber(String token) {
        if (StringUtils.isNullOrEmpty(token)) {
            throw new IllegalArgumentException("올바르지 않은 값을 개별 당첨 번호에 사용했습니다.");
        }
        final String trimmedToken = token.trim();
        int tokenValue;
        try {
            tokenValue = Integer.parseInt(trimmedToken);
        } catch (Exception e) {
            throw new IllegalArgumentException("개별 당첨 번호는 반드시 숫자여야 합니다.");
        }
        if (lottoNumberInValidRange(tokenValue)) {
            throw new IllegalArgumentException("개별 당첨 번호는 1 이상 45 이하의 숫자 중에 하나여야 합니다.");
        }
        this.value = tokenValue;
    }

    public LottoNumber(int value) {
        if (lottoNumberInValidRange(value)) {
            throw new IllegalArgumentException("개별 당첨 번호는 1 이상 45 이하의 숫자 중에 하나여야 합니다.");
        }
        this.value = value;
    }

    private boolean lottoNumberInValidRange(int tokenValue) {
        return tokenValue < LOTTO_MINIMUM_NUMBER || LOTTO_MAXIMUM_NUMBER < tokenValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
