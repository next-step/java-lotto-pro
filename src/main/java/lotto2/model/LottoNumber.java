package lotto2.model;

import lotto2.common.StringUtils;
import lotto2.model.constant.LottoConstant;

import java.util.Objects;

public class LottoNumber {
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
        if (lottoNumberOutOfRange(tokenValue)) {
            throw new IllegalArgumentException("개별 당첨 번호는 1 이상 45 이하의 숫자 중에 하나여야 합니다.");
        }
        this.value = tokenValue;
    }

    public LottoNumber(int value) {
        if (lottoNumberOutOfRange(value)) {
            throw new IllegalArgumentException("개별 당첨 번호는 1 이상 45 이하의 숫자 중에 하나여야 합니다.");
        }
        this.value = value;
    }

    private boolean lottoNumberOutOfRange(int tokenValue) {
        return tokenValue < LottoConstant.LOTTO_MINIMUM_NUMBER || LottoConstant.LOTTO_MAXIMUM_NUMBER < tokenValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
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
