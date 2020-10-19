/**
 * @author Gilyazov Marat
 * 11-905
 */

package controllers.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebFilter(urlPatterns = "/like", filterName = "likedFilter")
public class LikedFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(servletRequest.getParameterMap());

//        filterChain.doFilter(servletRequest, servletResponse);
    }
}
