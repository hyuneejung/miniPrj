package table;

import java.sql.Timestamp;

public class EcoMemberDto {
	private String id;
	private String pwd;
	private String name;
	private String nick;
	private char gender;
	private String phone;
	private String bank;
	private String account;
	private int point;
	private int addedPoint;
	private Timestamp enrollDate;
	private String rank;
	private char quitYn;
	
	public EcoMemberDto() {
		
	}
	
	public EcoMemberDto(String id, String pwd, String name, String nick, char gender, String phone, String bank,
			String account, int point, int addedPoint, Timestamp enrollDate, String rank, char quitYn) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.nick = nick;
		this.gender = gender;
		this.phone = phone;
		this.bank = bank;
		this.account = account;
		this.point = point;
		this.addedPoint = addedPoint;
		this.enrollDate = enrollDate;
		this.rank = rank;
		this.quitYn = quitYn;
		
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
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getAddedPoint() {
		return addedPoint;
	}
	public void setAddedPoint(int addedPoint) {
		this.addedPoint = addedPoint;
	}
	public Timestamp getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Timestamp enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public char getQuitYn() {
		return quitYn;
	}
	public void setQuitYn(char quitYn) {
		this.quitYn = quitYn;
	}
	
	@Override
	public String toString() {
		return "EcoMember [id=" + id + ", pwd=" + pwd + ", name=" + name + ", nick=" + nick + ", gender=" + gender
				+ ", phone=" + phone + ", bank=" + bank + ", account=" + account + ", point=" + point + ", addedPoint="
				+ addedPoint + ", enrollDate=" + enrollDate + ", rank=" + rank + ", quitYn=" + quitYn + "]";
	}

}
