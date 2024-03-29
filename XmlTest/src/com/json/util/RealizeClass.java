package com.json.util;

import java.io.File;

public class RealizeClass {
	public void Xml2Json(String sourseFile,String targetFile,int i) {
		GetFile getFile = new GetFile();
		File file = new File(sourseFile);
		//File file = new File("E://repo//XxwGit.github.io//_includes//XmlTest");
		String[] files = getFile.getFiles(file);
		GetXml getXml = new GetXml();
		String jsonName = getXml.getName(sourseFile+"//"+files[i]);
		//String jsonName = getXml.getName("E://repo//XxwGit.github.io//_includes//XmlTest"+"//"+files[6]);
		System.out.println(jsonName);
		Xml2Json xml2Json = new Xml2Json();
		//1.获取xml转json后的String文件
		String jsonString = xml2Json.name(sourseFile+"//"+files[i]);
		//String jsonString = xml2Json.name("E://repo//XxwGit.github.io//_includes//XmlTest"+"//"+files[6]);
		//2.将String文件格式化
		FormatUtil formatUtil = new FormatUtil();
		String formateString = formatUtil.formatJson(jsonString);
		//3.将格式化的文件写入文件中进行保存
		SetJson setJson = new SetJson();
		String filString = setJson.Fetch(formateString, targetFile+"//"+jsonName);
		//String filString = setJson.Fetch(formateString, "E://test"+"//"+jsonName);
	}
	
	public int getLength(String sourseFile) {
		GetFile getFile = new GetFile();
		File file = new File(sourseFile);
		//File file = new File("E://repo//XxwGit.github.io//_includes//XmlTest");
		String[] files = getFile.getFiles(file);
		return files.length;
	}
	public static void main(String[] args) {
		RealizeClass realizeClass = new RealizeClass();
		int length = realizeClass.getLength("E://repo//XxwGit.github.io//_includes//XmlTest");
		System.out.println(length);
	}
}
