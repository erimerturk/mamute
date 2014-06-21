package org.mamute.controllers;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.routes.annotation.Routed;
import org.mamute.validators.UrlValidator;

import javax.inject.Inject;

@Routed
@Controller
public class GoogleAuthController extends BaseController{
	
//	@Inject @Google private OAuthService service;
	@Inject private UrlValidator urlValidator;
	@Inject private LoginMethodManager loginManager;
	
	@Get
	public void signUpViaGoogle(String redirect, String code) {
//		Token token = service.getAccessToken(null, new Verifier(code));
//		SocialAPI googleAPI = new GoogleAPI(token, service);
//
//		loginManager.merge(MethodType.GOOGLE, googleAPI);
//
//	    redirectToRightUrl(redirect);
	}
	
	private void redirectToRightUrl(String state) {
		boolean valid = urlValidator.isValid(state);
		if (!valid) {
			includeAsList("messages", i18n("error", "error.invalid.url", state));
		}
        if (state != null && !state.isEmpty() && valid) {
            redirectTo(state);
        } else {
            redirectTo(ListController.class).home(null);
        }
	}
}
