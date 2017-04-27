package org.zerock.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.MemberVO;

@Controller
public class LoginController {
	
	private Map<String, MemberVO> map;
	
	public LoginController(){
		
		map = new HashMap<>();
		
		
		
	}
	
	public Map<String, MemberVO> getMap(){
				
		return map;
		
		
	}
	
	
	
	
    @GetMapping("/login")
    public void loginGet(){
        
        
    }
    
    @PostMapping("/login") //id=pw해야 로그인되게. 이거 끝난 후에 post 인터셉터 만들어줘야함. 
    public void loginPost(@RequestParam("uid") String uid, @RequestParam("upw") String upw, Model model){
        
        if(uid.equals(upw)){
        	MemberVO vo = new MemberVO();
        	vo.setUid(uid);
        	vo.setUpw(upw);
        	vo.setUname(uid+"님");
        	model.addAttribute("result", vo);
        	//2. 로그인 정보 Map에 저장, 세션ID넣어야함,.
        	
        	
        }
    }
    
}