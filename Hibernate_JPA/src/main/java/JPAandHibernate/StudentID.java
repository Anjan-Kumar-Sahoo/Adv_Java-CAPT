package JPAandHibernate;

import jakarta.persistence.Embeddable;

@Embeddable
public class StudentID {
	private long phone;
	private String email;
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public StudentID(long phone, String email) {
		super();
		this.phone = phone;
		this.email = email;
	}
	
	public StudentID()
	{
		
	}
}
