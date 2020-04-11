package my.user;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import af.sql.c3p0.AfSimpleDB;
import af.sql.util.*;
import af.web.restful.AfRestfulApi;
import my.db.User;

public class UserLoginApi extends AfRestfulApi
{
	
	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		String username = jreq.getString("username");
		String password = jreq.getString("password");
		
		// 查询数据库
		AfSqlWhere asw = new AfSqlWhere();
		asw.add2("username", username);
		
		String sql = "select * from user " + asw;
		System.out.println("登录查询: " + sql);
		User row = (User) AfSimpleDB.get(sql, User.class);
		
		// 认证
		if(row == null)
		{
			throw new Exception("无此用户, username=" + username);
		}
		else if(! row.getPassword().equals(password))
		{
			throw new Exception("密码不匹配!");
		}
		
		// 把用户信息保存到当前会话
		HttpSession ss = this.httpReq.getSession();
		ss.setAttribute("user", row); // 放一个User对象
		
		return null;
	}

}
