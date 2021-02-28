import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Recipe;
import util.UtilDBGallagher;

@WebServlet("/MyServletHibernateDBGallagher")
public class MyServletHibernateDBGallagher extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public MyServletHibernateDBGallagher() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");

      // #1
      UtilDBGallagher.createEmployees("Primo_cousin", "42", "4027130101");
      UtilDBGallagher.createEmployees("Mera_mera", "33", "4027132020");
      
      // #2
      retrieveDisplayData(response.getWriter());
   }

   void retrieveDisplayData(PrintWriter out) {
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
            "transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");
      List<Recipe> listEmployees = UtilDBGallagher.listEmployees();
      for (Recipe recipe : listEmployees) {
         System.out.println("[DBG] " + recipe.getId() + ", " //
               + recipe.getName() + ", " //
               + recipe.getAge() + ", " //
               + recipe.getPhone());

         out.println("<li>" + recipe.getId() + ", " //
               + recipe.getName() + ", " //
               + recipe.getAge() + ", " //
               + recipe.getPhone() + "</li>");
      }
      out.println("</ul>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
