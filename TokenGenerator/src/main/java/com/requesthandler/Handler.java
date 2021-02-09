package com.requesthandler;
import java.util.Random;

public class Handler {
	
	private String url;
	private String envir;
	private String tokentype;
	private String user;
	private String password;
	private int tokens;
	
	Handler(String url, String envir, String tokentype, String user, String password, int tokens){
		this.url = url;
		this.envir = envir;
		this.tokentype = tokentype;
		this.user = user;
		this.password = password;
	}
	
	public String getResponse() {
		
		try {
			
			String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
			
			StringBuilder sb = new StringBuilder();
			
			Random random = new Random();
			
			int length = 60;
			
			for (int i = 0; i<length; i++) {
				
				int index = random.nextInt(alphabet.length());
				
				char randomChar = alphabet.charAt(index);
				
				sb.append(randomChar);
			}
			
			String randomString = sb.toString();
			System.out.println("Random String is: " + randomString);
			return (randomString);
		}catch(Exception e) {
			e.printStackTrace();
			return "No Token Found";
		}
	}

}
