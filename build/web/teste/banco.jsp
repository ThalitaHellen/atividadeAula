<%@page import="java.sql.SQLException"  %>
<%@page import="model.MyDatabase"  %>
<%
     try{ 
           MyDatabase.getDatabase();    
           out.print("Conex?o ok: ");
           out.print(MyDatabase.getDatabase().getCatalog());
    } catch(SQLException | ClassNotFoundException e){
            out.print("Falha na conex?o:  " + e);
    }

%>