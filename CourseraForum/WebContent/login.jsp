<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina Principal</title>
</head>
<body>
<form action="../login" method="post" class="login" >
    <center>
	<br>
        <table style="background-color: lightgray; margin-left: 20px; margin-right: 20px;">
            <tr><td><h3 style=" color: red;">${mensagem}</h3>
                    <h3 style=" color: green;">${mensagemsucesso}</h3>
                </td>
            <td></td>
            </tr>
            <tr>
        <td><h2 style="color: navy">Deseja fazer um login ou se cadastrar</h2></td>
        </tr>
        <tr><td>Login:<input type="text" name="login" placeholder ="Login"/></td></tr>
		<tr><td>Senha:<input type="password" name="senha" placeholder= "Senha"/></td></tr>
        <tr><td><input type="submit" value="Login"/></td>
        <tr><td><a href="<c:url value='/cadastro' />" class="pull-left">Cadastrar-se</a></td></tr>
        </table>
    </form>
    </center>
</body>
</html>