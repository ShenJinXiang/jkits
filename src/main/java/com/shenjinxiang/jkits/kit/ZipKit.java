package com.shenjinxiang.jkits.kit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipKit {

	/**
	 * zip压缩字符串，并BASE64处理后返回结果字符串 字符集 utf-8
	 * @param str
	 * @return
	 */
	public static byte[] compress(byte[] data) {
		ByteArrayOutputStream bout = null;
		ZipOutputStream zout = null;
		
		try {
			bout = new ByteArrayOutputStream();
			zout = new ZipOutputStream(bout);
			zout.putNextEntry(new ZipEntry("0"));
			zout.write(data);
			
			zout.flush();
			bout.flush();
			zout.closeEntry();
			return bout.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if(zout != null) {
				try {
					zout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(bout != null) {
				try {
					bout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * base64解码，zip解压缩字符串，并返回结果
	 * @param str
	 * @return
	 */
	public static byte[] decompress(byte[] data) {
		ByteArrayOutputStream bout = null;
		ByteArrayInputStream bin = null;
		ZipInputStream zin = null;
		try {
			bout = new ByteArrayOutputStream();
			bin = new ByteArrayInputStream(data);
			zin = new ZipInputStream(bin);
			zin.getNextEntry();
			byte[] buffer = new byte[1024];
			int offset = -1;
			while((offset = zin.read(buffer)) != -1) {
				bout.write(buffer, 0, offset);
			}
			bout.flush();
			
			return bout.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if(bout != null) {
				try {
					bout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(zin != null) {
				try {
					zin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(bin != null) {
				try {
					bin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		String msg = "我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！我是一个好人，真的是个好人！";
		System.out.println("zip压缩前的长度：" + msg.getBytes().length);
		byte[] bs1 = ZipKit.compress(msg.getBytes());
		String result = Base64Kit.encode(bs1);
		System.out.println("压缩后的内容：\n" + result);
		System.out.println("压缩后的长度：\n" + bs1.length);
		String msg1 = new String(ZipKit.decompress(bs1));
		System.out.println("解压缩后的内容：\n" + msg1);
		System.out.println("解压缩后的长度：\n" + msg1.getBytes().length);
	}
}
