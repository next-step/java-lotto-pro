# 2단계 - 문자열 덧셈 계산기

## 기능 요구 사항 확인 및 정리

- 기본구분자는 `,`,`:` 이다.
- 커스텀 구분자는 문자열의 앞부분 `//`와`\n`의 사이에 위치하는 문자다.
- 구분자로 구분된 숫자를 모두 합산한다.
- 숫자 이외의 값 또는 음수는 RuntimeException 예외를 발생해야함
- 결과 example :
    - `"''"=> 0` | `"1,2" => 3`, | `"1,2,3" => 6` , `"1,2:3" => 6`
    - `"//;\n1;2;3"` => `6`

## 기능 명세

- [X] null 을 입력 받을 경우 0을 리턴한다.
- [X] 숫자하나를 입력 할 경우 숫자 합은 입력 숫자 그대로 이다.
- [X] 기본 구분자로 분리된 숫자목록을 검증 테스트 한다.
- [X] `,`, `:` 구분자로된 입력값을 합산한다.
- [X] 구분된 숫자를 합산 후 검증 테스트 한다.
- [X] `,`,`:` 구분자가 혼용될 경우 테스트 해본다.
- [X] 커스텀 구분자 추출 기능 구현
- [X] 커스텀 구분자의 구분자 추출 검증 테스트한다.
- [X] 커스텀 구분자로 분리된 숫자를 검증 테스트 한다.
- [X] 문자 or 음수 RuntimeException 구현

---
---

### 지켜야 할 컨벤션

> 커밋전 항상 아래 내용을 상기 시키며 커밋하도록 노력!

#### 코드 컨벤션

> 1. 프로그램 요구사항 미반영 검토하기 -> 모든 사항을 지킬 수 있도록 꼼꼼하게 프로그래밍하자!
> 2. RuntimeException 보다는 Exception 을 구체화 시켜 예외상황을 명확하게 정의하자.
> 3. 이름을 통해 의도를 드러내라. (불용어(Info, Data, a, an, the)를 추가하는 방식은 적절하지 못하다.)
> 4. 축약하지 마라. (의미를 들어낼 수 있다면 이름은 길어져도 괜찮다)
> 5. 개발 도구의 code format 기능을 활용
> 6. space(공백)도 convention 이다.
> 7. 불필요하게 공백 라인을 만들지 않는다.
> 8. 구현 순서도 convention 이다.
> 9. 반복하지 마라.
> 10. 들여쓰기에 space 와 tab 을 혼용하지 않는다.
> 11. 의미없는 주석을 달지 않는다. (주석보다는 의미있는 이름을 작성하도록 노력하자!)
> 12. 값을 하드코딩 하지 마라.(java 상수 개념)
      > -> 상수이름은 대문자로 정의한다.
> 13. git commit 메시지를 의미있게 작성
> 14. 기능 목록 업데이트 (한번에 완벽하게 작성 보다는, 계속 된 업데이트를 통해 살아있는 문서를 만들도록 노력한다.)
> 15. 기능 목록 구현을 재검토한다. (너무 상새하게 작성하지 않는다. 기능 정리 정도까지. 예외상황도 기능목록에 정리한다.)
> 16. README.md를 상세히 작성. (README 를 통해 어떤 프로젝트이며, 어떤 기능을 담고 있는지 기술한다.)

#### 테스트 코드

> 1. 가독성을 높이자
> 2. 테스트 당 assert 하나
> 3. 테스트 당 개념 하나
> 4. 빠르게 / 독립적으로 / 반복가능하게 / 자가검증하는 / 적시에
> 5. 테스트 비교 값은 Boolean 또는 명확성을 뛸수 있도록 노력하기
> 6. given-when-then