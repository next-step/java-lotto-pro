package lotto;

import lotto.model.LottoNumbers;
import lotto.model.ManualNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.common.Constants.MAX_RANGE_VALUE;
import static lotto.common.Constants.MIN_RANGE_VALUE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("수동게임 기능 테스트")
public class ManualGameTests {

    @DisplayName("빈 수동게임 생성을 테스트합니다.")
    @Test
    public void 빈_수동게임_생성() {
        List<LottoNumbers> manualGameNumbers = new ArrayList<>();
        ManualNumbers manualNumbers = new ManualNumbers(manualGameNumbers);

        assertThat(manualNumbers.getList().size()).isEqualTo(0);
    }

    @DisplayName("수동게임 생성을 테스트합니다.")
    @Test
    public void 수동게임_생성() {
        final String[] inputValues = {"1,2,3,4,5,6", "10,11,12,13,14,15", "10,20,30,40,41,42"};
        List<LottoNumbers> list = IntStream.range(0, inputValues.length)
                .boxed()
                .map(operand -> new LottoNumbers(inputValues[operand]))
                .collect(Collectors.toList());
        ManualNumbers manualNumbers = new ManualNumbers(list);

        assertAll(
                () -> assertThat(manualNumbers.getList().size()).isEqualTo(inputValues.length),
                () -> manualNumbers.getList().forEach(manualGame -> {
                    assertThat(manualGame)
                            .isNotNull()
                            .isInstanceOf(LottoNumbers.class);
                }),
                () -> manualNumbers.getList().forEach(manualGame -> {
                    manualGame.getValues().forEach(lottoNumber -> {
                        assertThat(lottoNumber.getValue())
                                .isInstanceOf(Integer.class)
                                .isPositive()
                                .isGreaterThanOrEqualTo(MIN_RANGE_VALUE)
                                .isLessThanOrEqualTo(MAX_RANGE_VALUE);
                    });
                })
        );
    }

}
