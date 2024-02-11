package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;
import model.JavaBeans;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete", "/report" })
public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The dao. */
	DAO dao = new DAO();
	
	/** The contato. */
	JavaBeans contato = new JavaBeans();

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		super();

	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			contatos(request, response);
		} else if (action.equals("/insert")) {
			adicionarContato(request, response);
		} else if (action.equals("/select")) {
			listarContato(request, response);
		} else if (action.equals("/update")) {
			editarContato(request, response);
		} else if (action.equals("/delete")) {
			removerContato(request, response);
		} else if (action.equals("/report")) {
			gerarRelatorio(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	
	/**
	 * Contatos.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Listar contatos
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que ir´receber os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarContatos();
		// Encaminhar a lista ao documento agrenda.jsp
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
	}

	
	/**
	 * Adicionar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Adicionar contato
	protected void adicionarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar as variáveis JavaBeans
		contato.setEmpresa(request.getParameter("empresa"));
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setFone2(request.getParameter("fone2"));
		contato.setEmail(request.getParameter("email"));
		contato.setEndereco(request.getParameter("endereço"));

		// invocar o método inserirContato passando o objeto contato
		dao.inserirContato(contato);
		// redirecionar para o documento agenda.jsp
		response.sendRedirect("main");
	}

	
	/**
	 * Listar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Editar contato
	protected void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebimento do id do contato que será editado
		Integer id = Integer.parseInt(request.getParameter("id"));
		// System.out.println(id);
		// Setar a variável JavaBeans
		contato.setId(id);
		// Executar o método selecionarContato (DAO)
		dao.selecionarContato(contato);
		// Setar oas atributos do formulário com o conteúdo JavaBeans
		request.setAttribute("id", contato.getId());
		request.setAttribute("empresa", contato.getEmpresa());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("fone", contato.getFone());
		request.setAttribute("fone2", contato.getFone2());
		request.setAttribute("email", contato.getEmail());
		request.setAttribute("endereço", contato.getEndereco());
		// Encaminhar ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);

	}
	
	
	/**
	 * Editar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Editar um contato
	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Setar as variáveis JavaBeans
		Integer id = Integer.parseInt(request.getParameter("id"));
		contato.setId(id);		
		//contato.setId(request.getParameter("id"));
		contato.setEmpresa(request.getParameter("empresa"));
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setFone2(request.getParameter("fone2"));
		contato.setEmail(request.getParameter("email"));
		contato.setEndereco(request.getParameter("endereço"));
		// Executar o método alterarContato
		dao.alterarContato(contato);
		// Redirecionar para o documento agenda.jsp (atualizando as alterações)
		response.sendRedirect("main");
	}
	
	
	/**
	 * Remover contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Remover um contato
	protected void removerContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebimento do id do contato a ser excluído (validador.js)
		Integer id = Integer.parseInt(request.getParameter("id"));
		// setar a variável id JavaBeans
		contato.setId(id);
		//System.out.println(id);
		// executar o método deletarContato (DAO) passando o objeto contato
		dao.deletarContato(contato);
		// redirecionar para o documento agenda.jsp (atualizando as alterações)
		response.sendRedirect("main");
	}
	
	/**
	 * Gerar relatorio.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Gerar relatório em PDF
	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			// tipo de conteúdo
			response.setContentType("apllication/pdf");
			// nome do documento
			response.addHeader("Content-Disposition", "inline; filename= contatos.pdf");
			// criar o documento
			PdfWriter.getInstance(documento, response.getOutputStream());
			// abrir o documento -> conteúdo
			documento.open();
			documento.add(new Paragraph("Lista de Contatos de Construtores:"));
			documento.add(new Paragraph(" "));
			documento.add(new Paragraph(" "));
			// criar uma tabela
			PdfPTable tabela = new PdfPTable(3);
			// cabeçalho
			PdfPCell col1 = new PdfPCell(new Paragraph("Empresa"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Fone"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			// popular a tabela com os contatos
			ArrayList<JavaBeans> lista = dao.listarContatos();
			for (int i=0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getEmpresa());
				tabela.addCell(lista.get(i).getNome());
				tabela.addCell(lista.get(i).getFone());
			}
			documento.add(tabela);
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
		
	}
}
