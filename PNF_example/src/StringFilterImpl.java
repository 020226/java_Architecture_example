import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

// 필터 서버 구현
// StringFilter 인터페이스 구현
public class StringFilterImpl extends UnicastRemoteObject implements StringFilter {
  protected StringFilterImpl() throws RemoteException {
    super();
  }

  @Override
  public String filter(String input) throws RemoteException {
    return input.toUpperCase(); // 입력된 문자열을 대문자로 변환
  }

  // 서버를 시작하고 RMI 레지스트리에 바인딩하는 메인 메서드
  public static void main(String[] args) {
    try {
      StringFilterImpl obj = new StringFilterImpl(); // 필터 객체 생성
      Registry registry = LocateRegistry.createRegistry(1099); // RMI 레지스트리 생성(포트 1099)
      registry.bind("StringFilter", obj); // "StringFilter" 라는 이름으로 객체를 바인딩
      System.out.println("필터 서버가 시작되었습니다."); // 서버 시작 메시지 출력
    } catch (Exception e) {
      System.out.println("서버 예외: " + e.toString()); // 예외 처리
      e.printStackTrace();
    }
  }
}
