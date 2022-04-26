/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAL.TeacherDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Parent;
import model.Student;
import model.StudentMark;
import model.Teacher;

/**
 *
 * @author senan
 */
public class teacher extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try ( PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet teacher</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet teacher at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         TeacherDAO tdao = new TeacherDAO();
        int tid;
        try{
           tid  = Integer.parseInt(request.getParameter("tid"));
        }
        catch( Exception ex){
             tid=-1;
        }
        int cid;
        try{
            cid = Integer.parseInt(request.getParameter("cid"));
        }
        catch( Exception ex){
             cid=0;
        }
        int sid;
        try{
            sid = Integer.parseInt(request.getParameter("sid"));
        }
        catch( Exception ex){
             sid=0;
        }
        Teacher teacher = tdao.getTeacher(tid);
        request.setAttribute("teacher", teacher);
        Parent CParent = new Parent();
        CParent = null;
        ArrayList<Student> students = tdao.getStudentsByClass(cid);
        for (Student s : students) {
            StudentMark sm = tdao.getStudentMark(s.StudentId,teacher.getSubject() );
            s.setStudentMark(sm);
            if(s.getStudentId()==sid){
                CParent = s.getStudentParent();
            }
        }
        request.setAttribute("CParent", CParent);
        request.setAttribute("students", students);
        request.setAttribute("CTeacher", tid);
        request.setAttribute("CClass", cid);
        request.setAttribute("CStudent", sid);
        request.getRequestDispatcher("teacher.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cid = Integer.parseInt(request.getParameter("cid"));
        int tid = Integer.parseInt(request.getParameter("tid"));
         TeacherDAO tdao = new TeacherDAO();
         Teacher t = tdao.getTeacher(tid);
         ArrayList<Student> students = tdao.getStudentsByClass(cid);
         for (Student s : students) {
             String get = String.valueOf(s.getStudentId());
            String[] values = request.getParameterValues(get);
             try{
                 int check = tdao.UpdateStudentMark(s.getStudentId(), Integer.parseInt(values[0]), Integer.parseInt(values[1]), Integer.parseInt(values[2]),t.getSubject() );
                 if(check == 0){
                     PrintWriter out = response.getWriter();
                 out.print("Update fail!");
                 return;
                 }
             }
             catch(Exception ex){
                 PrintWriter out = response.getWriter();
                 out.print("Update fail!");
                 return;
             }
        }
        PrintWriter out = response.getWriter();
                 out.print("Update success!");
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
