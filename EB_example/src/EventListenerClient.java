import java.io.Serializable;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

// EventListener를 구현하는 클라이언트 클래스
// 이벤트를 수신하고 처리하는 클라이언트 클래스
public class EventListenerClient implements EventListener, Serializable {
  private static final long serialVersionUID = 1L; // 직렬화 버전 UID
  private String name; // 리스너의 이름을 저장하는 속성

  public EventListenerClient(String name) {
    this.name = name;
  }

  @Override
  public void onEvent(String event) {
    System.out.println(name + "가 이벤트를 수신했습니다: " + event); // 이벤트 수신 메시지 출력
  }

  public static void main(String[] args) {
    try {
      // RMI 레지스트리에서 이벤트 버스 객체 찾기
      Registry registry = LocateRegistry.getRegistry("localhost", 1099);
      EventBus eventBus = (EventBus) registry.lookup("EventBus");

      // 이벤트 리스너 클라이언트 생성 및 서버에 구독
      EventListenerClient listener = new EventListenerClient("리스너1");
      eventBus.subscribe(listener);

      // 이벤트를 발행하는 예시
      eventBus.publish("Hello, 이벤트!"); // 이벤트 발행
    } catch (Exception e) {
      System.err.println("클라이언트 예외: " + e.toString());
      e.printStackTrace();
    }
  }
}
