package icss.ys.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest res, HttpServletResponse resonse) throws Exception {
		System.out.println(res.getParameter("username"));
		ModelAndView mo = new ModelAndView("success.jsp");
		mo.addObject("username",res.getParameter("username"));
	
		return mo;
	}

}
