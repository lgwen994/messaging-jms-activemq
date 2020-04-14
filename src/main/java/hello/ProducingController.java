package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
public class ProducingController {

	@Autowired
	private MessageProducer producer;

	@RequestMapping(path = "produce", method = RequestMethod.GET)
	public String produceMessage() {
		if (producer.produceMessage()) {
		return "Sending an email message.";
		} else {
			return "error";
		}
	}

}
