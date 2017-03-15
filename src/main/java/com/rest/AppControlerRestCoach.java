package com.rest;

import java.awt.Dialog.ModalExclusionType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;

import com.domain.Coach;
import com.domain.Comment;
import com.service.CoachService;
import com.service.ICoachService;
import com.service.ICommentService;
import com.service.IPersonalTreiner;



@Controller
public class AppControlerRestCoach {
	
	private ICoachService iCoachService;
	private IPersonalTreiner iPersonalTreiner;
	private ICommentService iCommentService;
	
	@Autowired
	public AppControlerRestCoach(ICoachService iCoachService, IPersonalTreiner iPersonalTreiner, ICommentService iCommentService) {
		super();
		this.iCoachService = iCoachService;
		this.iPersonalTreiner = iPersonalTreiner;
		this.iCommentService = iCommentService;
	}

	

	/*
	 * Method test
	 */
	@RequestMapping("/test/")
	@ResponseBody
	public String test(){
		return "Work";
	}
	
	/*
	 * Method show viwe change 
	 */
	@RequestMapping(path="/logreg/")
	public String logReg(){
		return "logReg";
	}
	
	/*
	 * Method start, first view 
	 */
	@RequestMapping("")
	public String startView(Model model){
		return "start";
	}
	
	@RequestMapping("/opt/")
	public String optionCoach(){
		return "coachOption";
	}
	
	/*
	 * Method return list all coach with data base into view
	 */
	@RequestMapping("/listCoach/")
	public String allCoach(Model model){
		model.addAttribute("iCoachService", iCoachService.listCoach());
		return "listCoach";
	}

	/*
	 * Method return one record with all data trainer. 
	 * Method triggered after click firstname in list coach
	 */
	@RequestMapping(path="/onecoach/{id}",method=RequestMethod.GET)
	public String OneCoachTest(@ModelAttribute("newComment")Comment newComment  ,@PathVariable("id") Long id, Model model,
			@CookieValue(name="id",required=false,defaultValue="")String cooki,
			HttpServletResponse respons){
		respons.addCookie(new Cookie("id", String.valueOf(id)));
		
		//info coach
		List<Coach>coachList = new ArrayList<Coach>();
		coachList.add(iCoachService.findCoachById(id));
		model.addAttribute("coachList",coachList);
		// coment
		List<Comment>CommentList = new ArrayList<Comment>();
		CommentList.addAll(iCommentService.findCommentCoach(id));
		model.addAttribute("CommentList",CommentList);
		//add new comment

		
		return "coachdescrip";
	}
	
	@RequestMapping(path="/onecoach/addNewCom/", method=RequestMethod.POST)
	public String addNewComment(@ModelAttribute("newComment") Comment newComment,
			@CookieValue(name="id",required=false)String cooki){
		
		newComment.setId_coach(Long.valueOf(cooki));
		iCommentService.addComment(newComment);
		return "redirect:/listCoach/";
	}
	
	/*
	 * Method get into user survey and send saveCoach method 
	 */
	@RequestMapping(path="/add/", method=RequestMethod.GET)
	public String addNewCoach(@ModelAttribute("fromCoach") Coach fromCoach){
		return "addcoach";
	}
	
	/*
	 * Method ran repository and download list coach wiht data base  
	 */
	@RequestMapping(path="/save/", method=RequestMethod.POST)
	public String saveCoach(@Valid @ModelAttribute("fromCoach") Coach fromCoach, 
			BindingResult bindingResult){
		if(bindingResult.hasFieldErrors()){
			return "addcoach";
		}
		System.out.println(fromCoach.toString());
		iCoachService.addNewCoach(fromCoach);
		return "redirect:/listCoach/";
	}
	
	/*
	 * Method get price from user and transfer into sortPrice method
	 */
	@RequestMapping(path="/lookingprice/",method=RequestMethod.GET)
	public String lookingPrice(@ModelAttribute("pricecoach") Coach pricecoach){
		return "price";
	}
	
	/*
	 * Method send object in to repozitory and return list coach 
	 */
	@RequestMapping(path="/price/",  method=RequestMethod.POST)
	public String sortPrice(@ModelAttribute("pricecoach") Coach pricecoach,Model model){
		model.addAttribute("iCoachService",iCoachService.findCoachByPrice(pricecoach.getPrice()));
		return "listCoach";
	}
	
