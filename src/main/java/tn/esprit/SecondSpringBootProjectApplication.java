package tn.esprit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootApplication
public class SecondSpringBootProjectApplication {

	public static void main(String[] args) {
		try {
		java.security.Security.setProperty("jdk.tls.disabledAlgorithms", "");
		SpringApplication.run(SecondSpringBootProjectApplication.class, args);
		}catch (Exception e) {
			//log.error("open appache server  and mysql or see trace of exception  " );
			e.getStackTrace();
		}
	}

}
