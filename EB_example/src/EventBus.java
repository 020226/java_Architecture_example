import java.rmi.Remote;
import java.rmi.RemoteException;

// 이벤트를 관리하고, 리스너를 구독하고 이벤트를 발행하는 역할을 합니다.
public interface EventBus extends Remote {
  void subscribe(EventListener listener) throws RemoteException; // 리스너 구독
  void publish(String event) throws RemoteException; // 이벤트 발생
}
