# STEP1
## String 클래스에 대한 학습 테스트
- [x] "1,2"를 ,로 split 한다.
  - [x] 1과 2로 분리된다. 
  - [x] assertj contains()로 검증한다.
  - [x] assertj containsExactly()로 검증한다.
- [x] "1"을 ,로 split 한다.
  - [x] 1만을 포함하는 배열이 반환된다.
  - [x] assertj contains()로  검증한다
  - [x] assertj containsExactly()로 검증한다.
- [x] "(1,2)"의 ()를 제거한다.
  - [x] "1,2"를 반환한다.
- [x] 특정 위치의 문자를 가져온다. 
  - [x] charAt() 메소드를 활용한다.
  - [x] 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다. 
- [x] @DisplayName 활용해 테스트 메소드의 의도를 드러낸다.