	/*
	 * Method get city and ran method cityCoach
	 */
	@RequestMapping(path="/lookingcoach/",method=RequestMethod.GET )
	public String lookingCity(@ModelAttribute("citycoach") Coach pricecoach,Model model){
		return "citycoach";
	}
	
	/*
	 * Method turn on repository and return view in list coach 
	 */
	@RequestMapping(path="/coachcity/",method=RequestMethod.POST)
	public String cityCoach(@ModelAttribute("citycoach") Coach citycoach,Model model){
		model.addAttribute("iCoachService", iCoachService.findCoachByCity(citycoach.getCity()));
		return "listCoach";
	}
	
	/*
	 * Method log 
	 */
	@RequestMapping(path="/log/", method=RequestMethod.GET)
	public String log(@ModelAttribute("coachPass") Coach coachPass){
		String result = null;
		if(coachPass == null){
			result = "start";
		}else{
			result = "logowanie";
		}
		return result;
	}
	
	@RequestMapping(path="/logcoach/",method=RequestMethod.POST)
	public String logCoach(@ModelAttribute("coachPass") Coach coachPass, Model model,BindingResult bindingResult,
			@CookieValue(name="coachPass",required=false,defaultValue="")String cooki,
			HttpServletResponse respons){
		
		String result = null;
		String name = coachPass.getLogin();
		
		boolean b = iPersonalTreiner.log(coachPass.getLogin(), coachPass.getPassword());
		if(b == true){
			result = "optionPersonal";
			respons.addCookie(new Cookie("coachPass", coachPass.getLogin()));	
		}else{
			result = "start";
		}
		
		return result;
	}
	
	/*
	 * Method register  
	 */
	@RequestMapping(path="/reg/",method=RequestMethod.GET)
	public String register(@ModelAttribute("regPerson") Coach regPerson){
		return "register";
	}
	
	@RequestMapping(path="/regper/",method=RequestMethod.POST)
	public String registerPersonal(@ModelAttribute("regPerson") Coach regPerson){
		iPersonalTreiner.register(regPerson);
		return "optionPersonal";
	}
	
	/*
	 * Mehtod change city personal trainer 
	 */
	@RequestMapping(path="/logcoach/changecity/",method=RequestMethod.GET)
	public String getNewCity(@ModelAttribute("changeCity")Coach changeCity){
		return "changeCity";
	}
	
	@RequestMapping(path="/logcoach/newcity/",method=RequestMethod.POST)
	public String changeCity(@ModelAttribute("changeCity")Coach changeCity,
			@CookieValue(name="coachPass",required=false)String cooki){
		
		if(cooki != null){
			iPersonalTreiner.changeCity(cooki, changeCity.getCity());
		}
		
		return "optionPersonal";
	}
	
	/*
	 * Method change price
	 */
	@RequestMapping(path="/logcoach/changeprice/", method=RequestMethod.GET)
	public String getChangePrice(@ModelAttribute("changePrice")Coach changePrice){
		return "changePrice";
	}
	
	@RequestMapping(path="/logcoach/newPrice/",method=RequestMethod.POST)
	public String changePrice(@ModelAttribute("changePrice")Coach changePrice,Model model,
			@CookieValue(name="coachPass",required=false)String cooki){
		
		iPersonalTreiner.changePrice(cooki, changePrice.getPrice());
		return "optionPersonal";

	}
	
	/*
	 * Method delete
	 */
	@RequestMapping(path="/logcoach/delete/", method=RequestMethod.GET)
	public String getDelete(@ModelAttribute("deleteAccount")Coach deleteAccount){
		return "delete";
	}
	
	@RequestMapping(path="/logcoach/deleteAcc/",method=RequestMethod.POST)
	public String deleteAcc(@ModelAttribute("deleteAccount")Coach changePrice,Model model,
			@CookieValue(name="coachPass",required=false)String cooki){
		iPersonalTreiner.deletePersonal(cooki);
		return "start";

	}
	
	
	
	
	
}
