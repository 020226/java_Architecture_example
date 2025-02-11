import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StringFilter extends Remote {
  String filter(String input) throws RemoteException; // 문자열을 필터링하는 메서드
}
