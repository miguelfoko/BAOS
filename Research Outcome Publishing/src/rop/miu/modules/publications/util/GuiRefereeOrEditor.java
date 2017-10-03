package rop.miu.modules.publications.util;

import java.io.Serializable;

public class GuiRefereeOrEditor implements Serializable{
	private static final long serialVersionUID = 1L;
	private int refereeId;
	private String name;
	private String institution;
	private String email;
	private String motivation;
	
	public GuiRefereeOrEditor(int refereeId, String name, String institution, String email,
			String motivation) {
		this.refereeId = refereeId;
		this.name = name;
		this.institution = institution;
		this.email = email;
		this.motivation = motivation;
	}

	public int getRefereeId() {
		return refereeId;
	}

	public void setRefereeId(int refereeId) {
		this.refereeId = refereeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotivation() {
		return motivation;
	}

	public void setMotivation(String motivation) {
		this.motivation = motivation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GuiRefereeOrEditor other = (GuiRefereeOrEditor) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
}
