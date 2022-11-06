package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberGeneratorTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        outputStreamCaptor.reset();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6"})
    void 번호_수동_생성(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        new Scanner(System.in);
        Lotto lotto = new LottoNumberGenerator().manualGenerateNumbers();
        assertThat(lotto.contains(LottoNumber.from(1))).isTrue();
        assertThat(lotto.contains(LottoNumber.from(2))).isTrue();
        assertThat(lotto.contains(LottoNumber.from(3))).isTrue();
        assertThat(lotto.contains(LottoNumber.from(4))).isTrue();
        assertThat(lotto.contains(LottoNumber.from(5))).isTrue();
        assertThat(lotto.contains(LottoNumber.from(6))).isTrue();
    }
}
