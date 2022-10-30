package utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class InputHandlerTest {

	InputHandler inputHandler;

	@Test
	void 잘못된_입력_후_정상값_입력() {
		inputInBufferStream("Not a number", "1");
		int inputResult = inputHandler.inputPositiveInteger("TEST PROMPT");

		assertThat(inputResult).isEqualTo(1);
	}

	@Test
	void 음수_입력시_오류() {
		inputInBufferStream("-1", "2");
		int inputResult = inputHandler.inputPositiveInteger("TEST PROMPT");
		assertThat(inputResult).isEqualTo(2);
	}

	private void inputInBufferStream(String... commands) {
		byte[] buffer = String.join("\n", commands).getBytes();
		inputHandler = new InputHandler(new Scanner(new ByteArrayInputStream(buffer)));
	}
}
