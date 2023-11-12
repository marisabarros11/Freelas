<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Libre+Baskerville:ital,wght@0,400;0,700;1,400&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="css/style.css">
<title>Projeto Futuro - Registro</title>

</head>
<body>
    <main class="main-registro">
        <div class="container-registro">
            <div><img src="img/img-registro.jpg"></div>
            <div class="form-registro">
                <form action="Registro" method="post">
                    <h2>Crie sua conta</h2>
                    <label for="nome">Nome</label><br>
                    <input type="text" id="nome" name="nome" required="required"><br>
            
                    <label for="email">E-mail</label><br>
                    <input type="email" id="email" name="email" required="required" placeholder="nome@email.com"><br>
            
                    <label for="telefone">Telefone</label><br>
                    <input type="tel" id="telefone" name="telefone" placeholder="(11) 94559-5651"><br>
            
                    <label for="senha">Senha</label><br>
                    <input type="password" id="senha" name="senha" required="required">
                    <br>
                    <div class="registroBtn"><input type="submit" value="Cadastrar  >"></div>
                </form>
            </div>
        </div>
    </main>
</body>
</html>