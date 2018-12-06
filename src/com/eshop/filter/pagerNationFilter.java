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
        //�������У���ȡrequest�еķ�ҳ������д��systemContext�У�
		//���̴�Խʱ���������
		
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		
		try {
			//�������У���ȡrequest�еķ�ҳ������д��systemContext�У�
			int offset=req.getParameter("pager.offset")==null?0:Integer.parseInt(req.getParameter("pager.offset"));
			systemContext.setOffSet(offset);
			
			//��ȡ��������ʼ���������趨��pageSize
			int pageSize=req.getParameter("pageSize")==null?6:Integer.parseInt(req.getParameter("pageSize"));
			systemContext.setPageSize(pageSize);

			chain.doFilter(request, response);
		}catch(Exception e) {
			
		}finally {
			//���̴�Խʱ���������
			systemContext.removeoffSet();
			systemContext.removePageSize();
			
		}
		
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
