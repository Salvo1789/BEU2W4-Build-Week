package epicode.bw5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import epicode.bw5.services.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	UsersService usersService;
}
