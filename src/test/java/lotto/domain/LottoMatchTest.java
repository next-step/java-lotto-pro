package lotto.domain;

import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatchTest {

    @ParameterizedTest
    @CsvSource(value = {"15000:1,2,3,4,5,6"} , delimiter = ':')
    @DisplayName("매칭 정상 작동 테스트")
    public void LottoMatch(int purchaseAmount, String matchNumber) {
        Lotto lotto = new Lotto(purchaseAmount);
        List<Number> numbers = parseStringToNumberList(matchNumber);

        LottoMatch lottoMatch = new LottoMatch(numbers, lotto);

        assertThat(lottoMatch != null).isTrue();
    }

    public List<Number> parseStringToNumberList(String matchNumber) {
        List<Number> result = new ArrayList<>();
        for (String number : matchNumber.split(",")) {
            result.add(new Number(Integer.parseInt(number)));
        }
        return result;
    }



}