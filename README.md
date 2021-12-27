# kotlin-minesweeper

## 1단계 - 지뢰 찾기 (그리기)

### 기능 요구사항
지뢰 찾기를 변형한 프로그램을 구현한다.
- 높이와 너비, 지뢰 개수를 입력받을 수 있다.
- **지뢰는 눈에 잘 띄는 것으로 표기한다.**
- **지뢰는 가급적 랜덤에 가깝게 배치한다.**

### 실행 결과
```
높이를 입력하세요.
10

너비를 입력하세요.
10

지뢰는 몇 개인가요?
10

지뢰찾기 게임 시작
C C C * C C C * C C
C C * C * C C C C C
C C C C C C C C C C
C C C C C C C C C C
* C C C C C C C C C
C C C C C C * C C C
C C * C C C * C C C
C C C C C C * C C *
C C C C C C C C C C
C C C C C C C C C C
```

### 프로그래밍 요구 사항

- 객체지향 생활 체조 원칙을 지키면서 프로그래밍한다.

객체지향 생활 체조 원칙
1. 한 메서드에 오직 한 단계의 들여쓰기만 한다.
2. else 예약어를 쓰지 않는다.
3. 모든 원시 값과 문자열을 포장한다.
4. 한 줄에 점을 하나만 찍는다.
5. 줄여 쓰지 않는다(축약 금지).
6. 모든 엔티티를 작게 유지한다.
7. 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
8. 일급 컬렉션을 쓴다.
9. getter/setter/프로퍼티를 쓰지 않는다.

### 구현 목록
- [X] 높이, 너비, 지뢰 개수 입력 받아 게임 보드 생성
- [X] 랜덤하게 지뢰 위치 설정
- [X] 게임 보드에 지뢰 및 블록 셋팅
- [X] 게임 보드 그리기

---

## 2단계 - 지뢰 찾기 (지뢰 개수)

### 기능 요구사항
지뢰 찾기를 변형한 프로그램을 구현한다.
- 높이와 너비, 지뢰 개수를 입력받을 수 있다.
- 지뢰는 눈에 잘 띄는 것으로 표기한다.
- 지뢰는 가급적 랜덤에 가깝게 배치한다.
- **각 사각형에 표시될 숫자는 자신을 제외한 주변 8개 사각형에 포함된 지뢰의 개수다.**

### 실행 결과
```
높이를 입력하세요.
10

너비를 입력하세요.
10

지뢰는 몇 개인가요?
10

지뢰찾기 게임 시작
0 1 2 * 2 1 1 * 1 0
0 1 * 3 * 1 1 1 1 0
0 1 1 2 1 1 0 0 0 0
1 1 0 0 0 0 0 0 0 0
* 1 0 0 0 1 1 1 0 0
1 2 1 1 0 2 * 2 0 0
0 1 * 1 0 3 * 3 1 1
0 1 1 1 0 2 * 2 1 *
0 0 0 0 0 1 1 1 1 1
0 0 0 0 0 0 0 0 0 0
```

### 프로그래밍 요구 사항
- 객체 지향 5원칙을 지키면서 프로그래밍한다.

객체지향 5원칙(SOLID)
- SRP (단일책임의 원칙: Single Responsibility Principle): 작성된 클래스는 하나의 기능만 가지며 클래스가 제공하는 모든 서비스는 그 하나의 책임(변화의 축: axis of change)을 수행하는 데 집중되어 있어야 한다
- OCP (개방폐쇄의 원칙: Open Close Principle): 소프트웨어의 구성요소(컴포넌트, 클래스, 모듈, 함수)는 확장에는 열려있고, 변경에는 닫혀있어야 한다.
- LSP (리스코브 치환의 원칙: The Liskov Substitution Principle): 서브 타입은 언제나 기반 타입으로 교체할 수 있어야 한다. 즉, 서브 타입은 언제나 기반 타입과 호환될 수 있어야 한다.
- ISP (인터페이스 분리의 원칙: Interface Segregation Principle): 한 클래스는 자신이 사용하지 않는 인터페이스는 구현하지 말아야 한다.
- DIP (의존성역전의 원칙: Dependency Inversion Principle): 구조적 디자인에서 발생하던 하위 레벨 모듈의 변경이 상위 레벨 모듈의 변경을 요구하는 위계관계를 끊는 의미의 역전 원칙이다.

### 구현 목록
- [X] 각 셀 주변의 지뢰 개수 구하기
- [X] 지뢰 개수 및 지뢰 그리기