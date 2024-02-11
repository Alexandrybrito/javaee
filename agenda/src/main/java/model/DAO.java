package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	
	/**  Módulo de conexão *. */
	// Parametro de conexão

	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "741852";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	// Método de conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 *  CRUD CREATE *.
	 *
	 * @param contato the contato
	 */
	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos (empresa,nome,fone,fone2,email,endereco) values (?,?,?,?,?,?)";
		try {
			// abrir a conexão
			Connection con = conectar();
			// Preparar a query para executar no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// substituir os parâmetros (?) pelo conteúdo das variáveis JavaBeans
			pst.setString(1, contato.getEmpresa());
			pst.setString(2, contato.getNome());
			pst.setString(3, contato.getFone());
			pst.setString(4, contato.getFone2());
			pst.setString(5, contato.getEmail());
			pst.setString(6, contato.getEndereco());
			// Executar a query
			pst.executeUpdate();
			// Encerrar a conexão com o banco
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 *  CRUD READ ALL*.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listarContatos() {
		// criando um objeto para acessar a classe Javabeans
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		String read = "select * from contatos order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// o laço abaixo será executado enquanto houver contatos
			while (rs.next()) {
				// variáveis de apoio que recebem os dados do banco
				Integer id = rs.getInt(1);
				String empresa = rs.getString(2);
				String nome = rs.getString(3);
				String fone = rs.getString(4);
				String fone2 = rs.getString(5);
				String email = rs.getString(6);
				String endereco = rs.getString(7);
				// populando o ArrayList
				contatos.add(new JavaBeans(id, empresa, nome, fone, fone2, email, endereco));
			}
			con.close();
			return contatos;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 *  CRUD READ ONE *.
	 *
	 * @param contato the contato
	 */
	//selecionar o contato
	public void selecionarContato(JavaBeans contato) {
		String read2 = "select * from contatos where id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, contato.getId());
			ResultSet rs = pst.executeQuery();
			// setar as variáveis JavaBeans
			while (rs.next()) {
				contato.setId(rs.getInt(1));
				contato.setEmpresa(rs.getString(2));
				contato.setNome(rs.getString(3));
				contato.setFone(rs.getString(4));
				contato.setFone2(rs.getString(5));
				contato.setEmail(rs.getString(6));
				contato.setEndereco(rs.getString(7));
				pst.executeUpdate();
				con.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	/**
	 * CRUD UPDATE *.
	 *
	 * @param contato the contato
	 */
	// Editar o contato
	public void alterarContato(JavaBeans contato) {
		String update = "update contatos set empresa=?, nome=?, fone=?, fone2=?, email=?, endereco=? where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, contato.getEmpresa());
			pst.setString(2, contato.getNome());
			pst.setString(3, contato.getFone());
			pst.setString(4, contato.getFone2());
			pst.setString(5, contato.getEmail());
			pst.setString(6, contato.getEndereco());
			pst.setInt(7, contato.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 *  CRUD DELETE *.
	 *
	 * @param contato the contato
	 */
	public void deletarContato(JavaBeans contato) {
		String delete = "delete from contatos where id=?";
		try {
			Connection con= conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setInt(1, contato.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
