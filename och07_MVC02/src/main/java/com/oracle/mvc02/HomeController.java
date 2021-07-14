package com.oracle.mvc02;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/board/view")
	public String view() {
		System.out.println("HomeController board/view start... ");
		return "/board/view";
	}

	@RequestMapping("/board/content") // value = 생략가능
	public String content(Model model) {
		model.addAttribute("id", 30);
		return "/board/content";
	}

	@RequestMapping("/board/reply")
	public ModelAndView reply() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", 50);
		mv.setViewName("board/reply");
		return mv;
	}

}
