package projeto.usuarios;

public class Usuario extends Pessoa{
	protected String cargo;
	protected String login;
	protected String senha;
	protected String matricula;

	public Usuario(String nome, String cargo, String login, String senha){
		super(nome);
		this.cargo = cargo;
		this.login = login;
		this.senha = senha;
	}

	public Usuario(String nome, String cargo, String login, String senha, String email, String matricula){
		super(nome, email);
		this.cargo = cargo;
		this.login = login;
		this.senha = senha;
		this.matricula = matricula;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}

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

	public void cadastrarCliente(){}

}
