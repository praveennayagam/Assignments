package com.mphasis;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AysncServlet
 */
@WebServlet(urlPatterns="/AysncServlet", asyncSupported = true)
public class AysncServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AysncServlet() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	private static final ExecutorService executor=Executors.newSingleThreadExecutor();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getState());
		AsyncContext ac=request.startAsync();
		
	
		executor.submit(()->{
			
			try {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getState());
				String uname=request.getParameter("uname");
				String pwd=request.getParameter("pwd");
				if(uname.equals("praveen")&& pwd.equals("12345"))
					response.getWriter().println("Authenticated successfully,Async OK");
				else
					response.getWriter().println("Ivalid Credentials,Async FAILED");
					
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			finally {
				ac.complete();
			}
		});
	}

}
