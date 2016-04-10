package com.itheima.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;

import com.itheima.domain.NewsItem;

public class NewsItemParser {
	
	public static List<NewsItem> getNewsItems(InputStream is){
		
		try {
			//创建一个xml文件的解析器
			XmlPullParser parser = Xml.newPullParser();
			//使用解析解析输入流
			parser.setInput(is, "UTF-8");
			
			List<NewsItem> newsItems = new ArrayList<NewsItem>();
			NewsItem item =null;
			//获取解析事件的类型
			int type = parser.getEventType();
			while(type != XmlPullParser.END_DOCUMENT){
				switch (type) {
				//解析到标签的开始位置
				case XmlPullParser.START_TAG:
					if("item".equals(parser.getName())){
						item = new NewsItem();
					}else if("title".equals(parser.getName())){
						String title = parser.nextText();
						item.setTitle(title);
					}else if("description".equals(parser.getName())){
						String description = parser.nextText();
						item.setDescription(description);
					}else if("image".equals(parser.getName())){
						String image = parser.nextText();
						item.setImage(image);
					}else if("type".equals(parser.getName())){
						String newsType = parser.nextText();
						item.setType(newsType);
					}else if("comment".equals(parser.getName())){
						String comment = parser.nextText();
						item.setComment(comment);
					}
					
					break;
					//解析到标签的结束位置
				case XmlPullParser.END_TAG:
					if("item".equals(parser.getName())){
						newsItems.add(item);
						item = null;
					}
					break;

				}
				//一对标签解析结束后，设置下一个解析事件
				type = parser.next();
			}
			
			return newsItems;
		} catch (Exception e) {
			return null;
		}
	
	}

}
