package com.oracle.mvc042;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping("/index")
	public String index() {
		System.out.println("HomeController index Start...");
		logger.info("index start...");
				return "index";
	}
	@RequestMapping("/studentView3")
	public String studentView(StudentInformation studentInformation, Model model) {
		logger.info("studentView3 Start...");
		StudentInformation studentInfo = new StudentInformation();
		studentInfo.setName(studentInformation.getName());
		studentInfo.setAge(studentInformation.getAge());
		studentInfo.setClassNum(studentInformation.getClassNum());
		studentInfo.setGradeNum(studentInformation.getGradeNum());
		model.addAttribute("studentInfo",studentInfo);
		
		return "studentView";
	}
	
	@RequestMapping("/studentView5")
	public String studentView5(@ModelAttribute("studentInfo") StudentInformation studentInformation){
		logger.info("studentView5 | Start...");
		//return "studentView";
		return "studentView";
	}
	
}
