package com.json.realize;

import com.json.util.FormatUtil;
import com.json.util.GetXml;
import com.json.util.SetJson;
import com.json.util.Xml2Json;

public class FileRealize {
	public void XmlToJson(String fileName, String targetFolder) {
		GetXml getXml = new GetXml();
		String jsonName = getXml.getName(fileName);

		Xml2Json xml2Json = new Xml2Json();
		// 1.获取xml转json后的String文件
		String jsonString = xml2Json.XmlToJson(fileName);

		// 2.将String文件格式化
		FormatUtil formatUtil = new FormatUtil();
		String formateString = formatUtil.formatJson(jsonString);
		// 3.将格式化的文件写入文件中进行保存
		SetJson setJson = new SetJson();
		setJson.Fetch(formateString, targetFolder + "//" + jsonName);
	}
}
