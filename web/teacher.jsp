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
        <title>Teacher Page</title>
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
                <h2><a href="teacher?tid=${requestScope.CTeacher}&cid=${tc.getClassId()}">${tc.getClassName()}</a></h2></br>
            </c:forEach>
        </div>
        <div>
            <c:set value="${requestScope.students}" var="students"/>
            <c:if test="${students!=null}">
                <h2>Class detail:</h2></br>
                <form action="teacher" method="POST">
                    <input type="hidden" name="cid" value="${requestScope.CClass}"/>
                    <input type="hidden" name="tid" value="${requestScope.CTeacher}">
                    <table border="1px" >
                    <tr>
                        <td>Student</td>
                        <td>Small test</td>
                        <td>Middle test</td>
                        <td>Final test</td>
                    </tr>
                    <c:forEach items="${students}" var="s">
                        <tr>
                            <td><a href="teacher?tid=${requestScope.CTeacher}&cid=${requestScope.CClass}&sid=${s.getStudentId()}">${s.getStudentName()}</td>
                            <td><input type="text" name="${s.getStudentId()}" value="${s.getStudentMark().getSmalTest()}"></td>
                            <td><input type="text" name="${s.getStudentId()}" value="${s.getStudentMark().getMidTest()}"></td>
                            <td><input type="text" name="${s.getStudentId()}" value="${s.getStudentMark().getFinalTest()}"></td>
                        </tr>
                </c:forEach>
                </table>
                    <input type="submit" value="Update grade"/>
                </form>
                <div>
                    <c:set value="${requestScope.CParent}" var="p"/>
                    <c:if test="${p!=null}">
                        <h2>Parent detail:</h2>
                        <h3>Parent name:${p.getParentName()}</h3>
                        <c:if test="${p.isParentSex()==true}">
                <h3> Parent sex:Male</h3>
            </c:if>
                <c:if test="${p.isParentSex()!=true}">
                <h3> Parent sex:Female</h3>
            </c:if>
                <h3>Parent phone number :${p.getParentPhone()}</h3>
                <h3>Parent Address:${p.getParentAddress()}</h3>
                    </c:if>
                </div>
            </c:if>
        </div>
        
            
    </body>
</html>
