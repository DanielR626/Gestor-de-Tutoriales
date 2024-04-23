package servlets;

import com.umariana.conexion.gestionarTutoriales;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "svEliminarTutorial", urlPatterns = {"/svEliminarTutorial"})
public class svEliminarTutorial extends HttpServlet {
    private gestionarTutoriales gestionar = new gestionarTutoriales();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idTutorial = Integer.parseInt(request.getParameter("idTutorial"));

        boolean resultado = gestionar.eliminarTutorial(idTutorial);

        if (resultado) {
            response.sendRedirect("index.jsp");
        } else {
            response.getWriter().println("Error al eliminar el tutorial.");
        }
    }
}
