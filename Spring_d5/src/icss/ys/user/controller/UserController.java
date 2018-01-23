package icss.ys.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import icss.ys.user.service.UsersService;

@Controller
public class UserController {
	@Autowired
	private UsersService service ;

	public UsersService getService() {
		return service;
	}

	public void setService(UsersService service) {
		this.service = service;
	}
	public void login(){
		
	}
	
	public void resgister(){
		
	}
	
}
