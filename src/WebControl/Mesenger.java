package WebControl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ChatControl;
import model.Message;

/*
 * Servlet responsável por enviar a mensagem
 * Chamado como Restfull
 * @params idChat {int}
 * @params from {int}
 * @params message {String}
 * @returns {1 or 0}
 * */
@WebServlet(name = "messenger", urlPatterns = {"/messenger"})
public class Mesenger extends HttpServlet {
	 @Override
	 protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 PrintWriter out = resp.getWriter();
		 ChatControl chatControl = new ChatControl();
		 Message message = new Message();
			try{
		
				 String idChat = req.getParameter("idChat");
				 int from = Integer.parseInt(req.getParameter("from"));
				 
				 message.setMessage(req.getParameter("message"));
				 message.setSender(from);
				 
				 
				 if(chatControl.sendMessageTo(Integer.parseInt(idChat),message))
					 out.println("1");
				 else 
					 out.println("0");
				 
			 }catch (Exception e) {
				 out.println("0");
			 }
	 }
}
