import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@DisplayName("split 학습테스트")
	@Test
	void split(){
		String str="1,2";
		String[] splitedStr=str.split(",");
		assertThat(splitedStr).contains("2","1");
		assertThat(splitedStr).containsExactly("1","2");
	}

	@DisplayName("split 대상 문자열이 delimiter를 포함하지 않은 경우, 대상 문자열이 반환 배열 0번째 index에 그대로 저장")
	@Test
	void splitNotIncludeDelimiter(){
		String str="1";
		String[] splitedStr=str.split(",");
		assertThat(splitedStr).contains("1");
		assertThat(splitedStr).containsExactly("1");
	}

	@DisplayName("substring 학습테스트")
	@Test
	void substring(){
		String str="(1,2)";
		String subStr=str.substring(1,4);
		assertThat(subStr).isEqualTo("1,2");
	}

	@DisplayName("charAt 학습테스트")
	@Test
	void charAt(){
		String str="abc";
		assertThat(str.charAt(0)).isEqualTo('a');
		assertThat(str.charAt(1)).isEqualTo('b');
		assertThat(str.charAt(2)).isEqualTo('c');
	}

	@DisplayName("범위를 벗어나는 index를 charAt의 인자로 호출할때 예외")
	@Test
	void charAtOutOfBoundIndex(){
		String str="abc";
		assertThatThrownBy(()->{
			System.out.println(str.charAt(3));
		}).isInstanceOf(IndexOutOfBoundsException.class);
	}
}
