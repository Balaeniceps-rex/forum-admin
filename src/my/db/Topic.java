package my.db; 

import af.sql.annotation.AFCOLUMNS; 
import af.sql.annotation.AFTABLE; 
import java.util.Date; 

// 本类由 【POJO生成器】 自动生成 ：2019-06-27 09:30:57

@AFTABLE(name="topic")  
@AFCOLUMNS(auto=true,generated="id") 
public class Topic 
{ 
 
	public Long id ; 
	public String title ; 
	public Integer userId ; 
	public String content ; 
	public Integer numView ; 
	public Integer numReply ; 
	public Byte flagTop ; 
	public Byte flagNice ; 
	public Date timeCreated ; 
	public Date timeMofified ; 


	public void setId(Long id)
	{
		this.id=id;
	}
	public Long getId()
	{
		return this.id;
	}
	public void setTitle(String title)
	{
		this.title=title;
	}
	public String getTitle()
	{
		return this.title;
	}
	public void setUserId(Integer userId)
	{
		this.userId=userId;
	}
	public Integer getUserId()
	{
		return this.userId;
	}
	public void setContent(String content)
	{
		this.content=content;
	}
	public String getContent()
	{
		return this.content;
	}
	public void setNumView(Integer numView)
	{
		this.numView=numView;
	}
	public Integer getNumView()
	{
		return this.numView;
	}
	public void setNumReply(Integer numReply)
	{
		this.numReply=numReply;
	}
	public Integer getNumReply()
	{
		return this.numReply;
	}
	public void setFlagTop(Byte flagTop)
	{
		this.flagTop=flagTop;
	}
	public Byte getFlagTop()
	{
		return this.flagTop;
	}
	public void setFlagNice(Byte flagNice)
	{
		this.flagNice=flagNice;
	}
	public Byte getFlagNice()
	{
		return this.flagNice;
	}
	public void setTimeCreated(Date timeCreated)
	{
		this.timeCreated=timeCreated;
	}
	public Date getTimeCreated()
	{
		return this.timeCreated;
	}
	public void setTimeMofified(Date timeMofified)
	{
		this.timeMofified=timeMofified;
	}
	public Date getTimeMofified()
	{
		return this.timeMofified;
	}

} 
 