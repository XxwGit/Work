package com.json.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileTest {
	private static List<File> func(File file) {
		File[] fs = file.listFiles();
		List<File> files = new ArrayList<File>();
		for (File f : fs) {
			if (f.isDirectory()) // ����Ŀ¼����ݹ��ӡ��Ŀ¼�µ��ļ�
				func(f);
			if (f.isFile()) // �����ļ���ֱ�Ӵ�ӡ
				files.add(f);
				System.out.println(f);

		}
		return files;
	}

	public static void main(String[] args) {
		String inputPath = "E:\\test";// Ҫ������·��
		File file = new File(inputPath); // ��ȡ��file����
		List<File> files = func(file);
		for (File file2 : files) {
			System.out.println(file2);
		}
	}
}