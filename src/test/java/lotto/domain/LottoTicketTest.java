package lotto.domain;

import lotto.domain.error.LottoTicketErrorCode;
import lotto.infrastructure.generator.LottoNumberGenerator;
import lotto.infrastructure.generator.NumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public void getLottoNumbers_숫자갯수() {
        assertThat(lottoTicket.getReadOnlyLottoNumbers().size()).isEqualTo(6);
    }

    @Test
    public void getLottoNumbers_정렬() {
        List<Integer> lottoNumbers = lottoTicket.getReadOnlyLottoNumbers();

        for (int i = 0; i < lottoNumbers.size() - 1; i++) {
            assertThat(lottoNumbers.get(i) < lottoNumbers.get(i + 1)).isTrue();
        }
    }

    @Test
    public void getLottoNumbers_중복검사() {
        List<Integer> lottoNumbers = lottoTicket.getReadOnlyLottoNumbers();
        Set<Integer> nonDuplicatedInteger = new HashSet<>(lottoNumbers);

        assertThat(lottoNumbers.size()).isEqualTo(nonDuplicatedInteger.size());
    }

    @Test
    public void contains_true() {
        List<Integer> lottoNumbers = lottoTicket.getReadOnlyLottoNumbers();

        for (Integer lottoNumber : lottoNumbers) {
            assertThat(lottoTicket.contains(lottoNumber)).isTrue();
        }
    }

    @Test
    public void contains_false() {
        List<Integer> lottoTotalNumbers = lottoNumberGenerator.generate();
        List<Integer> lottoNumbers = lottoTicket.getReadOnlyLottoNumbers();

        for (Integer lottoNumber : lottoNumbers) {
            lottoTotalNumbers.remove(lottoNumber);
        }

        for (Integer integer : lottoTotalNumbers) {
            assertThat(lottoTicket.contains(integer)).isFalse();
        }
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void lottoNumbers_주입_null_or_empty(List<Integer> lottoNumbers) {
        assertThatThrownBy(() -> new LottoTicket(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoTicketErrorCode.NOT_ALLOW_NULL_OR_EMPTY.getMessage());
    }

    @Test
    public void lottoNumbers_주입_size() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> new LottoTicket(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(LottoTicketErrorCode.INVALID_LOTTO_NUMBER_SIZE.getMessage(), LottoTicket.LOTTO_SIZE));
    }

    @Test
    public void lottoNumbers_주입_중복검사() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> new LottoTicket(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoTicketErrorCode.NOT_ALLOW_DUPLICATE.getMessage());
    }

    @Test
    public void lottoNumbers_주입_로또숫자() {
        List<Integer> lottoNumbers = Arrays.asList(100, 200, 300, 400, 500, 600);

        assertThatThrownBy(() -> new LottoTicket(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        String.format(
                                LottoTicketErrorCode.INVALID_LOTTO_NUMBER.getMessage(),
                                LottoTicket.LOTTO_MIN_NUMBER,
                                LottoTicket.LOTTO_MAX_NUMBER)
                );
    }
}