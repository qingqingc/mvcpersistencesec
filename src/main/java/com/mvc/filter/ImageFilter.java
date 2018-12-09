package com.mvc.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImageFilter implements Filter {
	private final static Logger log = LoggerFactory.getLogger(ImageFilter.class);

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		request.getSession().setAttribute("invalideCode", null);
		String yanzhengm = request.getParameter("j_captcha");
		String sessionyanz = (String) request.getSession(true).getAttribute("yzkeyword");
		log.info("request validate code is|" + yanzhengm + "session validate code is|" + sessionyanz);
		if ((yanzhengm != null) && (sessionyanz != null) && yanzhengm.equals(sessionyanz)) {
			log.info("Validate photo code is valid!");
			arg2.doFilter(request, response);
		} else {
			log.info("Validate photo code is invalid!");
			request.getSession().setAttribute("invalideCode", "Invalidate photo code,please reenter in once again!");
			response.sendRedirect(request.getContextPath() + "/logink");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}