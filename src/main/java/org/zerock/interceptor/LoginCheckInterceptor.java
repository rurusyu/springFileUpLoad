package org.zerock.interceptor;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;
import org.zerock.domain.MemberVO;
import org.zerock.web.LoginController;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	@Inject
	private LoginController loginController;
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		//쿠키있으면 넘김, 이방법은 보안문제때문에 쓸수 없음. 페이지때문에 안됨.
		//2번방식. 로그인 쿠키가 있음. -> 조회해야함.
		//2. 쿠키는 잇는데 세션에 멤버는 없음. 쿠키에 씌여져 있는 값을 세션에 넣어버리면 됨. 유통기한있어랴하는데 그것은 책을 참고, 지금은 실습목적상 축소
		if(loginCookie != null && /*키에 씌여져 있는 값을 세션에 넣어버리면 됨 */request.getSession().getAttribute("member") == null){ 
		
			String sid = loginCookie.getValue(); //세션값 가져옴
			
			MemberVO vo = loginController.getMap().get(sid); //컨트롤러에서 가져오고 세션에 담아줘야함.
			
			request.getSession().setAttribute("member", vo); //세션에 담아줘야함. 어떤 방식이 사용하냐일뿐임. 프론트엔드에서 시큐리티 적용할 것임.
			
			return true;
		}
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("member") == null){
			System.out.println("THIS USER IS NOT LOGIN");
			
			//p645참고, 사용자 로그인 안됐는데 원하는 주소있을때. 세션방식이면 추적이 가능한데, 쿠키는 추적할 방법이 없음. 
			String uri = request.getRequestURI();
			
			
			session.setAttribute("dest", uri);
			
			
			response.sendRedirect("/login"); //절대 경로 힘들어줌 /login걸면 웹 경로 못씀
		
			
			return false;
		}
	

		
		
		return true;
	}

	
	
}
