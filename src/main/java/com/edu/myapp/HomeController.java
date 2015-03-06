package com.edu.myapp;


import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.myapp.service.HomeService;

/**
 * Handles requests for the application home page.
 * 
 */
@Controller
public class HomeController {

	@Autowired
	HomeService homeService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	/*예제 start*/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		/*logger.info("Welcome home! The client locale is {}.", locale);*/

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}
	/*예제 end*/

	
	/*list start*/
	@RequestMapping(value = "/selectGearList", method = RequestMethod.POST)
	public @ResponseBody List selectGearList(Map<String,String> paramMap) throws Exception{
		
		return homeService.selectGearList(paramMap);
		
		
	}
	/*list end*/
	
	/*insert start*/
	@RequestMapping(value ="/insertGear", method = RequestMethod.POST)
	public @ResponseBody int insertGear(HttpServletRequest request, Model model) throws Exception {
		System.out.println("========= insertGear ===================");
		System.out.println(request.getParameter("id"));
		
		
		Map<String,String> paramMap = new HashMap<String, String>();
		
		String a = (String)request.getParameter("id");
		String b = (String)request.getParameter("name");
		String c = (String)request.getParameter("snno");
		String d = (String)request.getParameter("rental");
		String e = (String)request.getParameter("day");
		String f = (String)request.getParameter("tel");
		
		paramMap.put("id", a);
		paramMap.put("name", b);
		paramMap.put("snno", c);
		paramMap.put("rental", d);
		paramMap.put("day", e);
		paramMap.put("tel", f);
		 
		return homeService.insertGear(paramMap);
		
	}
	/*insert end*/
	
	/*delect start*/
	@RequestMapping(value ="/delectGear", method = RequestMethod.POST)
	public @ResponseBody int delectGear(HttpServletRequest request) throws Exception {
		
		
		String[] ids = request.getParameterValues("ids");
		
		logger.info("ids length : " + ids.length);
		
		Map<String,String> delparamMap = new HashMap<String, String>();
		int n = 0;
		for (int idx=0; idx < ids.length; idx++) {
			System.out.println(idx + " ---- " + ids[idx]);
			delparamMap.put("id", ids[idx]);
		}
		
		return homeService.deleteGear(delparamMap);
		
	}
	/*delect end*/
	
	/*update start*/
	
	@RequestMapping(value ="/updateGear", method = RequestMethod.POST)
	public @ResponseBody int updateGear(HttpServletRequest request, Model model) throws Exception {
		System.out.println("========= updateGear ===================");
		System.out.println(request.getParameter("name"));
		System.out.println(model);
		
		Map<String,String> paramMap = new HashMap<String, String>();
		
		String updata_a = (String)request.getParameter("id");
		String name = (String)request.getParameter("name");
		String updata_c = (String)request.getParameter("snno");
		String updata_d = (String)request.getParameter("rental");
		String updata_e = (String)request.getParameter("day");
		String updata_f = (String)request.getParameter("tel");
		
		
		paramMap.put("id", updata_a);
		paramMap.put("name", name);
		paramMap.put("snno", updata_c);
		paramMap.put("rental", updata_d);
		paramMap.put("day", updata_e);
		paramMap.put("tel", updata_f);
		System.out.println("========= updateGear ===================");
		return homeService.updateGear(paramMap);
		
	}
	/*update end*/
}
