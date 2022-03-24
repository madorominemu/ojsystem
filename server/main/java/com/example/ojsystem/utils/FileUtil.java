package com.example.ojsystem.utils;

import java.io.*;

public class FileUtil {
//	//从指定的文件中一次拿所有的内容读出来
//	public static String readFile(String filePath) {
//		StringBuilder stringBuilder = new StringBuilder();
//		try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
//			while (true) {
//				int ch = fileInputStream.read();
//				if (ch == -1) {
//					break;
//				}
//				stringBuilder.append((char)ch);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return stringBuilder.toString();
//	}

	//从指定的文件中一次拿所有的内容读出来
	public static String readFile(String filePath) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		FileInputStream fileInputStream = new FileInputStream(filePath);
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"utf-8");
		//逐一字节读取
		while (true) {
			int ch = inputStreamReader.read();
			if (ch == -1) {
				break;
			}
			stringBuilder.append((char) ch);
		}
		inputStreamReader.close();
		return stringBuilder.toString();
	}

	//进行写文件操作
	public static void writeFile(String filePath, String content) {
		try(FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
			fileOutputStream.write(content.getBytes());
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
