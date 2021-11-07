package lotto.component;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import lotto.infrastructure.component.TextEdit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TextEditTest {
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

  @DisplayName("입력을 가이드하는 문구가 출력된다.")
  @Test
  void render_printText() {
    // given
    System.setIn(new ByteArrayInputStream("1\n".getBytes()));
    TextEdit textEdit = new TextEdit("값을 입력해주세요.");

    // when
    textEdit.render();

    // then
    assertThat(outContent.toString().trim()).contains("값을 입력해주세요.");
  }

  @DisplayName("사용자가 입력시 해당 값이 변수에 저장된다.")
  @Test
  void input_value() {
    // given
    System.setIn(new ByteArrayInputStream("1234\n".getBytes()));
    TextEdit textEdit = new TextEdit("값을 입력해주세요.");

    // when
    textEdit.render();

    // then
    assertThat(textEdit.getValue()).isEqualTo("1234");
  }
}
