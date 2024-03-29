<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
	@ SuppressWarnings ("unchecked")
	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");

/*for (int i=0; i<lista.size(); i++) {
	out.println(lista.get(i).getId());
	out.println(lista.get(i).getEmpresa());
	out.println(lista.get(i).getNome());
	out.println(lista.get(i).getFone());
	out.println(lista.get(i).getFone2());
	out.println(lista.get(i).getEmail());
	out.println(lista.get(i).getEndereco());
}*/
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Agenda de contatos</title>
<link rel="icon" href="imagens/icongreen.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Agenda de Contatos</h1>
	<a href="novo.html" class="Botao1">Novo contato</a>
	<a href="report" class="Botao2">Relatório</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Empresa</th>
				<th>Nome</th>
				<th>Fone</th>
				<th>Fone2</th>
				<th>E-mail</th>
				<th>Endereço</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i=0; i<lista.size(); i++) { %>
				<tr>
					<td><%=lista.get(i).getId()%></td>
					<td><%=lista.get(i).getEmpresa()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td><%=lista.get(i).getFone()%></td>
					<td><%=lista.get(i).getFone2()%></td>
					<td><%=lista.get(i).getEmail()%></td>
					<td><%=lista.get(i).getEndereco()%></td>
					<td><a href="select?id=<%=lista.get(i).getId()%>" class="Botao1">Editar</a>
						<a href="javascript: confirmar(<%=lista.get(i).getId()%>)" class="Botao2">Excluir</a>
					</td>
				</tr>
			<%} %>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>




