<%-- 
    Document   : teacher
    Created on : Apr 25, 2022, 5:32:31 PM
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
        <c:set value="${requestScope.teacher}" var="t"/>
        <div>
            <h1>Your infomation:</h1>
            <h3>Name:${t.getTeacherName()}</h3>
            <c:if test="${t.isTeacherSex()==true}">
                <h3>Sex:Male</h3>
            </c:if>
                <c:if test="${t.isTeacherSex()!=true}">
                <h3>Sex:Female</h3>
            </c:if>
                <h3>Phone number:${t.getTeacherPhone()}</h3>
                <h3>Address:${t.getTeacherAddress()}</h3>
                <h3>currently teaching:${t.getSubject()}</h3>
        </div>
        <div>
            <h1>Classes you are teaching:</h1>
            <c:forEach items="${t.getTeacherClasses()}" var="tc">
                <a href="teacher?tid=1&cid=${tc.getClassId()}">${tc.getClassName()}</a></br>
            </c:forEach>
        </div>
        <div>
            <c:set value="${requestScope.students}" var="students"/>
            <c:if test="${students!=null}">
                Students in class ${tc.getClassName()}:
                <c:forEach items="${students}" var="s">
                    ${s.getStudentName()}</br>
                </c:forEach>
            </c:if>
        </div>
        
            
    </body>
</html>
