package Lotto;

import Lotto.enums.CompareEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private Lotto defaultLotto;

    @BeforeEach
    void init() {
        defaultLotto = new Lotto("1, 2, 3, 4, 5, 6");
    }

    @Test
    public void 로또_1과45사이_6개의_숫자_추출() {
        Lotto lotto = new Lotto();
        lotto.generate();
        assertThat(Collections.max(lotto.getNumbers())).isBetween(1, 45);
        assertThat(Collections.min(lotto.getNumbers())).isBetween(1, 45);
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:true", "5:true", "6:true", "7:false"}, delimiter = ':')
    public void 지난주_당첨번호_생성(int input, boolean flag) {
        assertThat(defaultLotto.getNumbers().contains(input)).isEqualTo(flag);
    }

    @Test
    @DisplayName("두 개의 로또를 비교해서 맞은 숫자 갯수에 따른 당첨 여부 확인")
    public void 두개_로또_비교() {
        int bonusNumber = 10;

        WinLotto first = new WinLotto("1, 2, 3, 4, 5, 6", bonusNumber);
        WinLotto second = new WinLotto("1, 2, 3, 4, 5, 7", 6);
        WinLotto third = new WinLotto("1, 2, 3, 4, 5, 7", bonusNumber);
        WinLotto fourth = new WinLotto("1, 2, 3, 4, 7, 8", bonusNumber);
        WinLotto fifth = new WinLotto("1, 2, 3, 7, 8, 9", bonusNumber);
        WinLotto fail = new WinLotto("3, 5, 12, 15, 20, 30", bonusNumber);

        assertThat(defaultLotto.compare(first)).isEqualTo(CompareEnum.First);
        assertThat(defaultLotto.compare(second)).isEqualTo(CompareEnum.Second);
        assertThat(defaultLotto.compare(third)).isEqualTo(CompareEnum.Third);
        assertThat(defaultLotto.compare(fourth)).isEqualTo(CompareEnum.Fourth);
        assertThat(defaultLotto.compare(fifth)).isEqualTo(CompareEnum.Fifth);
        assertThat(defaultLotto.compare(fail)).isEqualTo(CompareEnum.Fail);
    }
}
