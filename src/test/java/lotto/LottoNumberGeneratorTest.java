package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

    @Test
    void 번호_자동_생성() {
        assertThat(new LottoNumberGenerator().autoGenerateNumbers().size()).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6"})
    void 번호_수동_생성(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        new Scanner(System.in);
        List<Integer> lottoNumbers = new LottoNumberGenerator().manualGenerateNumbers();
        assertThat(lottoNumbers.get(0)).isEqualTo(1);
        assertThat(lottoNumbers.get(1)).isEqualTo(2);
        assertThat(lottoNumbers.get(2)).isEqualTo(3);
        assertThat(lottoNumbers.get(3)).isEqualTo(4);
        assertThat(lottoNumbers.get(4)).isEqualTo(5);
        assertThat(lottoNumbers.get(5)).isEqualTo(6);
    }
}
