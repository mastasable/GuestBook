package com.guestbook;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;


/**
 * Created by admin on 22.03.2015.
 */
public class Servlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         try {
             boolean isMultipart = ServletFileUpload.isMultipartContent(req);
             String name = null;
             String commentary = null;
             String url = null;
             if(isMultipart){
                 DiskFileItemFactory factory = new DiskFileItemFactory();
                 ServletContext servletContext = this.getServletConfig().getServletContext();
                 File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
                 factory.setRepository(repository);
                 ServletFileUpload upload = new ServletFileUpload(factory);
                 List<FileItem> items = upload.parseRequest(req);
                 Iterator<FileItem> iterator = items.iterator();
                 while (iterator.hasNext()){
                     FileItem item = iterator.next();
                     if(item.isFormField()){
                         if(item.getFieldName().equals("name")){
                             name = item.getString();
                             System.out.print(name);
                         }
                         if(item.getFieldName().equals("commentary")){
                             commentary = item.getString();
                             System.out.print(commentary);
                         }
                     } else {
                         String fileName = item.getName();
//                         String root = getServletContext().getRealPath("/");
                         File path = new File("C:\\Users\\admin\\IdeaProjects\\GuestBook\\web\\upload");
                         if (!path.exists()){
                             boolean status = path.mkdirs();
                         }

                         File uploadedFile = new File(path + "/" + fileName);
                         url = "/upload/" + fileName;
                         item.write(uploadedFile);
                     }

                 }
             PostModel.addPosts(name, commentary, url);

             }
         } catch (FileUploadException e) {
             e.printStackTrace();
         } catch (Exception e) {
             e.printStackTrace();
         }
    }

    protected void processFileField(){

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("posts", PostModel.getPosts());
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
