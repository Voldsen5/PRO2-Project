package ex03;

public class Customer {
	private final String phoneNo;
	private final String mobileNo;
	private final String firstname;
	private final String lastname;

	public Customer(String phoneNo, String mobileNo, String firstname, String lastname) {
		this.phoneNo = phoneNo;
		this.mobileNo = mobileNo;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s %s", phoneNo, mobileNo, firstname, lastname);
	}
}
