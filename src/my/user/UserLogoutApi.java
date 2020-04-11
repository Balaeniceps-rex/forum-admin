package my.user;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import af.web.restful.AfRestfulApi;
import my.db.User;

public class UserLogoutApi extends AfRestfulApi
{
	
	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		HttpSession ss = this.httpReq.getSession();
		ss.removeAttribute("user"); // 或者 ss.setAttribute("user", null);
		
		return null;
	}

}
