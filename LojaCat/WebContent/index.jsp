<%@page import="lojacat.dao.ProdutoConnection"%>
<%@page import="lojacat.dao.ProdutoDao"%>
<%@page import="lojacat.dao.ProdutoDaoImpl"%>
<%@page import="lojacat.model.Produto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="js/app.js"></script>
    <title>LojaCat - Home</title>
</head>
<body>
	<nav class="nav">
		<div class="navicon">
			<div class="logo"><img src="img/nomelogo.png"></div>
			<a href="index.jsp" class="nav_link active">Home</a>
			<a href="catalogo.jsp"  class="nav_link">Catálogo de Brinquedos</a>
			<a href="login.jsp"  class="nav_link">Administração</a>
			<a href="equipe.jsp"  class="nav_link">Sobre a equipe</a>
		</div>
	</nav>
	<main>
		<div class="navTop">
			<img src="img/nomeloja.png">
		</div>
		<div class="produtos-container">
			<h1> Brinquedos em Destague</h1>
			<div class="line"></div>
			<div class="produtoDestaque">
					<%
					ProdutoDaoImpl dao = new ProdutoDaoImpl(ProdutoConnection.conectar());
					List<Produto> list = dao.getAllProduto();
					
					if (list != null && !list.isEmpty()) {
					    for (Produto produto : list) {
					%>
					    <div class="produtos">
					        <div><a href="produto.jsp?id=<%= produto.getIdProduto() %>"><img src="img/produtos/<%= produto.getNomeImagem() %>"></a></div>
					        <div><%= produto.getDescricao() %></div>
					        <div>R$ <%= produto.getPreco() %></div>
					    </div>
					<%
					    }
					} else {
					%>
					    <div class="semProduto">
					        Nenhum produto encontrado.
					    </div>
					<%
					}
					%>
			</div>
		</div>
	</main>
</body>
</html>