package com.json.test;

import java.io.File;

public class FileTest2 {
	//pathname������ʾ�Լ��ƶ����ļ�·����
	public static void m1(String pathname) {
		//�Ƚ�ָ��·���µ������ļ�ʵ����
		File file = new File(pathname);
		//�ж�ʵ�����Ķ���file�Ƿ���ڣ���ָ��·���Ƿ����
		if (!file.exists()) {
			//��file�����ڣ����׳��쳣
			throw new IllegalArgumentException("Ŀ¼" + pathname + "������");
		}
		//���ļ����ڣ��������ļ���ʵ��������ת��Ϊ������ʽ
		File[] files = file.listFiles();
		//�����ļ�����
		for (File file2 : files) {
			//������������ó�����ֵ��File���ļ����ͣ���ֱ���ȴ�ӡ����ļ���·������
			System.out.println(file2.getPath());
			//������ó�����File���ļ������ͣ��͵����Լ������õݹ��˼�룬��һ��һ��ش�
			if (file2.isDirectory()) {
				//�����Լ�ʱ����Ĳ���Ϊ��һ���жϳ������ļ���·��
				m1(file2.getAbsolutePath());
			}

		}
	}
	public static void main(String[] args) {
		FileTest2.m1("E:\\");
	}
}