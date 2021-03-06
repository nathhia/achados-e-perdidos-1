package model;

public class Aluno extends Pessoa{
	//atributos
	private String login;
	private String senha;
	private String curso;
	private int id = 0;
	
	//to string
	@Override
	public String toString() {
		return "Aluno [login=" + login + ", senha=" + senha + ", curso=" + curso + ", id=" + id + "]";
	}
	
	//hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + id;
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
		Aluno other = (Aluno) obj;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (id != other.id)
			return false;
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
	
	//getters setters
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
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//cadastrar aluno
	public boolean cadastrarAluno(Aluno aluno){
		this.nome = aluno.nome;
		this.email = aluno.email;
		this.cpf = aluno.cpf;
		this.telefone = aluno.telefone;
		this.login = aluno.login;
		this.senha = aluno.senha;
		this.id = aluno.id-48;
		id++;
		return true;
	}
}
