package com.benwwest.notify.controller;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.benwwest.notify.model.Notification;
import com.benwwest.notify.repository.NotificationRepository;
import com.google.common.collect.Lists;


@Controller
public class NotifyMe {
	
	//final static Logger log = Logger.getLogger(NotifyMe.class);

	@Autowired
	private NotificationRepository notificationRepository;
	
	@RequestMapping(value = "/callback", method=RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK )
	public void log_Get(HttpServletRequest req){
		
		
		Notification wpc = new Notification();
		wpc.setHeaders(getHeaders(req));
		notificationRepository.save(wpc);
		
	}
	
	@RequestMapping(value = "/callback", method=RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK )
	public void log_Post(@RequestBody String body, HttpServletRequest req){

		Notification wpc = new Notification();
		wpc.setHeaders(getHeaders(req)+"<br/>"+body);

		notificationRepository.save(wpc);
		
	}
	
	@RequestMapping(value = "/show")
	public String show(ModelMap modelMap){
		
		List<Notification> notifications = Lists.newArrayList(notificationRepository.findAll());
		
		modelMap.put("notifications", notifications);
		
		return "show";
	}
	
	@RequestMapping(value="/delete" , method=RequestMethod.POST)
	public String remove(@RequestParam("id") Long id, ModelMap map){
		
		
		notificationRepository.delete(id);
		
		return "redirect:show";
	}
	
	@RequestMapping(value="/deleteall" , method=RequestMethod.POST)
	public String removeAll(){
		notificationRepository.deleteAll();
		return "redirect:show";
	}
	
	
	
	
private String getHeaders(HttpServletRequest req){
		
		String url = req.getRequestURL().toString();
		String qs = req.getQueryString();
		StringBuffer headers = new StringBuffer();
		String headerName = "";
		Enumeration e = req.getHeaderNames();	
		
		headers.append(req.getMethod()+" "+url);
		if(qs!=null && !qs.isEmpty()){
			headers.append("?"+qs);
		}
		
		headers.append(" "+req.getProtocol()+"<br/>");
		
		// write the headers
		while (e.hasMoreElements()) {
			headerName = (String) e.nextElement();
			if (headerName != null) {
				headers.append(headerName + ":" + req.getHeader(headerName) + "<br/>");
			}
		}
		
		return headers.toString();
	}

}
