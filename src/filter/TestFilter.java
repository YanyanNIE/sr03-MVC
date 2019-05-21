package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TestFilter implements Filter {
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("First Filter------Init");
	}
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		System.out.println("First Filter------doFilter start");
 
		chain.doFilter(request, response);
		
		System.out.println("First Filter------doFilter end");
	}
 
	public void destroy() {
		System.out.println("First Filter------Destory");
	}

}
