package lotto.domain;

import lotto.domain.error.LottoNumberErrorCode;
import lotto.domain.error.LottoTicketErrorCode;
import lotto.infrastructure.generator.LottoNumberGenerator;
import lotto.infrastructure.generator.NumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {

    private final NumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    private LottoTicket lottoTicket;

    @BeforeEach
    public void beforeEach() {
        lottoTicket = new LottoTicket(lottoNumberGenerator.generate());
    }

    @Test
    @DisplayName("로또 번호가 6개인지 테스트")
    public void getLottoNumbers_숫자갯수() {
        assertThat(lottoTicket.getLottoNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("로또 번호가 정렬된 순서인지 테스트")
    public void getLottoNumbers_정렬() {
        List<LottoNumber> lottoNumbers = lottoTicket.getLottoNumbers();

        int currentLottoNumber;
        int nextLottoNumber;

        for (int i = 0; i < lottoNumbers.size() - 1; i++) {
            currentLottoNumber = lottoNumbers.get(i).getLottoNumber();
            nextLottoNumber = lottoNumbers.get(i + 1).getLottoNumber();

            Assertions.assertThat(currentLottoNumber < nextLottoNumber).isTrue();
        }
    }

    @Test
    @DisplayName("로로 번호에 중복된 숫자가 있는지 테스트")
    public void getLottoNumbers_중복검사() {
        List<LottoNumber> lottoNumbers = lottoTicket.getLottoNumbers();
        Set<LottoNumber> nonDuplicatedInteger = new HashSet<>(lottoNumbers);

        assertThat(lottoNumbers.size()).isEqualTo(nonDuplicatedInteger.size());
    }

    @Test
    @DisplayName("해당 로또번호를 포함하고 있다면 true 반환")
    public void contains_true() {
        List<LottoNumber> lottoNumbers = lottoTicket.getLottoNumbers();

        for (LottoNumber lottoNumber : lottoNumbers) {
            assertThat(lottoTicket.contains(lottoNumber)).isTrue();
        }
    }

    @Test
    @DisplayName("해당 로또번호를 포함하고 있지 않다면 false 반환")
    public void contains_false() {
        List<Integer> fullLottoNumbers = getFullLottoNumbers();
        List<LottoNumber> lottoNumbers = lottoTicket.getLottoNumbers();

        for (LottoNumber lottoNumber : lottoNumbers) {
            int index = fullLottoNumbers.indexOf(lottoNumber.getLottoNumber());
            fullLottoNumbers.remove(index);
        }

        for (Integer integer : fullLottoNumbers) {
            assertThat(lottoTicket.contains(new LottoNumber(integer))).isFalse();
        }
    }

    @ParameterizedTest(name = "lottoNumbers가 null 또는 empty 이면 에러발생")
    @NullAndEmptySource
    public void lottoNumbers_주입_null_or_empty(List<Integer> lottoNumbers) {
        assertThatThrownBy(() -> new LottoTicket(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoTicketErrorCode.NOT_ALLOW_NULL_OR_EMPTY.getMessage());
    }

    @Test
    @DisplayName("lottoNumber의 size가 6이 아닌 경우 에러발생")
    public void lottoNumbers_주입_size() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> new LottoTicket(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(LottoTicketErrorCode.INVALID_LOTTO_NUMBER_SIZE.getMessage(), LottoTicket.LOTTO_SIZE));
    }

    @Test
    @DisplayName("lottoNumber에 중복되 숫자가 있다면 에러발생")
    public void lottoNumbers_주입_중복검사() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> new LottoTicket(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoTicketErrorCode.NOT_ALLOW_DUPLICATE.getMessage());
    }

    @Test
    @DisplayName("lottoNumber에 로또번호가 아닌 숫자가 존재한다면 에러발생")
    public void lottoNumbers_주입_로또숫자가_아닌_숫자() {
        List<Integer> lottoNumbers = Arrays.asList(100, 200, 300, 400, 500, 600);

        assertThatThrownBy(() -> new LottoTicket(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        String.format(
                                LottoNumberErrorCode.INVALID_LOTTO_NUMBER.getMessage(),
                                LottoNumber.LOTTO_MIN_NUMBER,
                                LottoNumber.LOTTO_MAX_NUMBER)
                );
    }

    private List<Integer> getFullLottoNumbers() {
        return IntStream.rangeClosed(LottoNumber.LOTTO_MIN_NUMBER, LottoNumber.LOTTO_MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }
}