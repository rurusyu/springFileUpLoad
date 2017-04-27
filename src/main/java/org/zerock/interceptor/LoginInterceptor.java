package org.zerock.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.zerock.domain.MemberVO;
import org.zerock.web.LoginController;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		if(request.getMethod().equals("GET")){
			return;	
		}
		
		Object result = modelAndView.getModel().get("result");
		
		//오브젝트가 없으면 로그인 페이지
		if(result == null){
			response.sendRedirect("/login?error=fail");
			return;
		}
		request.getSession().setAttribute("member", result); //여기까지가 로그인임.
		
		//쿠키방식. generate login cookie							//2번 제이세션방식임.
		Cookie loginCookie = new Cookie("loginCookie", (request.getSession().getId()));//<-1. (MemberVO)result).getUid()
		
		loginCookie.setMaxAge(60*60); // 제일중요함 유효시간설정 , 이제 로그인 체크로
		response.addCookie(loginCookie);
		
		HandlerMethod hmethod = (HandlerMethod)handler;
		LoginController controller = (LoginController)hmethod.getBean();
		
		controller.getMap().put(request.getSession().getId(), (MemberVO)result); //원래는 DB에 넣어야하는 데 없어서 컨트롤러에 저장
		
		
		Object dest = request.getSession().getAttribute("dest");
		//dest null
		if(dest==null){
			response.sendRedirect("/");			
		}else{
			response.sendRedirect((String)dest);
		}
		
		
	}

}
