package com.googlecode.greysanatomy.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Scanner;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

/**
 * �ַ�������������
 * @author vlinux
 *
 */
public class GaStringUtils {

	public static final String LINE = "---------------------------------------------------------------\n";
	
	/**
	 * ����URL-ENCODE
	 * @param str
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String encode(String str) throws UnsupportedEncodingException {
		if( StringUtils.isBlank(str) ) {
			return StringUtils.EMPTY;
		}
		return URLEncoder.encode(str, "utf-8");
	}
	
	/**
	 * ����URL-DECODE
	 * @param str
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String decode(String str) throws UnsupportedEncodingException {
		if( StringUtils.isBlank(str) ) {
			return StringUtils.EMPTY;
		}
		return URLDecoder.decode(str, "utf-8");
	}

	/**
	 * ����һ���ַ���
	 * @param obj
	 * @return
	 */
	public static String newString(Object obj) {
		if( null == obj ) {
			return StringUtils.EMPTY;
		}
		return obj.toString();
	}
	
	/**
	 * չʾlogo
	 * @return
	 */
	public static String getLogo() {
		final StringBuilder logoSB = new StringBuilder();
		final Scanner scanner = new Scanner(Object.class.getResourceAsStream("/com/googlecode/greysanatomy/res/logo.txt"));
		while( scanner.hasNextLine() ) {
			logoSB.append(scanner.nextLine()).append("\n");
		}
		return logoSB.toString();
	}
	
	/**
	 * �����
	 * @param sb
	 * @param c
	 * @param str
	 */
	public static void rightFill(StringBuilder sb, int c, String str) {
		for( int i=0; i<c; i++ ) {
			sb.append(str);
		}
	}
	
	/**
	 * ��ȡ����ִ�ж�ջ��Ϣ
	 * @return
	 */
	public static String getStack() {
		final StackTraceElement[] stes = Thread.currentThread().getStackTrace();
		final StringBuilder stSB = new StringBuilder()
			.append("Thread Info:").append(Thread.currentThread().getName()).append("\n");
		
		if( ArrayUtils.isEmpty(stes) 
				|| stes.length == 1) {
			return stSB.toString();
		}
		
		for( int index = 4; index < stes.length; index++ ) {
			final StackTraceElement ste = stes[index];
			stSB.append(index==2?"  ":"    at ")
				.append(ste.getClassName()).append(".")
				.append(ste.getMethodName())
				.append("(").append(ste.getFileName()).append(":").append(ste.getLineNumber()).append(")\n");
		}
		
		return stSB.toString();
	}
	
	public static void main(String... args) {
		System.out.println( getStack() );
	}
	
}
