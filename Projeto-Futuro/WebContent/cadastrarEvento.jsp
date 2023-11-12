<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Libre+Baskerville:ital,wght@0,400;0,700;1,400&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="css/style.css">
<title>Cadastro de Evento</title>

</head>
<body>
	<main class="main-cadastro">
		<div class="cadastrar">
	        <h1>Cadastrar Evento</h1>
	        <div class="voltar">
                <a href="home.jsp"> < Voltar </a>
            </div>
            <div class="divMensagem">
			    <%
			    String mensagem = (String) request.getAttribute("mensagem");
			    if (mensagem != null) {
			        out.print(mensagem);
			    }
			    %>
            </div>
			
			<div class="formEvento">
				<form action="AddEvento" method="post">
			        <label for="titulo">Título:</label>
			        <input type="text" id="titulo" name="titulo" required><br><br>
			        
			        <label for="localizacao">Localização:</label>
			        <input type="text" id="localizacao" name="localizacao" required><br><br>
			
			        <label for="descricao">Descrição:</label>
			        <textarea id="descricao" name="descricao" required></textarea><br><br>
			
			        <label for="data">Data:</label>
			        <input type="date" id="data" name="data" required><br><br>
			
			
			        <div class="cadastrarBtn"><input type="submit" value="Cadastrar Evento  >"></div>
			    </form>		
			</div>
		</div>
	</main>
</body>
</html>