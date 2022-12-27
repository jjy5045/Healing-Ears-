package com.audiosharing.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.audiosharing.demo.models.entities.StationList;
import com.audiosharing.demo.models.entities.User;
import com.audiosharing.demo.models.values.UserValue;
import com.audiosharing.demo.services.UserService;
import com.audiosharing.demo.util.LoginType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value = "/users", produces = { MediaType.APPLICATION_JSON_VALUE })
@RestController
public class UserController {

	private final UserService userService;
	private final ObjectMapper mapper;

	/*
	 * @PostMapping("/login") public ResponseEntity<Map<String, Object>>
	 * Login(@RequestBody UserValue value, HttpSession session) { Map<String,
	 * Object> response = new HashMap<>();
	 * 
	 * Optional<User> oUser =
	 * userService.findByUserEmailAndUserPassword(value.getUserEmail(),
	 * value.getUserPassword());
	 * 
	 * if (oUser.isPresent()) { response.put("result", "SUCCESS");
	 * response.put("user", oUser.get());
	 * 
	 * // 세션에 로그인 회원 정보 보관 //session.setAttribute("oUser", oUser);
	 * session.setAttribute("id", oUser.get().getUserId());
	 * session.setAttribute("LOGIN_MEMBER_ID", "USER"); } else {
	 * response.put("result", "FAIL"); response.put("reason",
	 * "일치하는 회원 정보가 없습니다. 입력 정보를 다시 확인하세요."); } //return Json return new
	 * ResponseEntity<Map<String, Object>>(response, HttpStatus.OK); }
	 */

	
	/*
	@PostMapping("/login")
	public ResponseEntity<String> Login(@RequestBody UserValue value, HttpSession session) {
		Optional<User> oUser = userService.findByUserEmailAndUserPassword(value.getUserEmail(),
				value.getUserPassword());
		String result = null;
		if (oUser.isPresent()) {
			result = "SUCCESS";
			session.setAttribute("id", oUser.get().getUserId());
			session.setAttribute("LOGIN_MEMBER_ID", "USER");
		} else {
			result = "FAIL";

		} //
			// return Json
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	*/
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> Login(@RequestBody UserValue value, HttpSession session) {
		Optional<User> oUser = userService.findByUserEmailAndUserPassword(value.getUserEmail(), value.getUserPassword());
		Map<String, Object> response = new HashMap<>();
		
		if (oUser.isPresent()) {
			response.put("result", "SUCCESS");
			response.put("user", oUser);
			session.setAttribute("id", oUser.get().getUserId());
			session.setAttribute("LOGIN_MEMBER_ID", "USER");
		} else {
			response.put("result", "FAIL");
		} //
			// return Json
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/info")
	@LoginType(type = LoginType.UserType.USER)
	public Map<String, Object> Info(HttpSession session) {
		Map<String, Object> response = new HashMap<>();

		// response = findByUserId(session.getAttribute("id"));
		Optional<User> oUser = userService.findByUserId((Long) session.getAttribute("id"));
		oUser.get().setUserPassword(null);
		response.put("result", "SUCCESS");
		response.put("user", oUser);

		return response;
	}

	@GetMapping("/logout")
	// @LoginType(type = LoginType.UserType.USER)
	public ResponseEntity<String> Logout(HttpSession session) {
		String result = null;

		if (session.getAttribute("id") != null) {
			//session.setAttribute("loginCheck", null);
			//session.setAttribute("id", null);
			session.invalidate();
			result = "SUCCESS";
		} else {
			result = "FAIL";
		}

		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	/*
	 * @GetMapping("/logout")
	 * 
	 * @LoginType(type = LoginType.UserType.USER) public Map<String, Object>
	 * Logout(HttpSession session) { Map<String, Object> response = new HashMap<>();
	 * 
	 * session.setAttribute("loginCheck",null); session.setAttribute("id",null);
	 * session.invalidate();
	 * 
	 * response.put("로그아웃", "OK");
	 * 
	 * return response; }
	 */

	/*
	 * @GetMapping("/{id}") public Map<String, Object>
	 * findByUserId(@PathVariable("id") long id) { Map<String, Object> response =
	 * new HashMap<>();
	 * 
	 * Optional<User> oUser = userService.findByUserId(id); if (oUser.isPresent()) {
	 * //response.put("result", "SUCCESS"); //response.put("user", oUser.get());
	 * response.put("userVO", oUser.get()); } else { response.put("result", "FAIL");
	 * response.put("reason", "일치하는 회원 정보가 없습니다. 사용자 id를 확인해주세요."); }
	 * 
	 * return response; }
	 */

	//////////////// 성공
	/*
	 * @GetMapping("/{id}") public ResponseEntity<String>
	 * findByUserId(@PathVariable("id") long id) throws JsonProcessingException {
	 * Map<String, Object> response = new HashMap<>(); String result = null; //User
	 * tempUser = userService.findByUserId(id); Optional<User> oUser =
	 * userService.findByUserId(id); if (oUser.isPresent()) {
	 * //response.put("result", "SUCCESS"); //response.put("user", oUser.get());
	 * response.put("userVO", oUser.get()); result =
	 * mapper.writeValueAsString(oUser.get());
	 * 
	 * } else { response.put("result", "FAIL"); response.put("reason",
	 * "일치하는 회원 정보가 없습니다. 사용자 id를 확인해주세요."); }
	 * 
	 * return new ResponseEntity<String>(result, HttpStatus.OK); }
	 */

	@GetMapping("/{id}")
	public ResponseEntity<String> findByUserId(@PathVariable("id") long id) throws JsonProcessingException {
		Map<String, Object> response = new HashMap<>();
		// User tempUser = userService.findByUserId(id);
		Optional<User> oUser = userService.findByUserId(id);
		if (oUser.isPresent()) {
			response.put("result", "SUCCESS");
			response.put("user", oUser.get());

		} else {
			response.put("result", "FAIL");
			response.put("reason", "일치하는 회원 정보가 없습니다. 사용자 id를 확인해주세요.");
		}
		String result = mapper.writeValueAsString(response);

		return new ResponseEntity<String>(result, HttpStatus.OK);

	}

	@GetMapping("/session")
	public Map<String, Object> get(@SessionAttribute(name = "oUser", required = false) Optional<User> oUser,
			HttpSession session) {
		Map<String, Object> response = new HashMap<>();

		if (session.getAttribute("id") == null) {
			response.put("loginState", "FAIL");
			return response;
		}

		// return oUser.get().getUserEmail();
		else {
			response.put("loginState", "OK");
			response.put("sessionGetID", session.getId());
			response.put("id", session.getAttribute("id"));
			// response.put("oUser.get().getUserEmail()", oUser.get().getUserEmail());
			response.put("auth", session.getAttribute("LOGIN_MEMBER_ID"));
			return response;
		}
	}

	@GetMapping("/all")
	// @LoginCheck(type = LoginCheck.UserType.USER)
	// @LoginType(type = LoginType.UserType.ADMIN)
	public Map<String, Object> findAll() {
		Map<String, Object> response = new HashMap<>();

		List<User> LUser = userService.findAll();
		if (!LUser.isEmpty()) {
			response.put("result", "SUCCESS");
			response.put("user", LUser);
		} else {
			response.put("result", "FAIL");
			response.put("reason", "사용자가 없습니다.");
		}

		return response;
	}
	
	// 회원가입
	@PostMapping("")
	public ResponseEntity<Map<String, Object>> save(@RequestBody UserValue value, HttpSession session) {
		Map<String, Object> result = new HashMap<>();

		User user = userService.save(value);
		if (user != null) {
			result.put("result", "SUCCESS");
		} else {
			result.put("result", "FAIL");
		}

		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Map<String, Object>> patch(@PathVariable("id") long id, @RequestBody UserValue value, HttpSession session) {
		Map<String, Object> response = new HashMap<>();

		if (userService.patch(id, value) > 0) {
			response.put("result", "SUCCESS");
		} else {
			response.put("result", "FAIL");
			response.put("reason", "일치하는 회원 정보가 없습니다. 사용자 id를 확인해주세요.");
		}

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public Map<String, Object> delete(@PathVariable("id") long id) {
		Map<String, Object> response = new HashMap<>();

		if (userService.delete(id) > 0) {
			response.put("result", "SUCCESS");
		} else {
			response.put("result", "FAIL");
			response.put("reason", "일치하는 회원 정보가 없습니다. 사용자 id를 확인해주세요.");
		}

		return response;
	}
}
