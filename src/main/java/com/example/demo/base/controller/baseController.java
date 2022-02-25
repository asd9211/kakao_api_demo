package com.example.demo.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.base.service.AuthService;
import com.example.demo.base.service.CustomMessageService;

@RestController
public class baseController {

	@Autowired
	AuthService authService;

	@Autowired
	CustomMessageService customMEssageService;

	@GetMapping("/")
	public String serviceStart(String code) {
		if(authService.getKakaoAuthToken(code)) {
			customMEssageService.sendMyMessage();
			return "메시지 전송 성공";
		}else {
			return "토큰발급 실패";
		}
	}
}
