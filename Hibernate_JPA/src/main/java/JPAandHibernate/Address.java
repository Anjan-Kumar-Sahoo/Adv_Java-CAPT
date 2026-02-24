package JPAandHibernate;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
	private String city;
	private String pincode;
	private int houseNumber;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public int getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	public Address(String city, String pincode, int houseNumber) {
		super();
		this.city = city;
		this.pincode = pincode;
		this.houseNumber = houseNumber;
	}
	
	public Address()
	{
		
	}
}
