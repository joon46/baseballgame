🎰 Grand Theft Vault (숫자야구 변형 게임)이클립스(Eclipse) 환경에서 Java GUI로 구현한 3자리 숫자야구 변형 게임 프로젝트입니다.   

📌 프로젝트 소개 <br>
Grand Theft Vault는 자바 Swing/AWT 기반으로 제작된 게임 프로젝트로, 정해진 기회 안에 3자리 비밀번호를 맞추어 금고를 터는 게임입니다.   

- 개발 환경: Java (JDK), Eclipse IDE
- 주요 기술: Java AWT / Swing (GUI 구성 및 이벤트 처리)
- 핵심 기능: 랜덤 정답 생성, 입력값 판별 로직(Correct/Miss), 프레임 전환 및 결과 출력

🎮 게임 룰 (Rules)

3자리 비밀번호 추론: 컴퓨터가 지정한 중복 가능한 3자리 숫자를 맞춥니다.   
Correct & Miss:Correct: 숫자와 위치가 모두 맞은 경우   
Miss: 숫자는 맞지만 위치가 틀린 경우   
기회 제한: 총 10번의 기회가 주어지며, 시도할 때마다 Life(하트)가 감소합니다.

📁 프로젝트 구조 (Directory Structure)

└── src/ <br>
&ensp;    └── baseball/                  # 통합 및 개선된 자바 소스 코드 패키지 <br>
 &emsp;       ├── BaseMain.java          # 메인 실행 클래스 <br>
 &emsp;       ├── BaseFrame.java         # 기본 UI 프레임 설정 <br>
 &emsp;       ├── StartFrame.java        # 시작 화면 GUI <br>
 &emsp;       ├── Start_ButtonLisner.java # 시작/룰 설명 화면 이벤트 리스너 <br>
 &emsp;       ├── Cpu.java               # 난수 생성 및 컴퓨터 정답 처리 <br>
 &emsp;       └── Player.java            # 플레이어 입력 처리 및 정답 판별 로직 <br>
 &ensp;   └── frame/ <br>
 &emsp;       ├── Cpu.java          # 컴퓨터 비밀번호(난수) 생성 및 관리 클래스 <br>
 &emsp;       ├── Btnadapter.java   # 텍스트 입력 자릿수 제한(3자리) 이벤트 리스너 <br>
 &emsp;       ├── Btnadapter2.java  # 정답 비교, 판정(Correct/Miss), 기회 차감 핵심 게임 로직 <br>
 &emsp;       ├── Btnadapter3.java  # 게임 재시작 및 화면 리셋(초기화) 이벤트 리스너 <br>
 &emsp;       ├── Btnadapter4.java  # 3자리 입력 완료 시 자동 제출(클릭) 처리 이벤트 리스너 <br>
 &emsp;       ├── Start.java           # 메인 게임 입력 및 레이아웃 화면
 &emsp;       ├── ScoreLabel.java      # 판정 결과 아이콘 동적 UI
 &emsp;       ├── HeartPoint.java      # 남은 기회(하트) 관리 UI
 &emsp;       ├── Result.java          # 게임 성공 결과 화면
 &emsp;       └── Result2.java         # 게임 실패 결과 화면
 

🏗️ 시스템 구조 및 핵심 구현 사항
1. 프레임 흐름 및 화면 전환 (UI & Frame Control)
공통 프레임 상속 (BaseFrame): java.awt.Frame을 상속받은 BaseFrame을 공통 부모로 삼아 창 크기(500x800), 배경색, Absolute Layout 등 공통 규격을 일관되게 재사용했습니다.

화면 전환 구조 (StartFrame ➔ Start ➔ Result/Result2):

BaseMain 실행 시 StartFrame 초기 화면을 생성합니다.

난이도 선택 시 시작 창을 메모리 해제(dispose())하고 메인 게임 화면(Start)으로 좌표(getLocation())를 이어서 생성합니다.

판정 결과 및 기회 소진 조건에 따라 최종 결과 화면(Result, Result2)으로 연결됩니다.

2. 동적 UI 및 반응형 구성 (frame 모듈)
메인 게임 레이아웃 (Start): 입력창(TextField), 제출/리셋 버튼, 라벨 등의 UI 컴포넌트를 조립하여 배치합니다

실시간 UI 업데이트 (ScoreLabel, HeartPoint):

ScoreLabel: 판정 결과(Correct/Miss) 아이콘 라벨을 화면 상단에 동적으로 생성 및 표시합니다.

HeartPoint: 총 10회의 기회에 맞춰 남은 라이프(하트) 아이콘을 실시간으로 차감·갱신합니다.

3. 비즈니스 로직 및 UX 자동화
정답 생성 (Cpu): 첫 자리 0 입력을 방지한 3자리 난수 비밀번호를 생성합니다.

입력 검증 및 자동 제출 (Btnadapter, Btnadapter4): TextListener로 실시간 글자 수를 확인하여 3자리 입력 시에만 버튼을 활성화하고, 3자리가 채워지는 즉시 자동으로 제출(doClick())되도록 구현했습니다.

정답 판정 및 초기화 (Btnadapter2, Btnadapter3): 플레이어 입력값과 Cpu 정답을 비교하여 판정을 수행하고, 리셋 요청 시 난수 재발급 및 UI 초기화를 진행합니다
    

