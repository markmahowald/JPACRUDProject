package com.skilldistillery.tripMVC.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.skilldistillery.tripMVC.data.TripDAO;
import com.skilldistillery.tripentities.entities.Trip;



@Controller
public class TripController {
	@Autowired
	private TripDAO dao;
	
//	home page
	@RequestMapping(path="home.do", method=RequestMethod.GET)
	public ModelAndView index(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("tripList", dao.findAll());
			mv.setViewName("index");	
		return mv;
	}
	
//	path for showing the details of a single trip.
	@RequestMapping(path="search.do", params="tripId", method=RequestMethod.GET)
	public ModelAndView showSingleTrip(@RequestParam(value="tripId")int tripId) {
		ModelAndView mv = new ModelAndView();
		Trip t = dao.findById(tripId);
		
		if (t!= null) {
			mv.setViewName("trip/showSingle");
			mv.addObject("trip", t);
			
		}else {
			mv.setViewName("index");
			mv.addObject("failedSearch", true);
		}
		return mv;	
	}
	
////	path for showing several results of a search - i.e. keyword
//	@RequestMapping(path="search.do", params="search", method=RequestMethod.GET)
//	public ModelAndView show0ToManytrips(){
//		ModelAndView mv = new ModelAndView();
//		return mv;	
//	}

//	path to get to the add form.
	@RequestMapping(path="add.do", method = RequestMethod.GET)
	public ModelAndView addTripform() {
		ModelAndView mv = new ModelAndView();
		Trip t = new Trip();
		mv.setViewName("addTrip");
		mv.addObject("newTrip", t);
		return mv;
	}
	
//	path to actually add (from add form to show the new trip).
	@RequestMapping(path="add.do", method = RequestMethod.POST)
	public ModelAndView addTripToDB(@Valid Trip t, Errors e) {
		ModelAndView mv = new ModelAndView();
		System.out.println("ERRORS!!!!"+e.getErrorCount());
		
		if (e.hasErrors()) {
			mv.setViewName("index");
			mv.addObject("failedAdd", true);
		}else {
			Trip newTrip = dao.create(t);
			mv.addObject("newTrip", newTrip);
			mv.addObject("originalTrip", t);
			mv.setViewName("trip/showSingle");
		}
		return mv;
	}
	
//	delete a trip
	@RequestMapping(path="delete.do", method = RequestMethod.POST)
	public ModelAndView deleteTrip(@RequestParam(value="tripId")int id) {
		ModelAndView mv = new ModelAndView();
		Trip tripToDelete = dao.findById(id);
		if(dao.destroy(id)) {
			mv.setViewName("index");
			mv.addObject("delete?", true);
		}else {
			mv.setViewName("trip/showSingle");
			mv.addObject("trip", tripToDelete);
			mv.addObject("delete?",  false);
		}
		return mv;
	}
	
//	UpdateButton post path
	@RequestMapping(path="update.do", method=RequestMethod.POST)
	public ModelAndView updateTrip(@Valid Trip updatedTrip, Errors e) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("trip/showSingle");
		mv.addObject("updatedTrip", updatedTrip);
		
		if (e.hasErrors()) {
			mv.addObject("updateFailure", true);
		}else {
			if(!dao.update(updatedTrip.getId(), updatedTrip)) {
				mv.addObject("trip", updatedTrip);
			}
		}
		return mv;
	}



}
