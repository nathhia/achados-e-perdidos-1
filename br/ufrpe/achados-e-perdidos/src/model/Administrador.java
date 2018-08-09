package model;

public class Administrador extends Pessoa {
	//atributos
	private String login;
	private String senha;
	
	//tostring
	@Override
	public String toString() {
		return "Administrador [login=" + login + ", senha=" + senha + "]";
	}
	
	//hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}
	
	//equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrador other = (Administrador) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}
	
	//geters e setters
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	//cadastro do administrador/
	public boolean cadastrarAdministrador(Administrador adm ){
		this.nome = adm.nome;
		this.email = adm.email;
		this.cpf = adm.cpf;
		this.telefone = adm.telefone;
		this.login = adm.login;
		this.senha = adm.senha;
		return true;
	}

}
