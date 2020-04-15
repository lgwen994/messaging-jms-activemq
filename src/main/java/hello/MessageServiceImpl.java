package hello;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
	private static final Logger log = LoggerFactory.getLogger(MessageServiceImpl.class);
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public boolean produceMessage() {
		log.info("Sending an email message.");
		jmsTemplate.convertAndSend("testqueue", new Email("info@example.com", "Hello", new Date(System.currentTimeMillis())));
		return true;
	}

	public String receiveMessage() {
			jmsTemplate.setReceiveTimeout(2000);
		String receiveMessage;
		Object result = jmsTemplate.receiveAndConvert("testqueue");
		if(result == null) {
			receiveMessage = "timeout, there is no message in the quene.";
		} else {
			receiveMessage = result.toString();
		}

			log.info(receiveMessage);

		return receiveMessage;
	}


}
