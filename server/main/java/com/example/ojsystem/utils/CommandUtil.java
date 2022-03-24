package com.example.ojsystem.utils;

import java.io.*;

public class CommandUtil {
	//run方法表示用于进行创建进程并执行命令
	//cmd表示要执行的命令，
	//stdoutFile指定标准输出写到那个文件中
	//stderrFile指定标准错误写到那个文件中
	public static int run(String cmd, String stdoutFile, String stderrFile) throws IOException, InterruptedException {
		Process process = Runtime.getRuntime().exec(cmd);	//创建进程，并执行命令
		//对标准输出进行重定向
		if(stdoutFile != null){
			InputStream stdoutFrom = process.getInputStream();
			InputStreamReader stdoutfrom = new InputStreamReader(stdoutFrom, "gbk");
			//读取到当前新进程的标准输出的内容
			FileOutputStream stdoutTo = new FileOutputStream(stdoutFile);
			OutputStreamWriter stdoutto = new OutputStreamWriter(stdoutTo, "utf-8");
			char[] stdout = new char[1024];
			int stdoutLen;
			while(( stdoutLen = stdoutfrom.read(stdout)) != -1) {
				String s = new String(stdout, 0, stdoutLen);
				stdoutto.write(s);
			}
			//文件读写完毕，关闭文件
			stdoutfrom.close();
			stdoutto.close();
			stdoutFrom.close();
			stdoutTo.close();
		}

		//再针对标准错误进行重定向
		if(stderrFile != null){
			//getErrorStream得到的是标准错误
			InputStream stderrFrom = process.getErrorStream();
			InputStreamReader stderrfrom = new InputStreamReader(stderrFrom, "gbk");
			FileOutputStream stderrTo = new FileOutputStream(stderrFile);
			OutputStreamWriter stderrto = new OutputStreamWriter(stderrTo, "utf-8");
			char[] stderr = new char[1024];
			int stderrLen;
			while(( stderrLen = stderrfrom.read(stderr)) != -1) {
				String s = new String(stderr, 0, stderrLen);
				stderrto.write(s);
			}
			//文件读写完毕，关闭文件
			stderrfrom.close();
			stderrto.close();
			stderrFrom.close();
			stderrTo.close();
		}
		//等待新进程结束，并获取到退出码
		int exitCode = process.waitFor();
		return exitCode;
	}
}
//		//对标准输出进行重定向
//		if(stdoutFile != null){
//			InputStream stdoutFrom = process.getInputStream();
//			//读取到当前新进程的标准输出的内容
//			FileOutputStream stdoutTo = new FileOutputStream(stdoutFile);
//			//接下来从新进程中以此读取每个字节，写入到stdoutTo这个文件里
//			while (true){
//				int ch = stdoutFrom.read();
//				if(ch == -1){
//					break;
//				}
//				stdoutTo.write(ch);
//			}
//			//文件读写完毕，关闭文件
//			stdoutFrom.close();
//			stdoutTo.close();
//		}
//		//再针对标准错误进行重定向
//		if(stderrFile != null){
//			//getErrorStream得到的是标准错误
//			InputStream stderrFrom = process.getErrorStream();
//			FileOutputStream stderrTo = new FileOutputStream(stderrFile);
//			while (true){
//				int ch = stderrFrom.read();
//				if(ch == -1){
//					break;
//				}
//				stderrTo.write(ch);
//			}
//			stderrFrom.close();
//			stderrTo.close();
//		}
//遍历查看stderrFrom
//			for (int k = 0; k < stderrFrom.available(); ++k){
//				System.out.println(stderrFrom.read());
//				//stderrTo.write(stderrFrom.read());
//			}
//成功的例子1
//			int index;
//			byte[] bytes = new byte[1024];
//			while ((index = stderrFrom.read(bytes)) != -1) {
//				stderrTo.write(bytes, 0, index);
//				stderrTo.flush();
//			}
