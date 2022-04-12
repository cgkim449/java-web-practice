package spms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class DBConnectionPool {
	String url;
	String username;
	String password;
	ArrayList<Connection> connList = new ArrayList<>();
	
	public DBConnectionPool(String driver, String url, String username, String password) throws Exception {
		this.url = url;
		this.username = username;
		this.password = password;
		
		Class.forName(driver);
	}
	
	public Connection getConnection() throws Exception {
		if(connList.size() > 0) {
			Connection conn = connList.get(0);
			if(conn.isValid(10)) { // 커넥션은 일정 시간이 지나면 DB 서버와의 연결이 끊어지기 때문에 유효성 체크를 합니다.
				return conn;
			}
		}
		return DriverManager.getConnection(url, username, password);
	}
	
	public void returnConnection(Connection conn) throws Exception {
		connList.add(conn);
	}
	
	public void closeAll() { 
		// 웹 앱을 종료하기 전에 이 메서드를 호출하여 DB 서버와 연결된 것을 모두 끊어야합니다.
		// 물론 일정시간이 지나면 끊어지나,
		// DB는 여러 웹 앱에서 공동으로 사용하는 자원이기 때문에 바로바로 해제하는 것이 좋습니다.
		for(Connection conn: connList) {
			try {
				conn.close();
			} catch(Exception e) {}
		}
	}
}
