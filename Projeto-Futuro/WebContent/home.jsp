<%@page import="evento.dao.DBConnection"%>
<%@page import="evento.dao.EventoDAOImpl"%>
<%@page import="evento.dao.EventoDAO"%>
<%@page import="evento.model.Evento"%>
<%@page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Libre+Baskerville:ital,wght@0,400;0,700;1,400&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="css/style.css">
<title>Admin : Login</title>
</head>
<body>
<main class="home-admin">
	<div class="container-home-admin">
		<div class="top"><h2>Olá, Admin</h2></div>

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
			        <p>Tem certeza de que deseja excluir este evento?</p>
			        <button id="confirmDelete">Sim</button>
			        <button id="cancelDelete">Não</button>
			    </div>
		 </div>
		
        <div class="botoes">
            <div class="pagCadastro">
                <a href="cadastrarEvento.jsp"> Cadastrar Evento + </a>
            </div>
            <div class="consultarEventos">
                <a href="consultarEvento.jsp"> Visualizar Eventos > </a>
            </div>
        </div>
		
		<div class="tabela">
			<table> 
				  <thead>
				        <tr>
				            <th class="th1">Titulo</th>
				            <th>Localização</th>
				            <th>Data</th>
				            <th class="th2">Contoles</th>
				        </tr>
				</thead>

				<tbody>
					<%
					EventoDAOImpl dao = new EventoDAOImpl(DBConnection.getConn());
					List<Evento> list = dao.getAllEventos();
					
					if (list != null && !list.isEmpty()) {
					    for (Evento evento : list) {
					%>
					    <tr>
					        <td><%= evento.getTitulo() %></td>
					        <td><%= evento.getLocalizacao() %></td>
					        <td class="td1">
							    <%
							    SimpleDateFormat sdf = new SimpleDateFormat("dd / MM / yyyy");
							    String formattedDate = sdf.format(evento.getData());
							    out.print(formattedDate);
							    %>
							</td>
							<td><a class="delete-link" href="delete?id=<%=evento.getIdEvento()%>" data-id="<%=evento.getIdEvento()%>">Delete</a></td>
					    </tr>
					<%
					    }
					} else {
					%>
					    <tr>
					        <td colspan="4">Nenhum evento encontrado.</td>
					    </tr>
					<%
					}
					%>
		        </tbody>
		    </table>
		</div>
	</div>
</main>

<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
$(document).ready(function() {
    $('.delete-link').click(function(e) {
        e.preventDefault();
        var id = $(this).data('id');
        $('#confirmationModal').show();
        
        $('#confirmDelete').click(function() {
            window.location.href = './delete?id=' + id;
        });

        $('#cancelDelete').click(function() {
            $('#confirmationModal').hide();
        });
    });
});
</script>

</body>
</html>