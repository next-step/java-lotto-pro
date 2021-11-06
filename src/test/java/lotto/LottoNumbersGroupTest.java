package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersGroupTest {
    private LottoNumbers prizeLottoNumbers;
    @BeforeEach
    void setup() {
        prizeLottoNumbers = new LottoNumbers(
                Stream.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))
                        .collect(Collectors.toSet()));
    }

    @DisplayName("랜덤 로또 숫자 그룹 생성 테스트")
    @Test
    void generateRandomLottoNumberGroupTest() {
        BuyAmount buyAmount = new BuyAmount(14000);
        LottoNumbersGroup lottoNumbersGroup = new LottoNumbersGroup(buyAmount, prizeLottoNumbers);
        System.out.println(lottoNumbersGroup);
    }

    @DisplayName("로또 숫자 수동 그룹 생성 테스트")
    @Test
    void generateManualLottoNumberGroupTest() {
        String[] myLottoNumbers = new String[]{"1,2,3,4,5,6", "2,3,4,13,12,14", "42,12,24,32,11,15"};
        LottoNumbersGroup lottoNumbersGroup = new LottoNumbersGroup(myLottoNumbers, prizeLottoNumbers);
        List<LottoNumbers> expectLottoNumbersList = getExampleLottoNumbersList();
        assertThat(lottoNumbersGroup).isEqualTo(new LottoNumbersGroup(expectLottoNumbersList, prizeLottoNumbers));
    }

    private List<LottoNumbers> getExampleLottoNumbersList() {
        return Arrays.asList(
                new LottoNumbers(
                        Stream.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))
                                .collect(Collectors.toSet())),
                new LottoNumbers(
                        Stream.of(new LottoNumber(4), new LottoNumber(2), new LottoNumber(3),
                                new LottoNumber(13), new LottoNumber(12), new LottoNumber(14))
                                .collect(Collectors.toSet())),
                new LottoNumbers(
                        Stream.of(new LottoNumber(42), new LottoNumber(12), new LottoNumber(24),
                                new LottoNumber(32), new LottoNumber(11), new LottoNumber(15))
                                .collect(Collectors.toSet()))
        );
    }


    @DisplayName("로또 그룹 결과 테스트")
    @Test
    void getLottoResultFromLottoNumberGroupTest() {
        String[] myLottoNumbers = new String[]{"1,2,3,4,5,6", "2,3,4,13,12,14", "27,13,25,35,9,15"};
        LottoNumbersGroup lottoNumbersGroup = new LottoNumbersGroup(myLottoNumbers, prizeLottoNumbers);
        // when
        LottoResults lottoResults = lottoNumbersGroup.getLottoResults();
        // then
        assertThat(lottoResults.getMatchAmount(3)).isEqualTo(1);
        assertThat(lottoResults.getMatchAmount(6)).isEqualTo(1);
    }
}
