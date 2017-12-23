package com.sonic.utills;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class FileReceiver {
	private File source;
	public boolean isFinish=false;
	public FileReceiver(File source) {
		this.source = source;
	}
	public boolean receive() throws Exception{
		isFinish=false;
		if (source != null && source.isFile()) {
			String uploadPath = ServletActionContext.getServletContext()
					.getRealPath("/") ;
			File dir = new File(uploadPath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File destFile = new File(uploadPath, "templeate.xls");
			FileUtils.copyFile(source, destFile);
			System.out.println("upload ok");
			isFinish=true;
		}
		return isFinish;
	}
}
