package hello;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerImpl implements MessageProducer {
	private static final Logger log = LoggerFactory.getLogger(MessageProducerImpl.class);
	@Autowired
	private ConfigurableApplicationContext context;
	
	public boolean produceMessage() {
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		log.info("Sending an email message.");
		jmsTemplate.convertAndSend("testqueue", new Email("info@example.com", "Hello", new Date(System.currentTimeMillis())));
		return true;

	}
	

}
