package member;

import java.sql.Timestamp;

public class MemberDto {
	
	public MemberDto() {
	}

	public MemberDto(String id, String pwd, String nick, Timestamp enroll_date, char quit_yn) {
		this.id = id;
		this.pwd = pwd;
		this.nick = nick;
		this.enroll_date = enroll_date;
		this.quit_yn = quit_yn;
	}
	
	private String id;
	private String pwd;
	private String nick;
	private Timestamp enroll_date;
	private char quit_yn;
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

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Timestamp getEnroll_date() {
		return enroll_date;
	}

	public void setEnroll_date(Timestamp enroll_date) {
		this.enroll_date = enroll_date;
	}

	public char getQuit_yn() {
		return quit_yn;
	}

	public void setQuit_yn(char quit_yn) {
		this.quit_yn = quit_yn;
	}


	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pwd=" + pwd + ", nick=" + nick + ", enroll_date=" + enroll_date + ", quit_yn="
				+ quit_yn + "]";
	}


}

