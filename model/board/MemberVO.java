package model.board;

public class MemberVO {
	private String id;
	private String passwoard;
	private String name;
	private String role;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswoard() {
		return passwoard;
	}
	public void setPasswoard(String passwoard) {
		this.passwoard = passwoard;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", passwoard=" + passwoard + ", name=" + name + ", role=" + role + "]";
	}

}
