package model;

public class Pessoa {
	
	//declaração de atributos
	protected String nome;
    protected String email;
    protected String telefone;
    protected String cpf;

    //tostring
    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
    
    
    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pessoa pessoa = (Pessoa) o;

        if (!nome.equals(pessoa.nome)) return false;
        if (!email.equals(pessoa.email)) return false;
        if (telefone != null ? !telefone.equals(pessoa.telefone) : pessoa.telefone != null) return false;
        return cpf.equals(pessoa.cpf);
    }
    
    //hashcode
    @Override
    public int hashCode() {
        int result = getNome().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getTelefone().hashCode();
        result = 31 * result + getCpf().hashCode();
        return result;
    }

    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
    
    



}
