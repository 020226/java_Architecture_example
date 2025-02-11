import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

// 이벤트를 생성하고 이벤트 버스에 발행하는 클래스
public class EventBusImpl extends UnicastRemoteObject implements EventBus {
  private List<EventListener> listeners = new ArrayList<>(); // 리스너 목록

  protected EventBusImpl() throws RemoteException {
    super();
  }

  @Override
  public void subscribe(EventListener listener) throws RemoteException {
    listeners.add(listener); // 리스너를 목록에 추가
    System.out.println("새 리스너가 구독했습니다.");
  }

  @Override
  public void publish(String event) throws RemoteException {
    // 모든 리스너에게 이벤트 전파
    for (EventListener listener : listeners) {
      listener.onEvent(event); // 각 리스너의 onEvent 메서드 호출
    }
    System.out.println("이벤트가 발행되었습니다: " + event);
  }

  public static void main(String[] args) {
    try {
      EventBusImpl eventBus = new EventBusImpl(); // 이벤트 버스 객체 생성
      Registry registry = LocateRegistry.createRegistry(1099); // RMI 레지스트리 생성
      registry.bind("EventBus", eventBus); // "EventBus" 이름으로 객체를 바인딩
      System.out.println("이벤트 버스 서버가 시작되었습니다.");
    } catch (Exception e) {
      System.out.println("서버 예외: " + e.toString());
      e.printStackTrace();
    }
  }

}
