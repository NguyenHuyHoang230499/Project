<%-- 
    Document   : staff
    Created on : Apr 26, 2022, 5:12:20 PM
    Author     : senan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set value="${requestScope.staff}" var="s"/>
        <div>
            <h1>Your information:</h1>
            <h2>Staff name: ${s.getStaffName()}</h2>
            <c:if test="${s.isStaffSex() == true}">
                <h2>Sex:Male</h2>
            </c:if>
                <c:if test="${s.isStaffSex() == false}">
                <h2>Sex:Female</h2>
            </c:if>
                <h2>Current position:${s.getStaffPosition()}</h2>
                <h2>Phone number: ${s.getStaffPhone()}</h2>
        </div>
        <div>
            <form>
                
            </form>
        </div>
    </body>
</html>
