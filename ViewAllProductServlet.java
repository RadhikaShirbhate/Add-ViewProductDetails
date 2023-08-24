package test;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewAllProductsServlet extends GenericServlet 
{
	@Override
	public void init() throws ServletException{
		
	}
	@Override
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		ArrayList<ProductBean > al=new ViewAllProductsDAO().retrieve();
		if(al.size()==0) {
			pw.println("products Not Available....<br>");
			
		}else {
			pw.println("========ProductDetails=========<br>");
			Iterator<ProductBean> it=al.iterator();
			while(it.hasNext()) {
				ProductBean pb =(ProductBean)it.next();
				pw.println(pb.getpCode()+"&nbsp&nbsp"
						+pb.getpName()+"&nbsp&nbsp"
						+pb.getpPrice()+"&nbsp&nbsp"
						+pb.getpQty()+"<br>");
			}
		}
		pw.println("<a href='home.html'>home</a>");
	}
	@Override
	public void destroy() {
		
	}

}
