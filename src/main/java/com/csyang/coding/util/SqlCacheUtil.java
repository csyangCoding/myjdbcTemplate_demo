package com.csyang.coding.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class SqlCacheUtil {

	public static String sqlFilePath = "config/dbsql.xml";

	public static Map<String, String> sqlMap = new HashMap<>();

	public static void initSql() {
		List<Element> list = getXML().selectNodes("SQL/VALUE");
		for (Element element : list) {
			String sql = element.getTextTrim();
			String key = element.attributeValue("name").trim();
			sqlMap.put(key, sql);
		}
	}

	public static Document getXML() {
		Document document = null;
		SAXReader reader = new SAXReader();
		try {
			document = reader.read(SqlCacheUtil.class.getClassLoader().getResourceAsStream(sqlFilePath));
		} catch (DocumentException e) {
			System.out.println("获取xml " + sqlFilePath + " 文件失败！");
			e.printStackTrace();
		}
		return document;
	}

	public static String getSql(String sqlKey) {
		if (sqlMap.isEmpty()) {
			initSql();
		}
		return sqlMap.get(sqlKey);
	}
}
