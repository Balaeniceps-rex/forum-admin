package my.user;

import java.util.Date;

import org.json.JSONObject;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import af.sql.c3p0.AfSimpleDB;
import af.web.restful.AfRestfulApi;
import my.db.User;

public class UserRegisterApi extends AfRestfulApi
{

	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		String username = jreq.getString("username");
		String password = jreq.getString("password");
		
		User row = new User();
		row.setUsername( username);
		row.setPassword( password);
		row.setCanPost(true);
		row.setCanRead(true);
		row.setCanReply(true);
		row.setLevel(0);
		row.setTimeCreated(new Date());
		
		// 插入一条记录
		try{
			AfSimpleDB.insert( row );
		}catch(MySQLIntegrityConstraintViolationException e)
		{
			// 注：af_forum.user 表里设置了一个唯一索引，禁止username字段重复
			// 否则抛出 com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException
			throw new Exception("用户名重复!");
		}
		
		return null;
	}

}
