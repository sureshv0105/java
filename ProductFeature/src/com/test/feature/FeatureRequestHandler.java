package com.test.feature;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.feature.config.Config;
import com.test.feature.email.EmailUtil;

public class FeatureRequestHandler extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml");
		PrintWriter out = response.getWriter();
		
		try {
			//out.println("Hello World!!");
			//out.println("Response from Feature Request Handler");
			
			String emailRecipient = Config.getInstance().getPropertyValue("mail.smtp.email.recipient");
			System.out.println("********************************Start");
			String fromEmail = request.getParameter("FromEmailAddress");
			String featureDesc = request.getParameter("ProductFeatureDescription");
			System.out.println("From Email Address " + fromEmail);
			System.out.println("Product Feature Description: " + featureDesc);
			
			
			System.out.println("Sending email of product feature");
			EmailUtil.sendEmail(emailRecipient, fromEmail, "Feature Suggestion", featureDesc);
			
			System.out.println("********************************end");
			ServletContext sc = getServletContext();
			sc.getRequestDispatcher("/results.html").forward(request, response);			
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}finally {
			out.close();
		}
	}
}
