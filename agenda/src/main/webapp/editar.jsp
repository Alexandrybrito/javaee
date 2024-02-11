<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Agenda de contatos</title>
<link rel="icon" href="imagens/icongreen.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar Contato</h1>
	<form name="formContato" action="update">
		<table>
			<tr>
				<td><input type="text" name="id" id="caixa3" readonly 
value="<%out.print(request.getAttribute("id"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="empresa" class="Caixa1" 
value="<%out.print(request.getAttribute("empresa"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" class="Caixa1" 
value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="fone" class="Caixa2" 
value="<%out.print(request.getAttribute("fone"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="fone2" class="Caixa2" 
value="<%out.print(request.getAttribute("fone2"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="email" class="Caixa1" 
value="<%out.print(request.getAttribute("email"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="endereço" class="Caixa1" 
value="<%out.print(request.getAttribute("endereço"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="Botao1"
			onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>









