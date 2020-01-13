package com.shenjinxiang.jkits.kit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipKit {

	public static final int BUFFER = 1024;
	public static final String EXT = ".gz";
	
	public static byte[] compress(byte[] data) {
		byte[] output = null;
		ByteArrayInputStream bais = null;
		ByteArrayOutputStream baos = null;
		GZIPOutputStream gos = null;
		
		try {
			bais = new ByteArrayInputStream(data);
			baos = new ByteArrayOutputStream();
			gos = new GZIPOutputStream(baos);
			int count = -1;
			byte[] buffer = new byte[BUFFER];
			while((count = bais.read(buffer)) != -1) {
				gos.write(buffer, 0, count);
			}
			gos.finish();
			gos.flush();
			
			output = baos.toByteArray();
			return output;
		} catch (IOException e) {
			
		} finally {
			if(bais != null) {
				try {
					bais.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(baos != null) {
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(gos != null) {
				try {
					gos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return output;
	}
	
	
	public static byte[] decompress(byte[] data) {
		byte[] output = null;
		ByteArrayInputStream bais = null;
		ByteArrayOutputStream baos = null;
		GZIPInputStream gis = null;
		try {
			bais = new ByteArrayInputStream(data);
			baos = new ByteArrayOutputStream();
			gis = new GZIPInputStream(bais);
			int count = -1;
			byte[] buffer = new byte[BUFFER];
			while((count = gis.read(buffer)) != -1) {
				baos.write(buffer, 0, count);
			}
			baos.flush();
			output = baos.toByteArray();
			return output;
		} catch (IOException e) {
			
		} finally {
			if(bais != null) {
				try {
					bais.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(gis != null) {
				try {
					gis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(baos != null) {
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return output;
	}

}
