<%@page import="lojacat.dao.ProdutoDao"%>
<%@page import="lojacat.dao.ProdutoDaoImpl"%>
<%@page import="lojacat.model.Produto"%>
<%@page import="lojacat.dao.ProdutoConnection"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <title>Página do Produto</title>
</head>
<body>
	<nav class="nav">
		<div class="navicon">
			<div class="logo"><img src="img/nomelogo.png"></div>
			<a href="index.jsp" class="nav_link">Home</a>
			<a href="catalogo.jsp"  class="nav_link">Catálogo de Brinquedos</a>
			<a href="login.jsp"  class="nav_link">Administração</a>
			<a href="equipe.jsp"  class="nav_link">Sobre a equipe</a>
		</div>
	</nav>
    <main>
		<div class="navTop">
			<img src="img/nomeloja.png">
		</div>
        <div class="detalhes-container">
        	<h1> Detalhes do Produto </h1>
		    <div class="line"></div>
		    <div class="detalhesTop">
		            <%
		            String productId = request.getParameter("id");
		            if (productId != null && !productId.isEmpty()) {
		                ProdutoDao dao = new ProdutoDaoImpl(ProdutoConnection.conectar());
		                int productIdInt = Integer.parseInt(productId);
		                Produto produto = dao.getProdutoById(productIdInt);
		            %>
		            <img src="img/produtos/<%=produto.getNomeImagem()%>" alt="<%=produto.getDescricao()%>">
					<div class="detalhesMeio">
			            <div>Código: <%= produto.getCodigo() %></div>
			            <div><span class="descricao"><%= produto.getDescricao() %></span></div>
			            <div><span class="preco">R$ <%= produto.getPreco() %></span></div>
					</div>
			</div> 
			<div class="detalhesBottom" style="word-wrap: break-word;">Detalhes sobre o produto: <%= produto.getDetalhe()%></div>
            <%
            } else {
            %>
            <p>Produto não encontrado.</p>
            <%
            }
            %>
        </div>
    </main>
</body>
</html>
