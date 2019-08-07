<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro</title>
</head>
<body>
    <center>
        <form  action="../cadastro" method="post" class= "cadastro">
            <table style="background-color: azure; margin-left:20px; margin-right: 20px" >
            <tr><td><h3 style=" color: red;">${info}</h3>
                </td>
            <td></td>
            </tr>
                <tr>
                <td><h1>Página de Cadastro</h1></td>
                </tr>
            <tr><td>Login</td><td><input type="text" name="login"></td></tr>
            <tr><td>Email</td><td><input type="text" name="email"></td></tr>
            <tr><td>Nome </td><td><input type="text" name="nome"></td></tr>
            <tr><td>Senha</td><td><input type="text" name="senha"></td></tr>
            <tr><td><input type="submit" value="cadastrar"></td></tr>
            </table>
        </form>
    </center>
</body>
</html>