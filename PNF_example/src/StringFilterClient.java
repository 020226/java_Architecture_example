import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StringFilterClient {
  public static void main(String[] args) {
    try {
      Registry registry = LocateRegistry.getRegistry("localhost", 1099);
      StringFilter stub = (StringFilter) registry.lookup("StringFilter");

      String input = "hello, rmi!";
      String response = stub.filter(input); // 서버의 filter 메서드 호출

      System.out.println("서버 응답: " + response); // 변환된 문자열 출력
    } catch (Exception e) {
      System.out.println("클라이언트 예외: " + e.toString());
      e.printStackTrace(); // 해당 예외의 스택 트레이스를 출력
    }
  }
}
