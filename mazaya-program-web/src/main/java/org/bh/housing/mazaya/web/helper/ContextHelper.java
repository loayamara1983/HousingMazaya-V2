package org.bh.housing.mazaya.web.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;

/**
 * 
 * @author Loay
 *
 */

@Component
public class ContextHelper {

        @Autowired
        ServletContext servletContext;

        @Override
        public String toString() {
                return servletContext.getContextPath();
        }
}
