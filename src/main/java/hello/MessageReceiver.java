package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
	private static final Logger log = LoggerFactory.getLogger(MessageReceiver.class);
	@JmsListener(destination = "testqueue", containerFactory = "myFactory")
	public void receiveMessage(Email email) {
		log.info("Received <" + email + ">");
	}
}
