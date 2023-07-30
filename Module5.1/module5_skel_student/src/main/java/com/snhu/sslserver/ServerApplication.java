package com.snhu.sslserver;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

import org.apache.tomcat.util.buf.HexUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

}

@RestController
class ServerController{
//FIXME:  Add hash function to return the checksum value for the data string that should contain your name.    
    @RequestMapping("/hash")
    public String myHash() throws NoSuchAlgorithmException{
    	String data = "Hello William Cocomise!";
    	
    	byte[] dataAsBytes= data.getBytes();
    	MessageDigest hash = MessageDigest.getInstance("SHA-256");
    	byte[] hashedData = hash.digest(dataAsBytes);
    	String hashAsString = HexUtils.toHexString(hashedData);
		
		
		return "<p>data: " + data + "\n" + "<p>hash: " + hashAsString;
     
    }
}
