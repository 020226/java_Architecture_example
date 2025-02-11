import java.rmi.Remote;
import java.rmi.RemoteException;

// 이벤트를 수신하는 인터페이스입니다.
// 구독자는 이 인터페이스를 구현하여 이벤트를 처리합니다.
public interface EventListener extends Remote {
  // 특정 이벤트가 발생했을 때 호출됨
  void onEvent(String event) throws RemoteException; // 이벤트 수신 메서드
}
