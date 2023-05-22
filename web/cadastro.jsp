        <%-- 
            Document   : cadastro
            Created on : 10 de mai. de 2023, 19:24:55
            Author     : QI
        --%>
       <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <!DOCTYPE html>
        <html>
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Cadastro de Funcionários</title>
                <link rel="stylesheet" href="css/style.css"/>
            </head>
            <body id='cadastro'>
                <h1>Cadastro</h1>
                <div>
                <form action="CadastroFuncionarioUm" method="post" id="form_funcionario" >
                    <h3>Dados do funcionário</h3>
                    
                    
                     <label for="funcionario">Nome completo: </label>
                     <br>
                    <input type="text" name="funcionario" class= "fields" placeholder="Nome">
                    <br><br>
                    <label for="Data_nascimento">Data de nascimento: </label>
                    <br>
                    <input type="date" name="Data_nascimento">
                    <br><br>
                    <label for="salario">Salário:</label>
                    <br>
                    <input type="text" class= "fields" name="Salário" placeholder="Salário" value="">
                    <br><br>
                    
                    <select name="ID_cargo" class= "fields" required >
                        <option value="" >Cargo</option>
                        <option value="Gerente" >Gerente</option>
                        <option value="Vendedor" >Vendedor</option>
                        <option value="Estoquista" >Estoquista</option>
                    </select>
                    <br><br>
                      <input type="submit" value="Cadastrar" name="name"><br>                
                        <button style=" border-radius: 10px; padding: 5px; font-size: 7pt; font-weight: bold; box-shadow: 3px 3px 3px black; margin-top: 2%;">
                           <a href="home.jsp" >Pagina inicial</a>
                      </button>
                </form>
                 </div>
                
                
            </body>