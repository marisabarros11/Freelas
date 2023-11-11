<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="js/app.js"></script>    
    <title>Login</title>
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
		
		<div class="login">
			<h1> Login </h1>
			<form action="loginConnection" method="post">
			<div class="divMensagem">
			    <%
			    String mensagem = (String) request.getAttribute("mensagem");
			    if (mensagem != null) {
			        out.print(mensagem);
			    }
			    %>
            </div>
				<table>
					<tr>
						<td class="title"> Usuário:</td>
						<td><input type="text" name="txtName" class="user"></td>						
					</tr>
					<tr>
						<td class="title"> Senha:</td>
						<td><input type="password" name="txtPwd" class="pwd"></td>						
					</tr>
					
					<tr>
                        <td><input type="submit" value="Login"></td>
                        <td><input type="submit" value="Reset"></td>
					</tr>
				</table>		
			</form>
		</div>
	</main>
</body>
</html>