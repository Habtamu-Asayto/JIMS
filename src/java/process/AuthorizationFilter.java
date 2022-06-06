//
// package process;
//
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//@WebFilter(filterName = "AuthFilter", urlPatterns = { "*.html" })
//public class AuthorizationFilter implements Filter {
//    private static final String AJAX_REDIRECT_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
//        + "<partial-response><redirect url=\"%s\"></redirect></partial-response>";
//
//	public AuthorizationFilter() {
//	}
//
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//
//	}
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response,
//			FilterChain chain) throws IOException, ServletException {
//		try {
//
//			HttpServletRequest reqt = (HttpServletRequest) request;
//			HttpServletResponse resp = (HttpServletResponse) response;
//			HttpSession ses = reqt.getSession(false);
//                         boolean ajaxRequest = "partial/ajax".equals(reqt.getHeader("Faces-Request"));
//			String reqURI = reqt.getRequestURI();
//              
//                        
//                        
//                        
//			if (reqURI.indexOf("/login.xhtml") >= 0
//					|| (ses != null && ses.getAttribute("user") != null)
//					|| reqURI.indexOf("/public/") >= 0
//                                        || reqURI.indexOf("/basic/") >= 0
//                                        || reqURI.indexOf("/changepassword.xhtml") >= 0
//                                         || reqURI.indexOf("/home.xhtml") >= 0
//                                         || reqURI.indexOf("/confirmpasswordchange.xhtml") >= 0
//                                          || reqURI.contains("javax.faces.resource"))
//                            
//                            
//				chain.doFilter(request, response);
//                          else if (ajaxRequest) {
//            response.setContentType("text/xml");
//            response.setCharacterEncoding("UTF-8");
//            response.getWriter().printf(AJAX_REDIRECT_XML, "/faces/login.xhtml"); // So, return special XML response instructing JSF ajax to send a redirect.
//        }
//			else
//				resp.sendRedirect(reqt.getContextPath() + "/faces/login.xhtml");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
//
//	@Override
//	public void destroy() {
//
//	}
//} 