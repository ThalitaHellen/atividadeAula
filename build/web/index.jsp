<%
    if(session.getAttribute("userLoggedSession")!= null){
        response.sendRedirect("home.jsp");
    }

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
        <title>discoteca virtual</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            <link href="https://fonts.googleapis.com/css2?family=Dosis:wght@200&display=swap" rel="stylesheet">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style.css"/>
        <link rel="icon" href="img/icon.png"/>
    </head>
    <body>
        <form action="Login" method="post" id="form-login">
            <img src="img/coruja.jpg" alt="logotipo de coruja branca" width="200" />
            <br>
            <input type="email" name="user" class= "fields" id="user" placeholder="Email" required>
            <br><br>
            <input type="password" name="pass" class= "fields" id="pass" placeholder="Senha" required>
            <br><br>
            <input type="submit" value="Entrar">
        </form>
    </body>
</html>