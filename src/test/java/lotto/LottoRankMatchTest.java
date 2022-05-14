package lotto;

import converter.IntegerListConverter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.factory.LottoNumbersFactory;

import static org.assertj.core.api.Assertions.*;

import lotto.number.LottoNumbers;
import lotto.rank.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoRankMatchTest {

    private LottoNumbers winLottoNumbers;
    private LottoNumbersFactory factory = new LottoNumbersFactory();

    @BeforeEach
    void setUp(){
        int[] numbers = {1,2,3,4,5,6};
        winLottoNumbers = factory.createLottoNumbers(Arrays.stream(numbers).boxed().collect(Collectors.toList()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void 당첨_테스트_1등(@ConvertWith(IntegerListConverter.class) List<Integer> numbers){
        LottoRank rank = factory.createLottoNumbers(numbers).matchWithWinNumbers(winLottoNumbers);
        assertThat(rank).isEqualTo(LottoRank.FIRST_PLACE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,7"})
    void 당첨_테스트_2등(@ConvertWith(IntegerListConverter.class) List<Integer> numbers){
        LottoRank rank = factory.createLottoNumbers(numbers).matchWithWinNumbers(winLottoNumbers);
        assertThat(rank).isEqualTo(LottoRank.SECOND_PLACE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,7,8"})
    void 당첨_테스트_3등(@ConvertWith(IntegerListConverter.class) List<Integer> numbers){
        LottoRank rank = factory.createLottoNumbers(numbers).matchWithWinNumbers(winLottoNumbers);
        assertThat(rank).isEqualTo(LottoRank.THIRD_PLACE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,7,8,9"})
    void 당첨_테스트_4등(@ConvertWith(IntegerListConverter.class) List<Integer> numbers){
        LottoRank rank = factory.createLottoNumbers(numbers).matchWithWinNumbers(winLottoNumbers);
        assertThat(rank).isEqualTo(LottoRank.FOURTH_PLACE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,7,8,9,10","1,7,8,9,10,11","7,8,9,10,11,12"})
    void 미당첨_테스트(@ConvertWith(IntegerListConverter.class) List<Integer> numbers){
        LottoRank rank = factory.createLottoNumbers(numbers).matchWithWinNumbers(winLottoNumbers);
        assertThat(rank).isEqualTo(LottoRank.NO_PRIZE);
    }
}
