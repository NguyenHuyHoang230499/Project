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
        <title>Staff Page</title>
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
            <h1>Teacher info:</h1>
            <form>
                <input type="hidden" name="id" value="${s.getStaffId()}">
                <select name="tid" onchange="this.form.submit()">
                    <c:forEach items="${requestScope.teachers}" var="t">
                        <option value="${t.getTeacherId()}" <c:if test="${t.getTeacherId()==requestScope.tid}">
                                selected
                            </c:if>>${t.getTeacherName()}</option>
                    </c:forEach>
                </select>
            </form>
            <c:set value="${requestScope.teacher}" var="teacher"/>
            <c:if test="${teacher!=null}">
                <form action="staff" method="POST">
                    <input type="hidden" name="check" value="teacher"/>
                    <input type="hidden" name="TId" value="${teacher.getTeacherId()}">
                    Name:<input type="text" name="TName" value="${teacher.getTeacherName()}"/></br>
                    Sex:<input type="radio" name="TSex" <c:if test="${teacher.isTeacherSex()==true}">
                               checked="checked"
                        </c:if> value="true">Male
                    <input type="radio" name="TSex" <c:if test="${teacher.isTeacherSex()!=true}">
                           checked="checked"
                        </c:if> value="false">Female</br>
                    Phone number:<input type="text" name="TPhone" value="${teacher.getTeacherPhone()}"/></br>
                    Address:<input type="text" name="TAddress" value="${teacher.getTeacherAddress()}"/></br>
                    Current subject:${teacher.getSubject()}</br>
                    <input type="hidden" name="TSubject" value="${teacher.getSubject()}">
                    <input type="submit" value="Update teacher info"/>
                </form>
            </c:if>
        </div>
        <div>
            <h1>Parent info:</h1>
            <form>
                <input type="hidden" name="id" value="${s.getStaffId()}">
                <select name="pid" onchange="this.form.submit()">
                    <c:forEach items="${requestScope.parents}" var="p">
                        <option value="${p.getParentId()}" <c:if test="${p.getParentId()==requestScope.pid}">
                                selected
                            </c:if>>${p.getParentName()}</option>
                    </c:forEach>
                </select>
            </form>
            <c:set value="${requestScope.parent}" var="p"/>
            <c:if test="${p!= null}">
                <form action="staff" method="POST">
                    <input type="hidden" name="check" value="parent"/>
                    <input type="hidden" name="PId" value="${p.getParentId()}"/>
                    Name:<input type="text" name="PName" value="${p.getParentName()}"/></br>
                    Sex:<input type="radio" name="PSex" value="true" 
                               <c:if test="${p.isParentSex()==true}">
                                   checked="checked"
                               </c:if>/>Male
                    <input type="radio" name="PSex" value="false" 
                           <c:if test="${p.isParentSex()==false}">
                               checked="checked"
                           </c:if>/>Female</br>
                    Phone number:<input type="text" name="PPhone" value="${p.getParentPhone()}"/></br>
                    Address:<input type="text" name="PAddress" value="${p.getParentAddress()}"/></br>
                    <input type="submit" value="Update parent info"/>
                </form>
            </c:if>
        </div>
        <div>
            <h1>Student info:</h1>
            <form>
                <input type="hidden" name="id" value="${s.getStaffId()}">
                <select name="sid" onchange="this.form.submit()">
                    <c:forEach items="${requestScope.students}" var="student">
                        <option value="${student.getStudentId()}" <c:if test="${student.getStudentId()==requestScope.sid}">
                                selected
                            </c:if>>${student.getStudentName()}</option>
                    </c:forEach>
                </select>
            </form>
            <c:set value="${requestScope.student}" var="student"/>
            <c:if test="${student!= null}">
                <form action="staff" method="POST">
                    <input type="hidden" name="check" value="student"/>
                    <input type="hidden" name="SId" value="${student.getStudentId()}"/>
                    Name:<input type="text" name="SName" value="${student.getStudentName()}"/></br>
                    Sex:<input type="radio" name="SSex" value="true" 
                               <c:if test="${student.isStudentSex()==true}">
                                   checked="checked"
                               </c:if>/>Male
                    <input type="radio" name="SSex" value="false" 
                           <c:if test="${student.isStudentSex()==false}">
                               checked="checked"
                           </c:if>/>Female</br>
                    Birth date:<input type="text" name="SDate" value="${student.getStudentDate()}"/></br>
                    <input type="submit" value="Update student info"/>
                </form>
            </c:if>
        </div>

    </body>
</html>
