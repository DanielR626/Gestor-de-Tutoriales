package servlets;

import com.umariana.conexion.gestionarTutoriales;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *

 */
@WebServlet(name = "svAgregarTutorial", urlPatterns = {"/svAgregarTutorial"})
public class svAgregarTutorial extends HttpServlet {

            gestionarTutoriales gestionar = new gestionarTutoriales();
            
            
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
  
    }
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       Connection conn = gestionar.establecerConexion();

        if (conn != null) {
            try {
                CallableStatement stmt = conn.prepareCall("{call agregarTutorial(?, ?, ?, ?, ?, ?)}");
                String idTutorial = request.getParameter("idTutorial");
                String nombre = request.getParameter("nombre");               
                String p = request.getParameter("prioridad");
                int prioridad=Integer.parseInt(p);               
                String url = request.getParameter("url");
                String estado = request.getParameter("estado");           
                String cat=request.getParameter("categoria");
                int categoria = Integer.parseInt(cat);
                
                stmt.setString(1, idTutorial);
                stmt.setString(2, nombre);                
                stmt.setInt(3, prioridad);
                stmt.setString(4, url);
                stmt.setString(5, estado);
                stmt.setInt(6, categoria);                                

                stmt.execute();
                conn.close();

                response.sendRedirect("index.jsp");              
                System.out.println("conexion exitosa");
            } catch (SQLException e)
            {
                e.printStackTrace(); 
                response.getWriter().println("error");
            }
        } else 
        {
            response.getWriter().println("No se pudo establecer una conexión a la base de datos.");
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}