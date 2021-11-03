package lotto.domain;

import lotto.exception.MyErrorCode;
import lotto.exception.MyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName("중복된 로또가 있는지 확인(중복이 있을 경우)")
    void checkExistDuplicationballs() {
        Ball one = new Ball(1);
        Ball duplicationNumberOne = new Ball(1);
        Ball three = new Ball(3);
        Ball four = new Ball(4);
        Ball five = new Ball(5);
        Ball six = new Ball(6);

        assertThatExceptionOfType(MyException.class)
                .isThrownBy(() -> {
                    new Lotto(Arrays.asList(one, duplicationNumberOne, three, four, five, six));
                }).withMessageContaining(MyErrorCode.EXIST_DUPLICATION_NUMBER.errorMessage());
    }

    @Test
    @DisplayName("로또의 개수가 6개인지 확인(6개가 아닐 경우")
    void checkLottoSize(){
        Ball one = new Ball(1);
        Ball three = new Ball(3);
        Ball four = new Ball(4);
        Ball five = new Ball(5);

        assertThatExceptionOfType(MyException.class)
                .isThrownBy(() -> {
                    new Lotto(Arrays.asList(one,three, four, five));
                }).withMessageContaining(MyErrorCode.VALID_LOTTO_SIZE_SIX.errorMessage());
    }
}
