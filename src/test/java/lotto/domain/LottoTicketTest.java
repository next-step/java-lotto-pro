package lotto.domain;

import lotto.module.AutoGenerator;
import lotto.module.NumberGeneratorStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    private static Stream<Arguments> autoStrategyGenerate() {
        NumberGeneratorStrategy strategy = AutoGenerator.getInstance();
        return Stream.of(
                Arguments.of(1, strategy),
                Arguments.of(5, strategy)
        );
    }

    @ParameterizedTest
    @MethodSource("autoStrategyGenerate")
    @DisplayName("로또 번호 자동생성")
    public void autoGenerateTest(int boughtLotto, NumberGeneratorStrategy strategy) {
        LottoTicket ticket = LottoTicket.generate(boughtLotto, strategy);

        assertThat(ticket.getTicket().size()).isEqualTo(boughtLotto);
    }

}