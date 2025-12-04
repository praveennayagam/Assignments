package com.mphasis;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/AsyncFileProcessor", asyncSupported = true)
public class AsyncFileProcessor extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final ExecutorService executorPool = Executors.newFixedThreadPool(3);

    @Override
    public void destroy() {
        executorPool.shutdown();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState());

        AsyncContext ac = request.startAsync();
        String str = request.getParameter("inputText");

        executorPool.submit(() -> {
            try {
                // Submit tasks
                Future<String> uppercaseTask = executorPool.submit(() -> {
                    Thread.sleep(2000);
                    return "Uppercase: " + str.toUpperCase() + 
                           " (Thread: " + Thread.currentThread().getName() + ")";
                });

                Future<String> reverseTask = executorPool.submit(() ->
                    "Reverse: " + new StringBuilder(str).reverse() + 
                    " (Thread: " + Thread.currentThread().getName() + ")"
                );

                Future<String> charCountTask = executorPool.submit(() ->
                    "Char count: " + str.length() + 
                    " (Thread: " + Thread.currentThread().getName() + ")"
                );

                // Collect results
                String result1 = uppercaseTask.get();
                String result2 = reverseTask.get();
                String result3 = charCountTask.get();

                // Write response
                HttpServletResponse asyncResp = (HttpServletResponse) ac.getResponse();
                asyncResp.setContentType("text/plain");
                PrintWriter out = asyncResp.getWriter();
                out.println(result1);
                out.println(result2);
                out.println(result3);
                out.flush();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ac.complete(); // Always complete async context
            }
        });
    }
}
