package com.audiosharing.demo.services;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.audiosharing.demo.models.entities.User;
import com.audiosharing.demo.models.values.UserValue;
import com.audiosharing.demo.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Transactional(readOnly = true)
	public Optional<User> findByUserNoPk(Long UserNoPk) {
		return userRepository.findByUserNoPk(UserNoPk);
	}
	
	@Transactional(readOnly = true)
	public Optional<User> findByUserMailAndUserPassword(String UserMail, String UserPassword) {
		return userRepository.findByUserMailAndUserPassword(UserMail, UserPassword);
	}
	
	
	@Transactional
	public User save(UserValue value) {
		User user = User.builder()
				.userBirth(value.getUserBirth())
				.userMail(value.getUserMail())
				.userTel(value.getUserTel())
				.userName(value.getUserName())
				.userPassword(value.getUserPassword())
				.userSex(value.getUserSex())
				.userMusicGenre1(value.getUserMusicGenre1())
				.userMusicGenre2(value.getUserMusicGenre2())
				.userMusicGenre3(value.getUserMusicGenre3())
				.build();

		return userRepository.save(user);
	}


	@Transactional
	public int patch(long id, UserValue value) {
		Optional<User> oUser = userRepository.findByUserNoPk(id);
		if(oUser.isPresent()) {
			User user = oUser.get();
			if(StringUtils.isNotBlank(value.getUserBirth()))
				user.setUserBirth(value.getUserBirth());
			if(StringUtils.isNotBlank(value.getUserMail()))
				user.setUserMail(value.getUserMail());
			if(StringUtils.isNotBlank(value.getUserTel()))
				user.setUserTel(value.getUserTel());
			if(StringUtils.isNotBlank(value.getUserName()))
				user.setUserName(value.getUserName());
			if(StringUtils.isNotBlank(value.getUserPassword()))
				user.setUserPassword(value.getUserPassword());
			if(StringUtils.isNotBlank(value.getUserSex()))
				user.setUserSex(value.getUserSex());
			//if(StringUtils.isNotBlank(value.getUserType()))
				//user.setUserType(value.getUserType());
			if(StringUtils.isNotBlank(value.getUserMusicGenre1()))
				user.setUserMusicGenre1(value.getUserMusicGenre1());
			if(StringUtils.isNotBlank(value.getUserMusicGenre2()))
				user.setUserMusicGenre1(value.getUserMusicGenre2());
			if(StringUtils.isNotBlank(value.getUserMusicGenre3()))
				user.setUserMusicGenre1(value.getUserMusicGenre3());


			userRepository.save(user);
			return 1;
		}
		return 0;
	}
	/*
	@Transactional
	public int delete(long id) {
		Optional<User> oUser = userRepository.findByUserId(id);
		if(oUser.isPresent()) {
			userRepository.delete(oUser.get());
			return 1;
		}
		return 0;
	}
	*/
	@Transactional
	public List<User> findAll() {
		List<User> userList = this.userRepository.findAll();
		return userList;
	}
	
}
