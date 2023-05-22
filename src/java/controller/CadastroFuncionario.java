package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import model.Funcionario;
import model.FuncionarioDAO;


@WebServlet(name = "CadastroFuncionario", urlPatterns = {"/CadastroFuncionario"})
public class CadastroFuncionario extends HttpServlet {
    private int id;
    private String nome;
    private int cargo_id;
    private BigDecimal salario;
    private Date data_nascimento;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //Recebendo valores do formulário de cadastro
        this.nome = request.getParameter("nome");
        this.cargo_id = Integer.parseInt(request.getParameter("cargo_id"));
        
       
               
         //Criando objeto da classe Funcionario para salvar no BD
        Funcionario funcionario = new Funcionario(
                this.id,
                this.nome,
                this.cargo_id,
                this.salario,
                this.data_nascimento
        );
        
        //Instanciando a classe DAO para usar o método
        //de inserção enviando o objeto criado acima
        try {
            FuncionarioDAO fundao = new FuncionarioDAO();
            fundao.insertFuncionario(funcionario);
            response.sendRedirect("lista.jsp");
        
        } catch(ClassNotFoundException | SQLException erro) {   
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastroArtista</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Ocorreu algum erro: " + erro + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}