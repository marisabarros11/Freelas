package evento.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import evento.dao.DBConnection;
import evento.dao.EventoDAOImpl;
import evento.model.Evento;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddEvento
 */
public class AddEvento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddEvento() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mensagem = "";

        try {
            String titulo = request.getParameter("titulo");
            String localizacao = request.getParameter("localizacao");
            String descricao = request.getParameter("descricao");

            // Obter a data e formatá-la
            String dataStr = request.getParameter("data");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date data = null;

            try {
                data = sdf.parse(dataStr);
            } catch (ParseException e) {
                mensagem = "Erro: Data inválida.";
                e.printStackTrace();
            }

            Evento evento = new Evento(titulo, localizacao, descricao, data);

            EventoDAOImpl dao = new EventoDAOImpl(DBConnection.getConn());

            boolean f = dao.addEvento(evento);

            if (f) {
                mensagem = "Evento adicionado com sucesso";

            } else {
                mensagem = "Erro ao adicionar o evento";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("mensagem", mensagem);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarEvento.jsp");
        dispatcher.forward(request, response);
    }
}
