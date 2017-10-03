package rop.miu.modules.publications.util;

import java.io.Serializable;

public class GuiAuthor implements Serializable{
	private static final long serialVersionUID = 1L;
	private int authorId;
	private String name;
	private String institution;
	private String email;
	private boolean principal;
	
	public GuiAuthor(int authorId, String name, String institution, String email,
			boolean isPrincipal) {
		this.authorId = authorId;
		this.name = name;
		this.institution = institution;
		this.email = email;
		this.principal = isPrincipal;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
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

	public boolean isPrincipal() {
		return principal;
	}

	public void setPrincipal(boolean isPrincipal) {
		this.principal = isPrincipal;
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
		GuiAuthor other = (GuiAuthor) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
}
