package com.mysite.core.servlets;



import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;




//OSGI Declarative Service Annotation
//@Component(
//        service=Servlet.class,
//        property={
//                "sling.servlet.paths="+ "/bin/trainingproject/testservlet"
//        }
//)

@Component(
        service=Servlet.class,
        property={
                "sling.servlet.resourceTypes="+ "trainingfolder/components/structure/contentpage",
                "sling.servlet.selectors=" + "sample"
        }
)

public class TestSlingServlet extends SlingSafeMethodsServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Type", "text/html");
        response.getWriter().print("<h1>Sling Servlet Called</h1>");
        response.getWriter().close();
    }
}
