import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;
import model.Funcionario;
import model.FuncionarioDAO;

@WebServlet(name = "CadastroFuncionarioUm", urlPatterns = {"/CadastroFuncionarioUm"})
public class CadastroFuncionarioUm extends HttpServlet {
    private int id;
    private String nome;
    private int cargo_id;
    private BigDecimal salario;
    private Date data_nascimento;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Recebendo valores do formulário de cadastro
        this.nome = request.getParameter("funcionario");
        this.cargo_id = Integer.parseInt(request.getParameter("ID_cargo"));
        String dataNascimentoStr = request.getParameter("Data_nascimento");

        // Convertendo a string de data em LocalDate
        LocalDate localDate = LocalDate.parse(dataNascimentoStr);

        // Convertendo LocalDate para Date
        this.data_nascimento = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

        // Criando objeto da classe Funcionario para salvar no BD
        Funcionario funcionario = new Funcionario(
                this.id,
                this.nome,
                this.cargo_id,
                this.salario,
                this.data_nascimento
        );

        // Resto do código...
    }

    // Resto do código...
}
