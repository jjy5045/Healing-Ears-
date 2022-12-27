package com.audiosharing.demo.util;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.log4j.Log4j2;

@Aspect
@Component
public class LoginCheckAspect {

    @Before("@annotation(com.audiosharing.demo.util.LoginType) && @annotation(loginType)")
    public void loginCheck(LoginType loginType) {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();

        switch (loginType.type()) {
            case USER:
                verifyUserSession(session);
                break;
            case ADMIN:
                verifyAdminSession(session);
                break;
        }
    }

    private void verifyUserSession(HttpSession session) {
        String loginUserId = SessionUtil.getLoginMemberId(session);

        if (loginUserId == null) {
            throw new IllegalStateException("로그인(유저)이 필요합니다.");
        }
    }

    private void verifyAdminSession(HttpSession session) {
        String loginAdminId = SessionUtil.getLoginAdminId(session);

        if (loginAdminId == null) {
            throw new IllegalStateException("로그인(관리자)이 필요합니다.");
        }
    }

}