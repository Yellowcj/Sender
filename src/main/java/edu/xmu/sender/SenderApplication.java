package edu.xmu.sender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: YellowPure
 * @Description: 使用AmqpTemplate去发送消息
 * @Date: Created in 20:55 2017/11/8
 */
@SpringBootApplication
public class SenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SenderApplication.class, args);
	}
}
