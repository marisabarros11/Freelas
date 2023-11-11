<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="js/app.js"></script>
    <title>Cadastrar Produto</title>
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
		<div class="pagCadastro">
		        <a href="consultarProduto.jsp">Voltar</a>
	    </div>
		<div class="cadastrar">
	        <h1>Cadastrar Brinquedo</h1>
	        
            <div class="divMensagem">
			    <%
			    String mensagem = (String) request.getAttribute("mensagem");
			    if (mensagem != null) {
			        out.print(mensagem);
			    }
			    %>
            </div>
			<form action="cadastrarProduto" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
			    <div class="form-group">
			        <label for="codigo">Código</label>
			        <input type="text" id="codigo" name="codigo" value="${not empty codigo ? codigo : ''}">
			    </div>
			    <div class="form-group">
			        <label for="descricao">Descrição</label>
			        <input type="text" id="descricao" name="descricao" value="${not empty descricao ? descricao : ''}">	
			    </div>
			    <div class="form-group">
			        <label for="categoria">Categoria</label>
			        <select id="categoriaSelect" name="categoria" >
			            <option selected>-- Selecionar --</option>
			            <option value="Madeira">Madeira</option>
			            <option value="Pelúcia">Pelúcia</option>
			            <option value="Plástico">Plástico</option>
			        </select>	
			    </div>
			    <div class="form-group">
			        <label for="marca">Marca</label>
			        <input type="text" id="marca" name="marca" value="${not empty marca ? marca : ''}">	
			    </div>
			    <div class="form-group">
			        <label for="valor">Valor</label>
			        <input type="text" id="valor" name="valor" value="${not empty valor ? valor : ''}" placeholder="Formato 12,00 - somente número">	
			    </div>
			    <div class="form-group" id="form-group-detalhe">
			        <label for="detalhe">Detalhe</label>
			        <textarea id="detalhe" name="detalhe" rows="4" cols="50" placeholder="Escreva aqui os detalhes do brinquedo...">${not empty detalhe ? detalhe : ''}</textarea>	
			    </div>
			    <div class="form-group">
			        <label for="nomeImagem">Imagem</label>
			        <input type="file" id="nomeImagem" name="nomeImagem" value="${not empty nomeImagem ? nomeImagem : ''}">	
			    </div>                  
			    <div>
			        <input class="cadastrarBtn" type="submit" name="salvar" value="Cadastrar Brinquedo">
			    </div>
			</form>
    	</div>
	</main>
	<script>
		// Lógica para guardar o select
		var categoria = "${not empty categoria ? categoria : ''}";
		var categoriaSelect = document.getElementById("categoriaSelect");
		if (categoria) {
		    for (var i = 0; i < categoriaSelect.options.length; i++) {
		        if (categoriaSelect.options[i].value === categoria) {
		            categoriaSelect.selectedIndex = i;
		            break;
		        }
		    }
		}	
	</script>
</body>
</html>