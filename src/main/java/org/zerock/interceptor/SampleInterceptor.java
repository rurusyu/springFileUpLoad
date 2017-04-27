package org.zerock.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterConcurrentHandlingStarted(request, response, handler);
	}

	@Override //로그인 하고 로그인 한정보를 model and view방식으로 보내서 요청이나 응답하도록 하는 기능
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override //로그인에 대한 접근
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("pre핸들");
		
//		Method method = (Method)handler; //얘량 서비스랑 연결. 사용자가 던지는 파라미터가 맞나? 체크하는 것임.
		
		HandlerMethod method = (HandlerMethod)handler;
		System.out.println(method.getBean());
		
		String uid = request.getParameter("uid");
		
		if(uid==null||uid.isEmpty()){
			
			response.sendRedirect("login");//권한없는 접근자 튕김.
			return false;
		}
		
		
		return true;
	}

	
	
}
