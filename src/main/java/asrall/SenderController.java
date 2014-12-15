package asrall;

import java.lang.annotation.Annotation;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/send")
public class SenderController implements BeanFactoryAware {
	private AmqpTemplate aTemplate;
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String printSendForm(ModelMap model) {
		model.addAttribute("message", "Hello Spring MVC Framework!");

		return "sendForm";
	}

	@RequestMapping(value = "send", method = RequestMethod.POST)
	public String printSendACK(HttpServletRequest request,
			@RequestParam(value="nb_message", required=false) Integer nbMessage,
			@RequestParam(value="txt_message", required=false) String Message
					) {
        for (int i = 0; i < nbMessage; i++)
        	aTemplate.convertAndSend("Message # " +i +" on "+ new Date() + " : " + Message);
        
		return "msgSendACK";
	}

	public Class<? extends Annotation> annotationType() {
		// TODO Auto-generated method stub
		return null;
	}

	public String value() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setBeanFactory(BeanFactory context) throws BeansException {
		aTemplate = (AmqpTemplate) context.getBean("amqpTemplate");
		
	}

}
