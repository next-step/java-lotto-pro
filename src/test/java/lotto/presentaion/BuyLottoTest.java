package lotto.presentaion;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.infrastructure.util.Console;
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

  @DisplayName("구입화면을통해 금액을 입력받는다.")
  @Test
  void  print_BuyLotto() {
    // given
    buyLottoPriceOf("10000");

    Screen buyLotto = new BuyLotto();

    // when
    buyLotto.render();

    // then
    assertThat(outContent.toString().trim()).contains("구입금액을 입력해 주세요.");
  }


  
  @DisplayName("구매 금액 유효성을 검사한다..")
  @ValueSource(strings = {"-100", "Lotto", "@@!", "Price:1000"})
  @ParameterizedTest
  void  invalidCheck_LottoPirce(String iuputLottoPrice) {
    // given
    buyLottoPriceOf(iuputLottoPrice);

    Screen buyLotto = new BuyLotto();

    // when
    Assertions.assertThrows(NoSuchElementException.class, 
      () -> {buyLotto.render();}
    );

    // then
    
    List<String> exptedString = new ArrayList<String>();

    exptedString.add("구입금액을 입력해 주세요.");
    exptedString.add("입력한 구입금액이 유효하지 않습니다.");
    
    assertThat(outContent.toString().trim()).contains(exptedString);
  }
  
  private void buyLottoPriceOf(String price) {
    System.setIn(new ByteArrayInputStream(Strings.join(price).with("\n").getBytes()));
    Console.reLoadScanner();
  }
}
