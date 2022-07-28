package member;

import java.sql.Timestamp;

public class MemberDto {

	public MemberDto() {
	      
	   }
	   
	   public MemberDto(String name, String nick, String gender, String id, String pwd, String phone, String bank, String account) {
		      
		   this.name = name;
		   this.nick = nick;
		   this.gender = gender;
		   this.id = id;
		   this.pwd = pwd;
		   this.phone = phone;
		   this.bank = bank;
		   this.account = account;
	   }
	
	   private String name;
	   private String nick;
	   private String gender;
	   private String id;
	   private String pwd;
	   private String phone;
	   private String bank;
	   private String account;
	   
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
	
		public String getGender() {
			return gender;
		}
	
		public void setGender(String gender) {
			this.gender = gender;
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

		@Override
		public String toString() {
			return "MemberDto [name=" + name + ", nick=" + nick + ", gender=" + gender + ", id=" + id + ", pwd=" + pwd
					+ ", phone=" + phone + ", bank=" + bank + ", account=" + account + "]";
		}
		
		
		
}
