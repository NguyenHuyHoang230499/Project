<%-- 
    Document   : parent
    Created on : Apr 25, 2022, 10:52:54 AM
    Author     : senan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,model.Student,model.Parent"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set value="${requestScope.parent}" var="p"/>
        <div>
            <h1>Parent infomation</h1>
            <h2>Name:${p.getParentName()}</h2>
            <c:if test="${p.isParentSex() == true}">
                <h2>Sex:Male</h2>
            </c:if>
                <c:if test="${p.isParentSex() != true}">
                <h2>Sex:Female</h2>
            </c:if>
                <h2>Phone number:${p.getParentPhone()}</h2>
                <h2>Address :${p.getParentAddress()}</h2>
        </div>
        <h2>Click to see your childrens information:</h2>
        <div>
            <c:forEach items="${p.getStudents()}" var="ps">
                <a href="parent?pid=${p.getParentId()}&sid=${ps.getStudentId()}">${ps.getStudentName()}</a></br>
            </c:forEach>
        </div>
        <div>
            <c:set value="${requestScope.student}" var="s"/>
                <c:if test="${s!=null}">
                  <h3>Student name: ${s.getStudentName()}</h3>
                  <c:if test="${s.isStudentSex() == true}">
                <h3>Sex:Male</h3>
            </c:if>
            <c:if test="${s.isStudentSex() != true}">
                <h3>Sex:Female</h3>
                </c:if>
                <h3>Birth date:${s.getStudentDate()}</h3>
                <h3>Learning in class ${s.getStudentClass().getClassName()}</h3>
                </c:if>
        </div>
                <div>
                    <c:if test="${s!=null}">
                        <h2>Grade report:</h2>
                            <table border="1px">
                                <tr>
                                    <td>Subject</td>
                                    <td>Small test</td>
                                    <td>Middle test</td>
                                    <td>Final test</td>
                                </tr>
                                <c:forEach items="${s.getStudentMarks()}" var="sm">
                                    <tr>
                                    <td>${sm.getSubject()}</td>
                                    <td>${sm.getSmalTest()}</td>
                                    <td>${sm.getMidTest()}</td>
                                    <td>${sm.getFinalTest()}</td>
                                </tr>
                                </c:forEach>
                            </table>  
                    </c:if>
                </div>
    </body>
</html>
