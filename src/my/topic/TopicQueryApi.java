package my.topic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import af.web.restful.AfRestfulApi;

public class TopicQueryApi extends AfRestfulApi
{
/* 双表联合查询 示范
SELECT a.id, a.title, a.timeCreated, b.username 
FROM topic a
LEFT JOIN `user` b
ON a.userId=b.id
ORDER BY a.id DESC
LIMIT 30
*/
	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
//		// 查询条件 (暂无)
//		AfSqlWhere asw = new AfSqlWhere(); 		
//		// 排序
//		String order = " ORDER BY ID DESC ";
//		// 条数限制
//		String limit = " LIMIT 30 ";
//		
//		// 双表联合查询
//		String sql = " SELECT a.id, a.title, a.timeCreated, b.username "
//				+ " FROM topic a LEFT JOIN `user` b "
//				+ " ON a.userId=b.id "
//				+ asw
//				+ order
//				+ limit;
//		System.out.println("查询: " + sql);
//		
//		// 返回的是原生结果，每行数据是一个 String[]
//		List<String[]> rows = AfSimpleDB.executeQuery(sql);
//		
//		// 处理为前端需要的结果
//		JSONArray jdata = new JSONArray();
//		for(int i=0; i<rows.size(); i++)
//		{
//			String[] row = rows.get(i);			
//			JSONObject j1 = new JSONObject();
//			
//			int k=0;
//			j1.put("id", row[k++]); //帖子id, 不转成Long也可以
//			j1.put("title", row[k++]);
//			j1.put("timeCreated", row[k++]);
//			j1.put("username", row[k++]);
//			
//			jdata.put( j1 );
//		}
		
		// 从缓存中取得列表	
		List<RecentTopic.Item> list = RecentTopic.i.getList();
		
		// 格式化为 JSON 返回
		JSONArray jdata = new JSONArray();
		for(int i=0; i<list.size(); i++)
		{
			RecentTopic.Item item = list.get(i);
			JSONObject j1 = new JSONObject();
			j1.put("id", item.id);
			j1.put("title", item.title);
			j1.put("timeCreated", item.timeCreated);
			j1.put("username",item.username);
			
			jdata.put(j1);
		}
		
		return jdata;
	}
	
}
