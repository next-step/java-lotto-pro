package lotto.domain;

import lotto.exception.MyErrorCode;
import lotto.exception.MyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoTest {

    private Lotto winningLotto;

    @BeforeEach
    void setUp() {
        List<Ball> balls = Arrays.asList(new Ball(1), new Ball(2), new Ball(3),
                new Ball(4), new Ball(5), new Ball(6));
        winningLotto = new Lotto(balls);
    }

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
    void checkLottoSize() {
        Ball one = new Ball(1);
        Ball three = new Ball(3);
        Ball four = new Ball(4);
        Ball five = new Ball(5);

        assertThatExceptionOfType(MyException.class)
                .isThrownBy(() -> {
                    new Lotto(Arrays.asList(one, three, four, five));
                }).withMessageContaining(MyErrorCode.VALID_LOTTO_SIZE_SIX.errorMessage());
    }

    @Test
    @DisplayName("로또의 맞춘 개수가 1개인 경우 ")
    void compareLotto1() {
        Lotto lotto = makeLottoBall(Arrays.asList(1, 12, 23, 34, 35, 36));
        int result = lotto.match(winningLotto);
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("로또의 맞춘 개수가 2개인 경우 ")
    void compareLotto2() {
        Lotto lotto = makeLottoBall(Arrays.asList(1, 2, 13, 14, 25, 26));
        int result = lotto.match(winningLotto);
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("로또의 맞춘 개수가 3개인 경우 ")
    void compareLotto3() {
        Lotto lotto = makeLottoBall(Arrays.asList(1, 2, 3, 14, 15, 16));
        int result = lotto.match(winningLotto);
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("로또의 맞춘 개수가 4개인 경우 ")
    void compareLotto4() {
        Lotto lotto = makeLottoBall(Arrays.asList(1, 2, 3, 4, 25, 26));
        int result = lotto.match(winningLotto);
        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("로또의 맞춘 개수가 5개인 경우 ")
    void compareLotto5() {
        Lotto lotto = makeLottoBall(Arrays.asList(1, 2, 3, 4, 5, 34));
        int result = lotto.match(winningLotto);
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("로또의 맞춘 개수가 6개인 경우 ")
    void compareLotto6() {
        Lotto lotto = makeLottoBall(Arrays.asList(1, 2, 3, 4, 5, 6));
        int result = lotto.match(winningLotto);
        assertThat(result).isEqualTo(6);
    }

    private Lotto makeLottoBall(List<Integer> balls) {
        List<Ball> ballBasket = balls.stream()
                .map(number -> new Ball(number))
                .collect(Collectors.toList());
        return new Lotto(ballBasket);
    }
}
