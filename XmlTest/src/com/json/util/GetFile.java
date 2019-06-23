package com.json.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.LinkedList;

//��ȡ�ļ��������е�.xml�ļ�
public class GetFile {
	public String[] getFiles(File file) {
		String[] files = file.list(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.indexOf(".xml") != -1;// ɸѡ����Ҫ�ĸ�ʽ
			}
		});
		return files;
	}

	/*
	 * public String[] name() { GetFile getFile = new GetFile(); File file = new
	 * File("E://repo//XxwGit.github.io//_includes//XmlTest"); String[] fileString =
	 * null; for (int i = 0; i < getFile.getFiles(file).length; i++) { fileString[i]
	 * =
	 * "E://repo//XxwGit.github.io//_includes//XmlTest"+"//"+getFile.getFiles(file)[
	 * i]; } return fileString; }
	 */
	public static void main(String[] args) {
		GetFile getFile = new GetFile();
		File file = new File("E://repo//XxwGit.github.io//_includes//XmlTest");
		for (String string : getFile.getFiles(file)) {
			System.out.println(string);
		}
	}
}