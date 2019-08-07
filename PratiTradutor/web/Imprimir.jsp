<%-- 
Nome do Programa Tradutor
Nome: Victor Propheta Erbano
data: 19/07/19
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Palavra traduzida</title>
    </head>
    <body>
        <br/><br/>
        <h1>A palavra traduzida ${param.palavra} do portugues para o inglês</h1>
        <br/><br/>
        <h1>${traduzir}</h1>
    </body>
</html>
