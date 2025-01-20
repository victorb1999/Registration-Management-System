
public class Guest {
	private String lastName;
	private String firstName;
	private String email;
	private String phoneNumber;

	public Guest(String lastName, String firstName, String email, String phoneNumber) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.lastName == null) ? 0 : this.lastName.hashCode());
		result = prime * result + ((this.firstName == null) ? 0 : this.firstName.hashCode());
		result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
		result = prime * result + ((this.phoneNumber == null) ? 0 : this.phoneNumber.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (this.getClass() != obj.getClass()) {
			return false;
		}

		Guest other = (Guest) obj;

		if (this.lastName.equals(other.lastName) && this.firstName.equals(other.firstName)
				|| this.email.equals(other.email) || this.phoneNumber.equals(other.phoneNumber)) {
			return true;
		}

		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nume: ");
		sb.append(fullName());
		sb.append(", Email: ");
		sb.append(this.email + ", Telefon: ");
		sb.append(this.phoneNumber);

		return sb.toString();
	}

	public String fullName() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.lastName);
		sb.append(" ");
		sb.append(this.firstName);
		return sb.toString();
	}
}
