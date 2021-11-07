package lotto.presentaion;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.infrastructure.component.TextEdit;
import lotto.presentation.BuyLotto;
import lotto.presentation.Screen;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BuyLottoTest {
  private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private static final PrintStream originalOut = System.out;
  private static final InputStream originalIn = System.in;

  @BeforeEach
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @AfterEach
  public void restoreStreams() {
    System.setOut(originalOut);
    System.setIn(originalIn);
    System.out.println(outContent.toString().trim());
  }

  @DisplayName("로또 구입화면을 테스트")
  @CsvSource({"'14000', '14개를 구매했습니다.'",
              "'13000', '13개를 구매했습니다.'",
              "'1000', '1개를 구매했습니다.'",
              "'1500', '1개를 구매했습니다.'"}
            )
  @ParameterizedTest
  void  print_BuyLotto(String buyPrice, String expectedString) {
    // given
    System.setIn(new ByteArrayInputStream(Strings.join(buyPrice).with("\n").getBytes()));
    TextEdit.scanner = new Scanner(System.in);

    Screen buyLotto = new BuyLotto();

    // when
    buyLotto.render();
    // then
    assertThat(outContent.toString().trim()).contains("구입금액을 입력해 주세요.", expectedString);
  }

}
