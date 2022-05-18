package lotto;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import converter.IntegerListConverter;
import java.util.Arrays;
import java.util.List;
import lotto.factory.LottoNumbersFactory;
import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;
import lotto.number.WinLottoNumbers;
import lotto.rank.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.ValueSource;

public class WinLottoNumbersTest {

    private WinLottoNumbers winLottoNumbers;
    private LottoNumbersFactory factory = new LottoNumbersFactory();

    @BeforeEach
    void setUp() {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        int bonusNumber = 11;
        LottoNumbers lottoNumbers = factory.createLottoNumbers(Arrays.stream(numbers).boxed().collect(toList()));
        winLottoNumbers = WinLottoNumbers.Builder.getInstance()
                .lottoNumbers(lottoNumbers)
                .bonusNumber(new LottoNumber(bonusNumber))
                .build();
    }

    @Test
    void 당첨번호와_보너스번호가_중복되는_경우_생성_실패() {
        String input = "11,22,23,33,43,4";
        List<Integer> numbers = Arrays.stream(input.split(",")).map((str) -> Integer.parseInt(str)).collect(toList());
        LottoNumbers lottoNumbers = factory.createLottoNumbers(numbers);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            WinLottoNumbers.Builder.getInstance().lottoNumbers(lottoNumbers).bonusNumber(new LottoNumber(11)).build();
        });
    }

    @Test
    void 당첨_테스트_1등() {
        List<Integer> numbers = convertStringToList("1,2,3,4,5,6");
        LottoNumbers lottoNumbers = factory.createLottoNumbers(numbers);
        LottoRank rank = winLottoNumbers.match(lottoNumbers);
        assertThat(rank).isEqualTo(LottoRank.FIRST_PLACE);
    }

    private List<Integer> convertStringToList(String source) {
        IntegerListConverter converter = new IntegerListConverter();
        List<Integer> converted = (List<Integer>) converter.convert(source, List.class);
        return converted;
    }

    @Test
    void 당첨_테스트_2등() {
        List<Integer> numbers = convertStringToList("1,2,3,4,5,11");
        LottoNumbers lottoNumbers = factory.createLottoNumbers(numbers);
        LottoRank rank = winLottoNumbers.match(lottoNumbers);
        assertThat(rank).isEqualTo(LottoRank.SECOND_PLACE);
    }

    @Test
    void 당첨_테스트_3등() {
        List<Integer> numbers = convertStringToList("1,2,3,4,5,17");
        LottoNumbers lottoNumbers = factory.createLottoNumbers(numbers);
        LottoRank rank = winLottoNumbers.match(lottoNumbers);
        assertThat(rank).isEqualTo(LottoRank.THIRD_PLACE);
    }

    @Test
    void 당첨_테스트_4등() {
        List<Integer> numbers = convertStringToList("1,2,3,4,7,8");
        LottoNumbers lottoNumbers = factory.createLottoNumbers(numbers);
        LottoRank rank = winLottoNumbers.match(lottoNumbers);
        assertThat(rank).isEqualTo(LottoRank.FOURTH_PLACE);
    }

    @Test
    void 당첨_테스트_5등() {
        List<Integer> numbers = convertStringToList("1,2,3,7,8,9");
        LottoNumbers lottoNumbers = factory.createLottoNumbers(numbers);
        LottoRank rank = winLottoNumbers.match(lottoNumbers);
        assertThat(rank).isEqualTo(LottoRank.FIFTH_PLACE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,7,8,9,10", "1,7,8,9,10,11", "7,8,9,10,11,12"})
    void 미당첨_테스트(@ConvertWith(IntegerListConverter.class) List<Integer> numbers) {
        LottoNumbers lottoNumbers = factory.createLottoNumbers(numbers);
        LottoRank rank = winLottoNumbers.match(lottoNumbers);
        assertThat(rank).isEqualTo(LottoRank.NO_PRIZE);
    }


}
