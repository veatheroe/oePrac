package s.oe.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileExample {
	public static void main(String[] args){
		createFile();
	}
	
	public static void createFile(){
		int readInput = 0;
		byte[] buffer = new byte[512];
		FileInputStream input = null;
		FileOutputStream output = null;
		try{
//			f.createNewFile();
//			System.out.println("�÷�����СΪ��"+f.getTotalSpace()/(1024*1024*1024)+"G");
//			f.mkdir();
//			System.out.print("�ļ�����"+f.getName());
//			System.out.print("�����ļ�����"+f.getParent());
			input = new FileInputStream(new File("D:\\win64\\doc\\ECNU\\�μ�\\Lecture03.pdf"));
			output = new FileOutputStream(new File("D:\\garbage\\maudeisdifficult.pdf"));
			//����Ϊʲô��readInput
			while((readInput=input.read(buffer))!=-1)
				output.write(buffer, 0, readInput);
		}catch(final Exception e){
			e.printStackTrace();
		}finally{
			try{
				input.close();
				output.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			
		}
	}
}
