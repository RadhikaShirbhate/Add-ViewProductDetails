package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/add")
public class AddProductServlet extends GenericServlet{
	
	@Override
	public void init()throws ServletException{
		
	}
	@Override
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		String pC=req.getParameter("code");
		String pN=req.getParameter("name");
		float pP=Float.parseFloat(req.getParameter("price"));
		int pQ=Integer.parseInt(req.getParameter("qty"));
		
		ProductBean pb=new ProductBean();
		
		pb.setpCode(pC);
		pb.setpName(pN);
		pb.setpPrice(pP);
		pb.setpQty(pQ);
		
		int k=new AddProductDAO().insert(pb);
		if(k>0) {
			pw.println("Product added Successfully...<br>");
			RequestDispatcher rd=req.getRequestDispatcher("home.html");
			rd.include(req, res);
		}
	}
	@Override
	public void destroy() {
		
	}
}
