package model;

// TODO: Auto-generated Javadoc
/**
 * The Class JavaBeans.
 */
public class JavaBeans {
	
	/** The id. */
	private Integer id;
	
	/** The empresa. */
	private String empresa;
	
	/** The nome. */
	private String nome;
	
	/** The fone. */
	private String fone;
	
	/** The fone 2. */
	private String fone2;
	
	/** The email. */
	private String email;
	
	/** The endereco. */
	private String endereco;
	
	/**
	 * Instantiates a new java beans.
	 */
	public JavaBeans() {
		super();
	}

	
	/**
	 * Instantiates a new java beans.
	 *
	 * @param id the id
	 * @param empresa the empresa
	 * @param nome the nome
	 * @param fone the fone
	 * @param fone2 the fone 2
	 * @param email the email
	 * @param endereco the endereco
	 */
	public JavaBeans(Integer id, String empresa, String nome, String fone, String fone2, String email,
			String endereco) {
		super();
		this.id = id;
		this.empresa = empresa;
		this.nome = nome;
		this.fone = fone;
		this.fone2 = fone2;
		this.email = email;
		this.endereco = endereco;
	}


	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the empresa.
	 *
	 * @return the empresa
	 */
	public String getEmpresa() {
		return empresa;
	}

	/**
	 * Sets the empresa.
	 *
	 * @param empresa the new empresa
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Gets the fone.
	 *
	 * @return the fone
	 */
	public String getFone() {
		return fone;
	}

	/**
	 * Sets the fone.
	 *
	 * @param fone the new fone
	 */
	public void setFone(String fone) {
		this.fone = fone;
	}

	/**
	 * Gets the fone 2.
	 *
	 * @return the fone 2
	 */
	public String getFone2() {
		return fone2;
	}

	/**
	 * Sets the fone 2.
	 *
	 * @param fone2 the new fone 2
	 */
	public void setFone2(String fone2) {
		this.fone2 = fone2;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the endereco.
	 *
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * Sets the endereco.
	 *
	 * @param endereco the new endereco
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
