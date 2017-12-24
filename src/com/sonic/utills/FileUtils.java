package com.sonic.utills;

import java.io.File;

import com.sonic.service.BaseInfoService;

public class FileUtils {

	private FileReceiver fileReceiver;
	private FileWriter fileWriter;
	public FileUtils(File source,BaseInfoService userService){
		fileReceiver=new FileReceiver(source);
		fileWriter=new FileWriter(userService);
	}
	public boolean operateOfFileUtils() throws Exception{
		boolean isReceiveSuccessfully=false;
		boolean isWriteSuccessfully=false;
		isReceiveSuccessfully=fileReceiver.receive();
		isWriteSuccessfully=fileWriter.writeToDataBase();
		
		return isReceiveSuccessfully&&isWriteSuccessfully;
	}
	
}
