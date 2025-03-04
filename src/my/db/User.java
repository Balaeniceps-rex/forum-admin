package my.db; 

import af.sql.annotation.AFCOLUMNS; 
import af.sql.annotation.AFTABLE; 
import java.util.Date; 

// 本类由 【POJO生成器】 自动生成 ：2019-06-27 09:30:57

@AFTABLE(name="user")  
@AFCOLUMNS(auto=true,generated="id") 
public class User 
{ 
 
	public Integer id ; 
	public String username ; 
	public String password ; 
	public String email ; 
	public Boolean canRead ; 
	public Boolean canPost ; 
	public Boolean canReply ; 
	public Integer level ; 
	public Date timeCreated ; 


	public void setId(Integer id)
	{
		this.id=id;
	}
	public Integer getId()
	{
		return this.id;
	}
	public void setUsername(String username)
	{
		this.username=username;
	}
	public String getUsername()
	{
		return this.username;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public String getPassword()
	{
		return this.password;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getEmail()
	{
		return this.email;
	}
	public void setCanRead(Boolean canRead)
	{
		this.canRead=canRead;
	}
	public Boolean getCanRead()
	{
		return this.canRead;
	}
	public void setCanPost(Boolean canPost)
	{
		this.canPost=canPost;
	}
	public Boolean getCanPost()
	{
		return this.canPost;
	}
	public void setCanReply(Boolean canReply)
	{
		this.canReply=canReply;
	}
	public Boolean getCanReply()
	{
		return this.canReply;
	}
	public void setLevel(Integer level)
	{
		this.level=level;
	}
	public Integer getLevel()
	{
		return this.level;
	}
	public void setTimeCreated(Date timeCreated)
	{
		this.timeCreated=timeCreated;
	}
	public Date getTimeCreated()
	{
		return this.timeCreated;
	}

} 
 