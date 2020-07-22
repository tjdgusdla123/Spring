import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String [] args) {
		
		try {
			//포트번호 설정
			//1024 번 아래 8080, 1521, 3306은 제외하고 설정
			int portNumber = 15100;
			System.out.println("서버 실행 중....");
			//서버 소켓 생성 - 접속 준비
			ServerSocket ss = new ServerSocket(portNumber);
			while(true) {
				System.out.println(portNumber);
				//클라이언트의 접속 대기
				//여기서 블럭 되어 있다가
				//클라이언트가 접속하면 클라이언트와
				//통신할 수 있는 소켓을 리턴하고 아래
				//문장을 수행 
				Socket socket = ss.accept();
				//클라이언트 정보 출력
				System.out.println(socket.getInetAddress() + ":" + socket.getLocalPort());
				//클라이언트와 문자 통신을 위한 스트림 생성
				//BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				//객체를 읽어오는 Stream생성
			    ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			    //하나의 객체읽어오기
			   Object obj = ois.readObject();
			   System.out.println(obj);
			   			   				
				//한 줄 읽어오기
				//String msg = br.readLine();
				//System.out.println(msg);			   
			  ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				
			  //한 줄 메시지 전송- 버퍼에 기록
			 switch(obj.toString()) {
			 case "1":
				 oos.writeObject("일번");
				 break;
			 case "2":
				 oos.writeObject("이번");
				 break;
			 case "3":
				 oos.writeObject("삼번");
				 break;
			default:
				 oos.writeObject("기타");
				 break;
				 
			 }
			  //oos.writeObject("서버가 보내는 메시지");
			 //버퍼의 내용을 비우기 - 전송 
			  oos.flush();			  
				//pw.write("서버가 보내는 메시지");
				//pw.flush();				
				
				//소켓 종료 
				socket.close();
				
			}
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}	
}
