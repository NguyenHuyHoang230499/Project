<%-- 
    Document   : login
    Created on : Apr 26, 2022, 10:12:14 PM
    Author     : senan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <div>
        <form action="login" method="POST">
            Login Id:<input type="text" name="id"/></br>
            Password:<input type="password" name="pass"></br>
            <input type="radio" name="authen" value="parent"/>As a parent</br>
            <input type="radio" name="authen" value="teacher"/>As a teacher</br>
            <input type="radio" name="authen" value="staff"/>As a staff</br>
            <input type="submit" value="Login"/>
        </form>
            </div>
    </body>
</html>
