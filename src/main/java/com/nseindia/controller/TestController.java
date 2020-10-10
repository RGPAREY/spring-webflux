package com.nseindia.controller;



import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@CrossOrigin
public class TestController {
	
	
	public List<SseEmitter> emmitter = new CopyOnWriteArrayList<>();
	
	@RequestMapping(value="/subscribe", consumes  = MediaType.ALL_VALUE)
	public SseEmitter subscribe() throws IOException {
		SseEmitter sseEmitter = new SseEmitter();
		
		sseEmitter.send(SseEmitter.event().name("INIT"));
		
		emmitter.add(sseEmitter);
		
		return sseEmitter;
	}
	 

}
