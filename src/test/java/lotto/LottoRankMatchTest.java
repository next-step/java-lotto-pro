package lotto;

import converter.IntegerListConverter;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.*;
import lotto.factory.LottoNumbersFactory;

import static org.assertj.core.api.Assertions.*;

import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;
import lotto.number.WinLottoNumbers;
import lotto.rank.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoRankMatchTest {

    private WinLottoNumbers winLottoNumbers;
    private LottoNumbersFactory factory = new LottoNumbersFactory();

    @BeforeEach
    void setUp(){
        int[] numbers = {1,2,3,4,5,6};
        int bonusNumber = 11;
        LottoNumbers lottoNumbers = factory.createLottoNumbers(Arrays.stream(numbers).boxed().collect(toList()));
        winLottoNumbers = WinLottoNumbers.Builder.getInstance()
                .lottoNumbers(lottoNumbers)
                .bonusNumber(new LottoNumber(bonusNumber))
                .build();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void 당첨_테스트_1등(@ConvertWith(IntegerListConverter.class) List<Integer> numbers){
        LottoNumbers lottoNumbers = factory.createLottoNumbers(numbers);
        LottoRank rank = winLottoNumbers.match(lottoNumbers);
        assertThat(rank).isEqualTo(LottoRank.FIRST_PLACE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,11"})
    void 당첨_테스트_2등(@ConvertWith(IntegerListConverter.class) List<Integer> numbers){
        LottoNumbers lottoNumbers = factory.createLottoNumbers(numbers);
        LottoRank rank = winLottoNumbers.match(lottoNumbers);
        assertThat(rank).isEqualTo(LottoRank.SECOND_PLACE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,17"})
    void 당첨_테스트_3등(@ConvertWith(IntegerListConverter.class) List<Integer> numbers){
        LottoNumbers lottoNumbers = factory.createLottoNumbers(numbers);
        LottoRank rank = winLottoNumbers.match(lottoNumbers);
        assertThat(rank).isEqualTo(LottoRank.THIRD_PLACE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,7,8"})
    void 당첨_테스트_4등(@ConvertWith(IntegerListConverter.class) List<Integer> numbers){
        LottoNumbers lottoNumbers = factory.createLottoNumbers(numbers);
        LottoRank rank = winLottoNumbers.match(lottoNumbers);
        assertThat(rank).isEqualTo(LottoRank.FOURTH_PLACE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,7,8,9"})
    void 당첨_테스트_5등(@ConvertWith(IntegerListConverter.class) List<Integer> numbers){
        LottoNumbers lottoNumbers = factory.createLottoNumbers(numbers);
        LottoRank rank = winLottoNumbers.match(lottoNumbers);
        assertThat(rank).isEqualTo(LottoRank.FIFTH_PLACE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,7,8,9,10","1,7,8,9,10,11","7,8,9,10,11,12"})
    void 미당첨_테스트(@ConvertWith(IntegerListConverter.class) List<Integer> numbers){
        LottoNumbers lottoNumbers = factory.createLottoNumbers(numbers);
        LottoRank rank = winLottoNumbers.match(lottoNumbers);
        assertThat(rank).isEqualTo(LottoRank.NO_PRIZE);
    }
}
