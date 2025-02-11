import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

// 원격 인터페이스를 구현하는 클래스
public class HelloImpl extends UnicastRemoteObject implements Hello {

  // 생성자
  protected HelloImpl() throws RemoteException {
    super(); // 부모 클래스의 생성자 호출
  }

  // 원격 메서드 구현
  @Override
  public String sayHello() throws RemoteException {
    return "안녕하세요. RMI!"; // 클라이언트에 반환할 메시지
  }

  // 서버를 시작하는 메인 메서드
  public static void main(String[] args) {
    try {
      HelloImpl obj = new HelloImpl(); // HelloImpl 객체 생성
      Registry registry = LocateRegistry.createRegistry(1099); // RMI 레지스트리 생성 (포트 1099)
      registry.bind("Hello", obj); // "Hello"라는 이름으로 객체를 바인딩
      System.out.println("서버가 시작되었습니다."); // 서버 시작 메시지 출력
    } catch (Exception e) {
      System.out.println("서버 예외: " + e.toString()); // 예외 처리
      e.printStackTrace();
    }
  }
}
