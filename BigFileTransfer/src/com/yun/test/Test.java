package com.yun.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
	
	public static void main(String[] args) {
		DataInputStream in = null;

        DataOutputStream out = null;

        try{

            out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("data.bin")));// 설명
            out.writeDouble(Math.PI);
            out.writeInt(100);
            out.writeUTF("UTF 형식 문구~~@");// 설명
            out.flush();

 

            in = new DataInputStream(new BufferedInputStream(new FileInputStream("data.bin")));// 파일 스트림 > 버퍼스트림 > 데이터 스트림
            System.out.println(in.readDouble());
            System.out.println(in.readInt());
            System.out.println(in.readUTF());
            
        }catch(Exception e) {
        	e.printStackTrace();

        }finally{

            if(in != null)
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

            if(out != null)
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

        }
	}

	public Test() {
		
	}

}
