//package com.example.ojsystem.test;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class write {
//	public static String writeFile(String filePath) throws IOException {
//
//
//		FileOutputStream stderrTo = new FileOutputStream(stderrFile);
//			while (true){
//				int ch = stderrFrom.read();
//				if(ch == -1){
//					break;
//				}
//				stderrTo.write(ch);
//			}
//		stderrFrom.close();
//		stderrTo.close();
//		return filePath;
//	}
//
//	public static void main(String[] args) throws IOException, InterruptedException, IOException {
//		String STDERR = "F:\\IDEA_workspace\\test-web\\code\\test-web-server\\tmp\\6c66cacb-d59a-481f-83bf-79537b223087\\stderr.txt";
//		String runError = writeFile(STDERR);
//		System.out.println(runError);
//	}
//}
