package spring.coupon.system.project.couponsystemspring.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import spring.coupon.system.project.couponsystemspring.constants.PageNames;
import spring.coupon.system.project.couponsystemspring.entinies.Client;

@WebFilter(PageNames.SEC_AREA + "/*")
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession(false);
		if (session == null) {
			System.out.println("No active session. Access denying.");
			this.redirectToLogin(response, request);
			return;
		}
		Client client = (Client) session.getAttribute("client");
		if (client == null) {
			System.out.println("No logged in user. Access denying.");
			this.redirectToLogin(response, request);
			return;
		}

		chain.doFilter(request, response);
	}// doFilter

	private void redirectToLogin(ServletResponse response, ServletRequest request) throws IOException {
		((HttpServletResponse) response).sendRedirect(request.getServletContext().getContextPath() + PageNames.LOGIN);
	}
}// Filter
