package mz.pled.mgr.service;


import com.twilio.Twilio;
import com.twilio.exception.AuthenticationException;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.stereotype.Service;

@Service
public class SMSService {
	
	public static final String ACCOUNT_SID = "AC210a20618423ed1ec9fabcd1a047dc9c";
	//public static final String ACCOUNT_SID = "SMe114e44d972e4362a10f97c3590ce380";
    public static final String AUTH_TOKEN = "7702518facc3a68aa82f2911b8b8816c";
    public void sendSMS(String telefone,String mensagem) throws AuthenticationException {

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                //new MYCOMPANY
                new com.twilio.type.PhoneNumber(telefone),
                new com.twilio.type.PhoneNumber("MGa7c0db649ff0f14a5d7f8296ae590c39"),
                //new com.twilio.type.PhoneNumber("+19107084699"),
               // new com.twilio.type.PhoneNumber("+18555944611"),
                mensagem)
                .create();

        System.out.println(message.getSid());

    }

}
