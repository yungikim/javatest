package ltpatoken;

import javax.security.auth.Subject;

import com.ibm.websphere.security.auth.WSSubject;
import com.ibm.websphere.security.auth.callback.WSCallbackHandlerImpl;
import com.ibm.websphere.security.cred.WSCredential;

public class ltpa {

	public static void main(String[] args) {
		try {
			String user = "dosa777";
			String password = "0";
			
			WSCallbackHandlerImpl callbackHandler = new WSCallbackHandlerImpl();
			callbackHandler.handle(new String[] {user, password});

			Subject subject = WSSubject.getCallerSubject();
			WSCredential credential = (WSCredential) subject.getPrivateCredentials().iterator().next();

			String token = credential.getLtpaToken();
			System.out.println("LTPA Token: " + token);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
