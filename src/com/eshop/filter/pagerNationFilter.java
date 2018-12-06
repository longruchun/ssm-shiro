package com.eshop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshop.util.systemContext;

public class pagerNationFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
        //过滤器中，读取request中的分页参数，写入systemContext中，
		//反程穿越时，又清除掉
		
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		
		try {
			//过滤器中，读取request中的分页参数，写入systemContext中，
			int offset=req.getParameter("pager.offset")==null?0:Integer.parseInt(req.getParameter("pager.offset"));
			systemContext.setOffSet(offset);
			
			//读取过滤器初始化参数中设定的pageSize
			int pageSize=req.getParameter("pageSize")==null?6:Integer.parseInt(req.getParameter("pageSize"));
			systemContext.setPageSize(pageSize);

			chain.doFilter(request, response);
		}catch(Exception e) {
			
		}finally {
			//反程穿越时，又清除掉
			systemContext.removeoffSet();
			systemContext.removePageSize();
			
		}
		
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
