/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAL.ParentDAO;
import DAL.StaffDAO;
import DAL.TeacherDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import model.Parent;
import model.Staff;
import model.Student;
import model.Teacher;

/**
 *
 * @author senan
 */
public class staff extends HttpServlet {

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
//            out.println("<title>Servlet staff</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet staff at " + request.getContextPath() + "</h1>");
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
        
       StaffDAO sdao = new StaffDAO();
       TeacherDAO tdao = new TeacherDAO();
       ParentDAO pdao = new ParentDAO();
        int id,tid,pid,sid;
       try{
           id=Integer.parseInt(request.getParameter("id"));
       }
       catch(Exception exception){
           id=0;
       }
       try{
           tid=Integer.parseInt(request.getParameter("tid"));
                  Teacher teacher = tdao.getTeacher(tid);
       request.setAttribute("teacher", teacher);
       request.setAttribute("tid", tid);
       }
       catch(Exception ex){
           tid = 0;
       }
       try{
           pid=Integer.parseInt(request.getParameter("pid"));
           Parent parent = pdao.getParent(pid);
           request.setAttribute("parent", parent);
           request.setAttribute("pid", pid);
       }
       catch (Exception ex){
           pid=0;
       }
       try{
           sid=Integer.parseInt(request.getParameter("sid"));
           Student student = sdao.getStudent(sid);
           request.setAttribute("student", student);
           request.setAttribute("sid", sid);
       }
       catch(Exception ex){
           sid =0;
       }
       Staff staff =sdao.getStaff(id);
       ArrayList<Teacher> teachers =sdao.getAllTeacher();
       ArrayList<Parent> parents = sdao.getAllParent();
       ArrayList<Student> students = sdao.getAllStudents();
       request.setAttribute("students", students);
       request.setAttribute("parents", parents);
       request.setAttribute("teachers", teachers);
       request.setAttribute("staff", staff);
       request.getRequestDispatcher("staff.jsp").forward(request, response);
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
        PrintWriter out = response.getWriter();
        StaffDAO sdao = new StaffDAO();
        String check = request.getParameter("check");
        if(check.equals("teacher")){
            try{
                Teacher t = new Teacher();
                t.setTeacherId(Integer.parseInt(request.getParameter("TId")));
                t.setTeacherName(request.getParameter("TName"));
                if(request.getParameter("TSex").equals("true")){
                    t.setTeacherSex(true);
                }
                else t.setTeacherSex(false);
                t.setTeacherPhone(request.getParameter("TPhone"));
                t.setTeacherAddress(request.getParameter("TAddress"));
                t.setSubject(request.getParameter("TSubject"));
                int up = sdao.UpdateTeacher(t);
                if(up==1){
                    out.println("Update successful"); return;
                }
                else out.print("Update fail!"); return;
            }
            catch(Exception ex){
               out.print("Update fail!");
               return;
            }
        }
        if(check.equals("parent")){
            try{
                Parent p = new Parent();
                p.setParentId(Integer.parseInt(request.getParameter("PId")));
                p.setParentName(request.getParameter("PName"));
                if(request.getParameter("PSex").equals("true")){
                    p.setParentSex(true);
                }else p.setParentSex(false);
                p.setParentPhone(request.getParameter("PPhone"));
                p.setParentAddress(request.getParameter("PAddress"));
                int up = sdao.UpdateParent(p);
                if(up==1){
                    out.println("Update successful"); return;
                }
                else out.print("Update fail!"); return;
            }
            catch(Exception ex){
               out.print("Update fail!");
               return;
            }
        }
        if(check.equals("student")){
            try{
                Student s = new Student();
                s.setStudentId(Integer.parseInt(request.getParameter("SId")));
                s.setStudentName(request.getParameter("SName"));
                if(request.getParameter("SSex").equals("true")){
                    s.setStudentSex(true);
                }
                else{
                    s.setStudentSex(false);
                }
                s.setStudentDate(Date.valueOf(request.getParameter("SDate")));
                int up = sdao.UpdateStudent(s);
                if(up==1){
                    out.println("Update successful"); return;
                }
                else out.print("Update fail!"); return;
            }
            catch(Exception ex){
               out.print("Update fail!");
               return;
            }
        }
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
