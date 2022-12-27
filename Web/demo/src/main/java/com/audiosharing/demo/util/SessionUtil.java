package com.audiosharing.demo.util;

import javax.servlet.http.HttpSession;

public class SessionUtil {
	private static final String LOGIN_MEMBER_ID = "LOGIN_MEMBER_ID";
	private static final String LOGIN_ADMIN_ID = "LOGIN_ADMIN_ID";

	// 인스턴스화 방지
	private SessionUtil() {
	}

	/**
	 * 로그인한 유저의 아이디를 세션에서 꺼낸다.
	 *
	 * @param session 사용자의 세션
	 * @return 로그인한 고객의 id 또는 null
	 * @author topojs8
	 */
	public static String getLoginMemberId(HttpSession session) {
		return (String) session.getAttribute(LOGIN_MEMBER_ID);
	}

	/**
	 * 로그인 한 유저의 id를 세션에 저장한다.
	 *
	 * @param session 사용자의 session
	 * @param id      로그인한 고객의 id
	 * @author topojs8
	 */
	public static void setLoginMemberId(HttpSession session, String id) {
		session.setAttribute(LOGIN_MEMBER_ID, id);
	}

	public static String getLoginAdminId(HttpSession session) {
		return (String) session.getAttribute(LOGIN_ADMIN_ID);
	}

	public static void getLoginAdminId(HttpSession session, String id) {
		session.setAttribute(LOGIN_ADMIN_ID, id);
	}
}
