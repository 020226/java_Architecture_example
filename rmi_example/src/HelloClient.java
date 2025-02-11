import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

// RMI 클라이언트 클래스
public class HelloClient {
  public static void main(String[] args) {
    try {
      // RMI 레지스트리에서 서버 객체를 찾기
      Registry registry = LocateRegistry.getRegistry("localhost", 1099); // 로컬호스트의 1099 포트에 연결
      Hello stub = (Hello) registry.lookup("Hello"); // "Hello" 이름으로 바인딩된 객체 찾기
      String response = stub.sayHello(); // 원격 메서드 호출
      System.out.println("서버 응답: "+response); // 서버의 응답 출력
    } catch (Exception e) {
      System.out.println("클라이언트 예외: " + e.toString()); // 예외 처리
      e.printStackTrace();
    }
  }
}
