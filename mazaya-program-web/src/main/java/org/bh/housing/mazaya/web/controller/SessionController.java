package org.bh.housing.mazaya.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bh.housing.mazaya.security.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author tim.schwalbe
 * @author osca
 */
@Controller
public class SessionController {

        Logger logger = LoggerFactory.getLogger(SessionController.class);
        
        @Autowired
        ProfileService profileService;

        @RequestMapping(value = "", method = RequestMethod.GET)
        public ModelAndView index() {

                System.out.println("index page requested");

                return new ModelAndView("index.xhtml");
        }

        @RequestMapping(value = "/login", method = RequestMethod.GET)
        public ModelAndView loginPage() {

                System.out.println("login page requested");

                return new ModelAndView("login.xhtml");
        }

        @RequestMapping(value = "/logout", method = RequestMethod.GET)
        public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                if (auth != null) {
                        new SecurityContextLogoutHandler().logout(request, response, auth);
                }
                return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
        }


}
