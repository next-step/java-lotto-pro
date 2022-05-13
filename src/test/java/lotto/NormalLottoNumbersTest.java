package lotto;

import java.util.List;
import lotto.factory.LottoNumbersFactory;
import lotto.factory.NormalLottoNumbersFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.ValueSource;
import converter.IntegerListConverter;

import static org.assertj.core.api.Assertions.*;

public class NormalLottoNumbersTest {

    private LottoNumbersFactory lottoNumbersFactory = new NormalLottoNumbersFactory();

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3","1,2,3,4,5,6,7"})
    void 번호개수가_다른경우_로또번호세트_생성실패(@ConvertWith(IntegerListConverter.class) List<Integer> numbers){
        assertThatIllegalArgumentException().isThrownBy(()->{
            lottoNumbersFactory.createLottoNumbers(numbers);
        });
    }
    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4,5"})
    void 숫자가_중복된_경우_로또번호세트_생성실패(@ConvertWith(IntegerListConverter.class) List<Integer> numbers){
        assertThatIllegalArgumentException().isThrownBy(()->{
            lottoNumbersFactory.createLottoNumbers(numbers);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6","45,23,15,25,21,11"})
    void 로또번호_한세트_생성_성공_테스트(@ConvertWith(IntegerListConverter.class) List<Integer> numbers){
        lottoNumbersFactory.createLottoNumbers(numbers);
        assertThat(lottoNumbersFactory.createLottoNumbers(numbers)).isEqualTo(lottoNumbersFactory.createLottoNumbers(numbers));
    }
}
