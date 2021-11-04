package view;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사용자 입력")
class UserInputSystemTest {

	@Test
	@DisplayName("객체화")
	void instance() {
		assertThatNoException()
			.isThrownBy(() -> UserInputSystem.from(mock(GuidePrinter.class), mock(Scanner.class)));
	}

	@Test
	@DisplayName("안내 프린터 없이 객체화하면 IllegalArgumentException")
	void instance_nullGuidePrinter_illegalArgumentExceptionThrown() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> UserInputSystem.from(null, mock(Scanner.class)))
			.withMessage("'guidePrinter' must not be null");
	}

	@Test
	@DisplayName("스캐너 없이 객체화하면 IllegalArgumentException")
	void instance_nullScanner_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> UserInputSystem.from(mock(GuidePrinter.class), null))
			.withMessage("'scanner' must not be null");
	}

	@Test
	@DisplayName("입력 제공")
	void input() {
		//given
		Scanner mockScanner = mock(Scanner.class);
		GuidePrinter mockPrinter = mock(GuidePrinter.class);

		String anyString = "anyString";
		when(mockScanner.nextLine())
			.thenReturn(anyString);

		//when
		String input = UserInputSystem.from(mockPrinter, mockScanner).input();

		//then
		assertAll(() -> {
			assertThat(input)
				.isEqualTo(anyString);
			verify(mockPrinter, only()).print();
		});
	}
}
