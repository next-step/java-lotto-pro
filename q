[33mcommit 3ac570cc1f4895e751cc68c726c2c19a5b786eb6[m[33m ([m[1;36mHEAD -> [m[1;32mstep3[m[33m)[m
Author: Jeongkyo Kim <chavitak@gmail.com>
Date:   Sat Nov 6 11:36:14 2021 +0900

    feat: 구입금액에 따른 구매개수를 출력한다, 구매개수에 따른 자동 로또번호를 출력한다
    
    - 구입금액에 따른 구매개수를 출력한다
    - 구매개수에 따른 자동 로또번호를 출력한다

[33mcommit 0b5ab2ea078de41ad8860d6e29a282e202bc98d2[m
Author: Jeongkyo Kim <chavitak@gmail.com>
Date:   Sat Nov 6 00:55:53 2021 +0900

    docs: 구입금액이 음수일경우에 대한 표현을 수정한다

[33mcommit 11dd78c56fd302eacfb018e79b7e0e9bb82866c2[m
Author: Jeongkyo Kim <chavitak@gmail.com>
Date:   Sat Nov 6 00:54:47 2021 +0900

    feat: 구입금액이 음수이면 예외를 출력한다

[33mcommit dc8aa02aa2763ff6cf7f85d91e5bbd4eed90530e[m
Author: Jeongkyo Kim <chavitak@gmail.com>
Date:   Fri Nov 5 23:00:45 2021 +0900

    docs: 3단계 - 로또(자동) 요구사항 작성

[33mcommit 9d307c3058b535b2de0b4027fe4eb5343d3285d8[m[33m ([m[1;31mupstream/chapitak[m[33m, [m[1;32mchapitak[m[33m)[m
Author: Jeongkyo Kim <43088225+chapitak@users.noreply.github.com>
Date:   Thu Nov 4 09:47:42 2021 +0900

    2단계 - 문자열 덧셈 계산기 (#105)
    
    * docs: 문자열 덧셈 계산기에 대한 요구사항을 추가한다
    
    * test: StringAddCalculatorTest 추가
    
    * feat: 빈 문자열 또는 null 값을 입력할 경우 0을 반환한다
    
    - calculator 패키지를 만들고 StringAddCalculator 클래스를 생성한다
    - splitAndSum_null_또는_빈문자 테스트를 통과할 수 있도록 splitAndSum() 메서드를 생성한다
    
    * feat:  숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.
    
    - splitAndSum_쉼표구분자() 테스트를 통과할 수 있도록 splitAndSum() 메서드를 수정한다
    
    * file: empty.txt 파일을 삭제한다
    
    * feat: 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을반환한다
    
    * refactor: 구분자가 없는 경우에 대한 예외처리를 삭제한다
    
    - 구분자가 없는 경우에 대한 예외처리는 split()을 활용해 구현할 수 있기에  더 이상 불필요하므로 삭제한다
    
    * feat:  구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.
    
    - split() 메서드의 구분자로 콜론을 추가한다
    
    * feat: “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다.
    
    * feat: 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
    
    * refactor: 각 메서드가 한 가지 역할만 수행하도록 리팩토링한다.
    
    * feat: 간단한 테스트를 위한 콘솔 입출력을 구현한다
    
    * docs: 요구사항의 표시형태를  리스트에서 체크박스로 변경한다
    
    * refactor: 매직넘버를 상수로 추출한다
    
    * refactor: RuntimeException을 IllegalArgumentException으로 대체한다
    
    - RuntimeException을  더 명확한 예외인 IllegalArgumentException으로 대체한다
    
    * Test: DisplayName 애노테이션을 사용하여 테스트의 용도를 명확히 한다
    
    * refactor: 매번 초기화가 필요했던 Pattern 객체를 클래스 필드에 캐싱한다

[33mcommit b837ee87055cde271b5f7a29102602e7f86535ff[m
Author: Jeongkyo Kim <43088225+chapitak@users.noreply.github.com>
Date:   Tue Nov 2 09:44:49 2021 +0900

    test: 학습 테스트를 작성한다 (#39)
    
    - 학습 테스트인 StringTest, SetTest를 작성한다

[33mcommit d6a57434bd336594b0fac327e12e826a52593828[m[33m ([m[1;31morigin/chapitak[m[33m)[m
Author: javajigi <javajigi@gmail.com>
Date:   Mon Nov 1 07:50:49 2021 +0900

    initial commit
