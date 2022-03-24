package com.example.ojsystem.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class read {
	//读文件
	public static String readFile(String filePath) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		FileInputStream fis = new FileInputStream(filePath);
		InputStreamReader isr = new InputStreamReader(fis,"utf-8");
		//逐一字节读取
		int cc = isr.read();
		while (cc != -1){
			cc = isr.read();
			stringBuilder.append((char) cc);
		}
		isr.close();
		return stringBuilder.toString();


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
	}

	public static void main(String[] args) throws IOException, InterruptedException, IOException {
		String STDERR = "F:\\IDEA_workspace\\test-web\\code\\test-web-server\\tmp\\6c66cacb-d59a-481f-83bf-79537b223087\\compile_error.txt";
		String runError = readFile(STDERR);
		System.out.println(runError);
	}
}
