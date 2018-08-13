package com.cyhee.rabit.user.web;

import javax.annotation.Resource;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cyhee.rabit.user.model.User;
import com.cyhee.rabit.user.model.UserView;
import com.cyhee.rabit.user.service.UserService;
import com.cyhee.rabit.validation.SetPasswordGroup;
import com.cyhee.rabit.validation.exception.ValidationFailException;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("rest/v1/users")
public class UserController {
	@Resource(name = "basicUserService")
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<Iterable<User>> getUsers(@PageableDefault Pageable pageable) {
		return new ResponseEntity<Iterable<User>>(userService.getUsers(pageable), HttpStatus.OK);
	}

	@JsonView(UserView.UserPost.class)
	@PostMapping
	public ResponseEntity<Void> addUser(@RequestBody @Validated({SetPasswordGroup.class}) User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			throw new ValidationFailException(bindingResult.getAllErrors());
	
		userService.addUser(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> getUser(@PathVariable long id/*, Principal principal*/) {
		/*if(principal == null)
			return new ApiResponseEntity<>(ApiErrorCode.FORBIDDEN, "No principal information", HttpStatus.FORBIDDEN);*/		
		User user = userService.getUser(id);
		/*if(!user.getUsername().equals(principal.getName()))
			return new ApiResponseEntity<>(ApiErrorCode.FORBIDDEN, "Incorrect principal information", HttpStatus.FORBIDDEN);*/
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateUser(@PathVariable long id, @RequestBody User userForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			throw new ValidationFailException(bindingResult.getAllErrors());
		
		userService.updateUser(id, userForm);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable long id) {
		userService.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
}
