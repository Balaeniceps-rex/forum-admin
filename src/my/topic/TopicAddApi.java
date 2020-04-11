package my.topic;

import java.util.Date;

import org.json.JSONObject;

import af.sql.c3p0.AfSimpleDB;
import af.web.restful.AfRestfulApi;
import my.db.Topic;
import my.db.User;

public class TopicAddApi extends AfRestfulApi
{

	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		String title = jreq.getString("title");
		String content = jreq.getString("content");
		
		// 从当前会话里取得当前用户信息
		User user = (User) httpReq.getSession().getAttribute("user");
		if(user == null)
			throw new Exception("请先登录!");
		if( ! user.canPost )
			throw new Exception("已被禁言，不能发帖");
		
		// 准备数据
		Topic topic = new Topic();
		topic.setContent(content);
		topic.setTitle(title);
		topic.setUserId(user.getId()); // 注意：取当前用户的ID
		topic.setTimeCreated(new Date());
		topic.setTimeMofified(new Date());
		
		topic.setFlagNice((byte)0);
		topic.setFlagTop((byte)0);
		topic.setNumReply(0);;
		topic.setNumView(0);;
		
		// 插入数据库
		AfSimpleDB.insert( topic );
		
		// 更新最近列表
		RecentTopic.i.add(topic, user);
		
		// 应答
		JSONObject jdata = new JSONObject();
		jdata.put("id", topic.getId()); // 帖子的ID		
		return jdata;
	}
	
}
