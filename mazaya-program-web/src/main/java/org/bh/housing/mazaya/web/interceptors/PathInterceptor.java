package org.bh.housing.mazaya.web.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tim.schwalbe
 */
@Component
public class PathInterceptor extends HandlerInterceptorAdapter {

        private static final Logger logger = LoggerFactory.getLogger(PathInterceptor.class.getName());

        @Override
        public void postHandle(final HttpServletRequest request,
                               final HttpServletResponse response,
                               final Object handler,
                               final ModelAndView modelAndView) throws Exception {

                if (modelAndView != null && !modelAndView.getViewName().startsWith("redirect:")) {
                        modelAndView.addObject("currentPath", request.getServletPath());
                }
        }
}
