package com.example.demo.base.service;


import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


@Service
public class AuthService extends HttpCallService{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private static final String AUTH_URL = "https://kauth.kakao.com/oauth/token";

	public static String authToken;

	public boolean getKakaoAuthToken(String code)  {
		HttpHeaders header = new HttpHeaders();
		String accessToken = "";
		String refrashToken = "";
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();

		header.set("Content-Type", APP_TYPE_URL_ENCODED);

		parameters.add("code", code);
		parameters.add("grant_type", "authorization_code");
		parameters.add("client_id", "your client id");
		parameters.add("redirect_url", "your redirect url");
		parameters.add("client_secret", "your client secret");

		HttpEntity<?> requestEntity = httpClientEntity(header, parameters);

		ResponseEntity<String> response = httpRequest(AUTH_URL, HttpMethod.POST, requestEntity);
        JSONObject jsonData = new JSONObject(response.getBody());
        accessToken = jsonData.get("access_token").toString();
        refrashToken = jsonData.get("refresh_token").toString();
        if(accessToken.isEmpty() || refrashToken.isEmpty()) {
        	logger.debug("토큰발급에 실패했습니다.");
        	return false;
        }else {
            authToken = accessToken;
            return true;
        }
	}

}
