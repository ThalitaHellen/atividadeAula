package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionarioDAO {
    private static Connection conn;
    
    public FuncionarioDAO() throws ClassNotFoundException, SQLException {
        conn = MyDatabase.getDatabase();
    }
    
    //****Métodos do CRUD****
    //INSERT (Create)
    public void insertFuncionario(Funcionario f) throws SQLException{
        //Criando a query para inserir o registro
        String query = "INSERT INTO funcionario(id, nome, cargo_id, salario)"
                + "VALUES(?,?,?,?)";
        
        //Preparar a query para ser executada no BD
        PreparedStatement prep = conn.prepareStatement(query);
        
       prep.setInt(1, f.getId());
       prep.setString(2, f.getNome());
       prep.setInt(3, f.getCargo_Id());
       prep.setBigDecimal(4, f.getSalario()); 
        
        //Executando a query pronta
        prep.execute();
        prep.close();
    }
    
    
    //SELECT
    public ArrayList<Funcionario> listAll() throws SQLException {
        //Criar lista vazia
        ArrayList<Funcionario> list = new ArrayList<>();
        
        //Criar query para pesquisa no BD
        String query = "SELECT * FROM funcionario";
        
        //Preparar query para executar no BD
        PreparedStatement prep = conn.prepareStatement(query);
        
        //Pegar o resultado da pesquina no BD
        ResultSet res = prep.executeQuery();
        
        //Varrer "res" mapeando os registros do BD
        //Para objetos da classe "Artista"
        while(res.next()) {
            //Criar objeto Artista vazio
            Funcionario func = new Funcionario();
            
            //Inserir os valores nos atributos com
            //os dados vindos das colunas do BD
            func.setId(res.getInt("id"));
            func.setNome(res.getString("nome"));
            func.setCargo_Id(res.getInt("cargo_id"));
            func.setSalario(res.getBigDecimal("salario"));
            
            //Inserir o objeto completo na lista
            list.add(func);
        }
        
        //Retornar lista cheia
        return list;
    }
    
    
    //SELECT
    public Funcionario listById(int i) throws SQLException {
        String query = "SELECT * FROM funcionario "
                + "WHERE id = " + i;
        
        PreparedStatement prep = conn.prepareStatement(query);
        ResultSet res = prep.executeQuery();
        
        Funcionario func = new Funcionario();
        
        if(res.next()) {
            func.setId(res.getInt("id"));
            func.setNome(res.getString("nome"));
            func.setCargo_Id(res.getInt("cargo_id"));
            func.setSalario(res.getBigDecimal("salario"));
        }
        
        return func;
    }
    
    
    //UPDATE
    public void updateFuncionario(Funcionario func) throws SQLException {
        String query = "UPDATE funcionario SET nome = ?,"
                + "cargo_id = ?, salario = ?,";
        
        PreparedStatement prep = conn.prepareStatement(query);
        prep.setInt(1, func.getId());
       prep.setString(2, func.getNome());
       prep.setInt(3, func.getCargo_Id());
       prep.setBigDecimal(4, func.getSalario()); 
        
        prep.execute();
        prep.close();
    }
    
}//Fim da classe 