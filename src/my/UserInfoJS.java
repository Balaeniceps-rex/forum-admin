package my;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import my.db.User;

@WebServlet("/UserInfoJS")
public class UserInfoJS extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{	
		HttpSession ss = req.getSession();		
		User user = (User)ss.getAttribute("user");
		
		// 构造JS
		String jsContent = null;
		if( user == null)
		{
			// 尚未登录
			jsContent = "var user = null;";
		}
		else
		{
			JSONObject json = new JSONObject( user );
			json.remove("password"); // 去掉一些前端用不到的、或者敏感字段
			json.remove("timeCreated");
			
			jsContent = "var user = " + json.toString(2) + " ; ";
		}
				
		// 应答
		resp.setContentType("application/javascript");
		resp.setCharacterEncoding("UTF-8");
		resp.addHeader ("Cache-Control", "no-cache"); // 禁止客户端缓存此文件
		resp.getWriter().print( jsContent );
	}
}
