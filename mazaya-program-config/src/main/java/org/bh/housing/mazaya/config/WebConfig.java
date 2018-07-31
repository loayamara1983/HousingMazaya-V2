package org.bh.housing.mazaya.config;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;

import org.primefaces.webapp.filter.FileUploadFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Loay
 *
 */
@Configuration
public class WebConfig {

	@Bean
    public ServletRegistrationBean facesServletRegistraiton() {
            ServletRegistrationBean registration = new ServletRegistrationBean(new FacesServlet(), new String[]{"*.xhtml"});
            registration.setName("Faces Servlet");
            registration.setLoadOnStartup(1);
            return registration;
    }


    @Bean
    public FilterRegistrationBean facesUploadFilterRegistration() {
            FilterRegistrationBean registrationBean = new FilterRegistrationBean(new FileUploadFilter(), facesServletRegistraiton());
            registrationBean.setName("PrimeFaces FileUpload Filter");
            registrationBean.addUrlPatterns("/*");
            registrationBean.setDispatcherTypes(DispatcherType.FORWARD, DispatcherType.ERROR);
            return registrationBean;
    }

    @Bean
    public ServletContextInitializer servletContextInitializer() {
            return servletContext -> {
                    servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
                    servletContext.setInitParameter("primefaces.THEME", "bootstrap");
                    servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", Boolean.TRUE.toString());
                    servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", Boolean.TRUE.toString());
                    servletContext.setInitParameter("primefaces.FONT_AWESOME", Boolean.TRUE.toString());
                    servletContext.setInitParameter("primefaces.UPLOADER", "commons");
            };
    }
}
