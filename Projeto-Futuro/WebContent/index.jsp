<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Libre+Baskerville:ital,wght@0,400;0,700;1,400&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="css/style.css">
<title>Projeto Futuro</title>
</head>


<body >
	<main class="main-index"> 
	    <div class="container-index">
            <div class="form">
                <form action="Login" method="post">
                    <h2>Login</h2>
                  	<div class="divMensagem">
					    <%
					  String mensagem = (String) request.getAttribute("mensagem");
					  if (mensagem != null) {
					      out.print(mensagem);
					  }
					  %>
					</div>
                    <label for="email">E-mail</label><br>
                    <input type="email" id="email" name="email" required="required">
                    <br>
                    <label for="senha">Senha</label><br>
                    <input type="password" id="senha" name="senha" required="required">
            
                    
                    <div class="form-bottom">
                        <input class="loginBtn" type="submit" value="Entrar  >">
                    </div>
                    <span>Sua Jornada Começa Aqui - <a href="registro.jsp">Cadastre-se!</a></span>
                </form>
            </div>
            <div class="titulo">
                <h1>Projeto Futuro</h1>
                <p>Descubra a Oportunidade Ideal que Combina com o seu Talento!</p>
            </div>
	    </div>
    </main>
</body>
</html>