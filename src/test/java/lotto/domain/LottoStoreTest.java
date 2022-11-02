package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {
    @Test
    @DisplayName("로또_티켓_구매")
    void 로또_티켓_구매() {
        LottoTicket buyTicket = LottoStore.buy(() -> new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Set<LottoNumber> lottoTicket = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        assertThat(buyTicket).isEqualTo(new LottoTicket(lottoTicket));
    }
}
