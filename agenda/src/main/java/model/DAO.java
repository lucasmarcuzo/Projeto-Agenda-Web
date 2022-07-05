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
	
	/** Módulo de conexão*. */
	
	//Parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "";
	
	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	//Métodos de conexão
	private Connection conectar() {
		Connection connection = null;
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	/**
	 * Inserir contato.
	 *
	 * @param contato the contato
	 */
	//CRUD CREATE
	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos (nome, fone, email) values (?,?,?)";
		try {
			//Abrir conexao.
			Connection connection = conectar();
			
			//Preparar a query para a excecução no BD.
			PreparedStatement pst = connection.prepareStatement(create); 
			
			//Substituir os parâmetos (?) pelo conteúdo das variáveis.
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			
			//Executar a query.
			pst.executeUpdate();
			
			//Encerrar a conexão.
			pst.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Listar contatos.
	 *
	 * @return the array list
	 */
	/* CRUD READ */
	public ArrayList<JavaBeans> listarContatos(){
		//Criando um objeto para acessar a classe JavaBeans.
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		
		String read = "select * from contatos order by nome";
		try {
			Connection connection = conectar();
			PreparedStatement pst = connection.prepareStatement(read);
			ResultSet rs = pst.executeQuery(); //Salva o retorno do BD temporáriamente 
			
			// O laco abaixo será executado enquanto houver contatos.
			while(rs.next()) {
				//variáveis de apoio que recebem os dados do banco.
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				
				//Populando o ArrayList
				contatos.add(new JavaBeans(idcon, nome, fone, email));
			}
			connection.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/* CRUD UPDATE */
	/**
	 * Selecionar contato.
	 *
	 * @param contato the contato
	 */
	//Selecionar o contato
	public void selecionarContato(JavaBeans contato) {
		String read2 = "select * from contatos where idcon = ?";
		try {
			Connection connection = conectar();
			PreparedStatement pst = connection.prepareStatement(read2);
			pst.setString(1, contato.getIdcon());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				//Setar as variáveis JavaBeans
				contato.setIdcon(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			connection.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	/**
	 * Alterar contato.
	 *
	 * @param contato the contato
	 */
	//Editar o contato
	public void alterarContato(JavaBeans contato) {
		String create = "update contatos set nome=?, fone=?, email=? where idcon=?";
		
		try {
			Connection connection = conectar();
			PreparedStatement pst = connection.prepareStatement(create);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getIdcon());
			
			pst.executeUpdate();
			connection.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/* CRUD DELETE */
	/**
	 * Deletar contato.
	 *
	 * @param contato the contato
	 */
	//Apagar o contato.
	public void deletarContato(JavaBeans contato) {
		String delete = "delete from contatos where idcon=?";
		
		try {
			Connection connection = conectar();
			PreparedStatement pst = connection.prepareStatement(delete);
			pst.setString(1, contato.getIdcon());
			pst.executeUpdate();
			connection.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
