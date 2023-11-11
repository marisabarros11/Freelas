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
    <title>Consultar Produto</title>
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
		<div class="consulta">
			<h1> Todos os produtos</h1>
			 <div class="divMensagem">
			    <%
			    String mensagem = (String) request.getAttribute("mensagem");
			    if (mensagem != null) {
			        out.print(mensagem);
			    }
			    %>
            </div>
            <div id="confirmationModal" class="modal">
			    <div class="modal-content">
			        <p>Tem certeza de que deseja excluir este produto?</p>
			        <button id="confirmDelete">Sim</button>
			        <button id="cancelDelete">Não</button>
			    </div>
		    </div>
		    <div class="pagCadastro">
			        <a href="cadastrarProduto.jsp">Novo Brinquedo +</a>
		    </div>
			 <table> 
				  <thead>
				        <tr>
				            <th class="th1">Descrição</th>
				            <th>Categoria</th>
				            <th>Valor</th>
				            <th class="th2">Controles</th>
				        </tr>
				</thead>

				<tbody>
					<%
					ProdutoDaoImpl dao = new ProdutoDaoImpl(ProdutoConnection.conectar());
					List<Produto> list = dao.getAllProduto();
					
					if (list != null && !list.isEmpty()) {
					    for (Produto produto : list) {
					%>
					    <tr>
					        <td><%= produto.getDescricao() %></td>
					        <td><%= produto.getCategoria() %></td>
					        <td>R$ <%= produto.getPreco() %></td>
					        <td>
					            <a href="editar.jsp?id=<%=produto.getIdProduto()%>">Editar</a>
					            <a href="delete?id=<%=produto.getIdProduto()%>">Delete</a>
					        </td>
					    </tr>
					<%
					    }
					} else {
					%>
					    <tr>
					        <td colspan="4">Nenhum produto encontrado.</td>
					    </tr>
					<%
					}
					%>
		        </tbody>
		    </table>
		</div>
	</main>
</body>
</html>