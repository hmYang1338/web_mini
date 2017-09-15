package dto;

public class UserDTO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	
	public UserDTO() {
		super();
	}
	/** 회원가입 및 회원수정을 위한 생성자 */
	public UserDTO(String id, String pwd, String name, String email) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}
	/** 로그인 검증을 위한 생성자*/
	public UserDTO(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDTO [id=");
		builder.append(id);
		builder.append(", pwd=");
		builder.append(pwd);
		builder.append(", name=");
		builder.append(name);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}
	
}
