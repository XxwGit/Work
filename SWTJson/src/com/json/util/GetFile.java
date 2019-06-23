package com.json.util;

import java.io.File;
import java.io.FilenameFilter;

//获取文件夹中所有的.xml文件
public class GetFile {
	public String[] getFiles(File file) {
		String[] files = file.list(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.indexOf(".xml") != -1;// 筛选出需要的格式
			}
		});
		return files;
	}
}
