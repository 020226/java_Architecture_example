import java.rmi.Remote;
import java.rmi.RemoteException;

// 원격 메서드를 정의하는 인터페이스
public interface Hello extends Remote {
  String sayHello() throws RemoteException; // 원격 메서드 선언
}
