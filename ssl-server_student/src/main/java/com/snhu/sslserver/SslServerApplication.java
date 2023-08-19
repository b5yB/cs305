package com.snhu.sslserver;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.tomcat.util.buf.HexUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SslServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SslServerApplication.class, args);
	}

}



//FIXME: Add route to enable check sum return of static data example:  String data = "Hello World Check Sum!";

@RestController
class ServerController{ 
    @GetMapping("/hash")
    public String myHash() throws NoSuchAlgorithmException{
    	String data = "William Cocomise CS305-P2 - Hello World Check Sum!";
    	
    	byte[] dataAsBytes= data.getBytes();
    	MessageDigest hash = MessageDigest.getInstance("SHA-256");
    	byte[] hashedData = hash.digest(dataAsBytes);
    	String hashAsString = HexUtils.toHexString(hashedData);
		
		
		return "<p>data: " + data + "\n" + "<p>hash: " + hashAsString;
     
    }
}
