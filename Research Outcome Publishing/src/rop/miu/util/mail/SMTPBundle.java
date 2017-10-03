package rop.miu.util.mail;

public class SMTPBundle {
	private String user;
	private String password;
	private String host;
	private String socketPort;
	private String socketClass;
	private String auth;
	private String port;
	private String starttls;
	
	public SMTPBundle() {
		starttls = "true";
	}

	public SMTPBundle(String user, String password, String host,
			String socketPort, String socketClass, String auth, String port,
			String starttls) {
		super();
		this.user = user;
		this.password = password;
		this.host = host;
		this.socketPort = socketPort;
		this.socketClass = socketClass;
		this.auth = auth;
		this.port = port;
		this.starttls = starttls;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getSocketPort() {
		return socketPort;
	}

	public void setSocketPort(String socketPort) {
		this.socketPort = socketPort;
	}

	public String getSocketClass() {
		return socketClass;
	}

	public void setSocketClass(String socketClass) {
		this.socketClass = socketClass;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getStarttls() {
		return starttls;
	}

	public void setStarttls(String starttls) {
		this.starttls = starttls;
	}
}
