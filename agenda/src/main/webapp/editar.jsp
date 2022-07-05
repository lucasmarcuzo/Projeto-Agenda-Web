<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda de Contatos - Editar</title>
<link rel="icon" href="imagens/telefone.png"></link>
<link rel="stylesheet" href="style.css"></link>
</head>
<body>
	<h1>Editar contato</h1>
	<form name="frmContato" action="update">
		<table>
			<tr>
				<td><input id="caixa3" type="text" name="idcon" readonly 
				value="<%out.print(request.getAttribute("idcon"));%>"></td>
			</tr>
			<tr>
				<td><input class="Caixa1" type="text" name="nome" 
				value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td><input class="Caixa2" type="tel" name="fone"
				value="<%out.print(request.getAttribute("fone"));%>"></td>
			</tr>
			<tr>
				<td><input class="Caixa1" type="email" name="email"
				value="<%out.print(request.getAttribute("email"));%>"></td>
			</tr>
		</table>
		<input class="Botao1" type="button" value="Salvar" onclick="validar()">
	</form>
	<script src="scripts/validador.js">
	</script>
</body>
</html>