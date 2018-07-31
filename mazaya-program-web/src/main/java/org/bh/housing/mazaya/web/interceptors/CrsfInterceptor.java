package org.bh.housing.mazaya.web.interceptors;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Loay
 *
 */
@Component
public class CrsfInterceptor extends HandlerInterceptorAdapter {

        @Override
        public void postHandle(final HttpServletRequest request,
                               final HttpServletResponse response,
                               final Object handler,
                               final ModelAndView modelAndView) throws Exception {

                if (modelAndView != null) {
                        CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
                        if (csrfToken != null) {
                                modelAndView.addObject("_csrf", csrfToken);
                        }
                }
        }
}
