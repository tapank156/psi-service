package com.scholastic.scent.servlet;

import java.io.PrintWriter;
import java.io.StringWriter;

//import javax.inject.Inject;


import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.scholastic.scent.exception.UserNotFoundException;
import com.scholastic.scent.vo.ErrorVO;

@ControllerAdvice
public class AppErrorHandler {
	private static final Logger logger = Logger.getLogger(AppErrorHandler.class);
	//@Inject HttpServletRequest httpServeletRequest;
		
	private ResponseEntity<ErrorVO> getErrorModelAndView(Exception ex, String viewName) {
		//String parsedString = parse(ex);
		//HttpSession session = httpServeletRequest.getSession();
		//logger.error("SESSION# "+ session.getId());
		logger.error(ex.getMessage(), ex);
		ErrorVO err = new ErrorVO(ex.hashCode()+"", ex.getMessage(), ex.getCause().getMessage());
	    return new ResponseEntity<ErrorVO>(err, HttpStatus.OK);
	}
	
	//throw new UserNotFoundException(this.getClass().getName(), "No studet profile found with this id " + userId);
	
	private String parse(Exception e) {
        String parsedString = null;
		try {
	        StringWriter writer = new StringWriter();
	        e.printStackTrace(new PrintWriter(writer));
	        parsedString = writer.getBuffer().toString();
        }catch (Exception ex) {
		}
		return parsedString;
	}	

	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<ErrorVO> handleException(Exception ex) {
		logger.info("handleException - Catching: " + ex.getClass().getSimpleName());
		return getErrorModelAndView(ex, null);
	}

	/*
	@ExceptionHandler(value = {AjaxException.class})
	public ModelAndView handleAjaxException(AjaxException ex) {
		logger.info("AjaxException - Catching: " + ex.getClass().getSimpleName());
		return getErrorModelAndView(ex, "error");
	}
	
	@ExceptionHandler(value = {AppException.class})
	public ModelAndView handleAppException(AppException ex) {
		logger.info("handleAppException - Catching: " + ex.getClass().getSimpleName());
		return getErrorModelAndView(ex, null);
	}
	private List<String> parse(Exception e) {
	    List<String> list = new LinkedList<String>();
	        try {
            StringWriter writer = new StringWriter();
            e.printStackTrace(new PrintWriter(writer));
            list.add(writer.getBuffer().toString());
	        }catch (Exception ex) {
			}
	    return list;
	}	
	*/
}
