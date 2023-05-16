package com.example.game;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class GameController {
	
	@Autowired
	HttpSession session;
	int count;
	String comment;
	int rightAns;
	int correct;
	Game mondai;
	
	@GetMapping("/")
	public String index() {
		session.invalidate();
		
		return "game1";
	}
	
	@GetMapping("/challenge")
	public ModelAndView challenge(ModelAndView mv) {
		mondai = new Game();
		session.setAttribute("mondai", mondai);
		
		mv.setViewName("game2");
		mv.addObject("mondai", mondai);
		System.out.println(mondai.getChoice1());
		
		return mv;
	}
	
	@PostMapping("/answer")
	public ModelAndView answer(int answer,ModelAndView mv) {
		mondai = (Game)session.getAttribute("mondai");
		System.out.println(mondai.getChoice2());
		@SuppressWarnings("unchecked")
		List<History> histories = (List<History>)session.getAttribute("histories");
		if (histories == null) {
			histories = new ArrayList<>();
			session.setAttribute("histories", histories);
		}
		//count = (Integer)session.getAttribute("count");
		//count++;
		//correct = (Integer)session.getAttribute("correct");
			
		
		if(answer == mondai.getCorrect()) {
			histories.add(new History(histories.size() + 1,"正解です！","正解"));
			//rightAns = (Integer)session.getAttribute("rightAns");
			//rightAns++;
			//session.setAttribute("rightAns", rightAns);
			//session.setAttribute("count", count);
			//System.out.println(histories.c);
			
			mv.setViewName("game3");
			mv.addObject("histories", histories);
			return mv;
			
		}else {
			histories.add(new History(histories.size() + 1,"ざんねん！！不正解　　こたえは　" + mondai.getName()  + "　の　" + mondai.getCorrect() + "　でした","不正解"));
			
			mv.setViewName("game3");
			mv.addObject("histories", histories);
			return mv;
		}
		
	}
	

}
