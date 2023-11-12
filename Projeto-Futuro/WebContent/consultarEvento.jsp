<%@page import="evento.dao.DBConnection"%>
<%@page import="evento.dao.EventoDAOImpl"%>
<%@page import="evento.dao.EventoDAO"%>
<%@page import="evento.model.Evento"%>
<%@page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html style="
    background: currentColor;">
<head>
	<meta charset="UTF-8">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Libre+Baskerville:ital,wght@0,400;0,700;1,400&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="css/style.css">
<title>Bem-Vindo</title>

</head>
<body>
<main class="main-consulta">
	<div class="container-consulta">
		<div class="top"><h2>Bem vindxs!</h2></div>
		<div class="top"><p>Encontre seu próximo evento</p></div>
		<div class="eventosDestaque">
					<%
					EventoDAOImpl dao = new EventoDAOImpl(DBConnection.getConn());
					List<Evento> list = dao.getAllEventos();
					
					if (list != null && !list.isEmpty()) {
					    for (Evento evento : list) {
					%>
					    <div class="evento">
					    		<span class="titulo"><%= evento.getTitulo()%></span> <br><br>
					        	<%= evento.getLocalizacao() %> <br> <br>
					        <div>
					        	<%
							    SimpleDateFormat sdf = new SimpleDateFormat("dd / MM / yyyy");
							    String formattedDate = sdf.format(evento.getData());
							    out.print(formattedDate);
							    %> <br><br>
					        	<%= evento.getDescricao() %> <br><br>
					      </div>
					    </div>
					<%
					    }
					} else {
					%>
					    <div class="semEvento">
					        Nenhum evento encontrado.
					    </div>
					<%
					}
					%>
			</div>			
	</div>
</main>

</body>
</html>