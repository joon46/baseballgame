🎰 Grand Theft Vault (숫자야구 변형 게임)이클립스(Eclipse) 환경에서 Java GUI로 구현한 3자리 숫자야구 변형 게임 프로젝트입니다.   

📌 프로젝트 소개 <br>
Grand Theft Vault는 자바 Swing/AWT 기반으로 제작된 게임 프로젝트로, 정해진 기회 안에 3자리 비밀번호를 맞추어 금고를 터는 게임입니다.   

- 개발 환경: Java (JDK), Eclipse IDE
- 주요 기술: Java AWT / Swing (GUI 구성 및 이벤트 처리)
- 핵심 기능: 랜덤 정답 생성, 입력값 판별 로직(Correct/Miss), 프레임 전환 및 결과 출력

📁 프로젝트 구조 (Directory Structure)

└── src/ <br>
    └── baseball/                  # 통합 및 개선된 자바 소스 코드 패키지[cite: 2, 3, 4, 5, 6, 7] <br>
        ├── BaseMain.java          # 메인 실행 클래스 <br>
        ├── BaseFrame.java         # 기본 UI 프레임 설정 <br>
        ├── StartFrame.java        # 시작 화면 GUI <br>
        ├── Start_ButtonLisner.java # 시작/룰 설명 화면 이벤트 리스너 <br>
        ├── Cpu.java               # 난수 생성 및 컴퓨터 정답 처리 <br>
        └── Player.java            # 플레이어 입력 처리 및 정답 판별 로직 <br>

🛠️ 주요 클래스별 역할
- BaseMain.java (메인 실행 클래스): 프로그램의 시작점(main 메서드)으로 StartFrame을 호출하여 게임을 실행합니다.   
- BaseFrame.java (기본 UI 프레임): GUI 창의 공통 크기, 배경색, 레이아웃 등 기본 틀을 정의하는 클래스입니다.
- StartFrame.java (시작 화면 UI): 메인 배경 이미지, 시작 버튼, 종료 버튼 등을 배치하는 시작 화면입니다.
- Start_ButtonLisner.java (이벤트 리스너): 시작 버튼 클릭 시 시작 창을 숨기고 룰 설명 창으로 전환하는 이벤트를 처리합니다.
- Cpu.java (정답 생성): Random 클래스를 활용하여 플레이어가 맞춰야 할 3자리 난수를 생성합니다.
- Player.java (게임 로직 및 비교): 플레이어 입력값을 전달받아 컴퓨터 정답과 비교하여 Correct(Strike) / Miss(Ball) / Out을 판별합니다[cite: 3].
    
    
🎮 게임 룰 (Rules)

3자리 비밀번호 추론: 컴퓨터가 지정한 중복 가능한 3자리 숫자를 맞춥니다.   
Correct & Miss:Correct: 숫자와 위치가 모두 맞은 경우   
Miss: 숫자는 맞지만 위치가 틀린 경우   
    기회 제한: 총 10번의 기회가 주어지며, 시도할 때마다 Life(하트)가 감소합니다[cite: 1].
