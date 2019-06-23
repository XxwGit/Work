package com.json.realize;

import java.io.File;

import com.json.util.FormatUtil;
import com.json.util.GetFile;
import com.json.util.GetXml;
import com.json.util.SetJson;
import com.json.util.Xml2Json;

public class FileRealize {
	public void XmlToJson(String fileName, String targetFolder) {
		GetXml getXml = new GetXml();
		String jsonName = getXml.getName(fileName);

		Xml2Json xml2Json = new Xml2Json();
		// 1.��ȡxmlתjson���String�ļ�
		String jsonString = xml2Json.XmlToJson(fileName);

		// 2.��String�ļ���ʽ��
		FormatUtil formatUtil = new FormatUtil();
		String formateString = formatUtil.formatJson(jsonString);
		// 3.����ʽ�����ļ�д���ļ��н��б���
		SetJson setJson = new SetJson();
		String filString = setJson.Fetch(formateString, targetFolder + "//" + jsonName);
	}
	public static void main(String[] args) {
		FileRealize fileRealize = new FileRealize();
		fileRealize.XmlToJson("E:\\repo\\XxwGit.github.io\\_includes\\XmlTest\\test.xml", "E://test");
	}
}