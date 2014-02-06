package com.pet.demo.core.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Exceptions {
	/**
	 * 灏咰heckedException杞崲涓篣ncheckedException.
	 */
	public static RuntimeException unchecked(Throwable ex) {
		if (ex instanceof RuntimeException) {
			return (RuntimeException) ex;
		} else {
			return new RuntimeException(ex);
		}
	}

	/**
	 * 灏咵rrorStack杞寲涓篠tring.
	 */
	public static String getStackTraceAsString(Throwable ex) {
		StringWriter stringWriter = new StringWriter();
		ex.printStackTrace(new PrintWriter(stringWriter));
		return stringWriter.toString();
	}

	/**
	 * 鑾峰彇缁勫悎鏈紓甯镐俊鎭笌搴曞眰寮傚父淇℃伅鐨勫紓甯告弿杩� 閫傜敤浜庢湰寮傚父涓虹粺涓�寘瑁呭紓甯哥被锛屽簳灞傚紓甯告墠鏄牴鏈師鍥犵殑鎯呭喌銆�	 */
	public static String getErrorMessageWithNestedException(Throwable ex) {
		Throwable nestedException = ex.getCause();
		return new StringBuilder().append(ex.getMessage()).append(" nested exception is ")
				.append(nestedException.getClass().getName()).append(":").append(nestedException.getMessage())
				.toString();
	}

	/**
	 * 鑾峰彇寮傚父鐨凴oot Cause.
	 */
	public static Throwable getRootCause(Throwable ex) {
		Throwable cause;
		while ((cause = ex.getCause()) != null) {
			ex = cause;
		}
		return ex;
	}

	/**
	 * 鍒ゆ柇寮傚父鏄惁鐢辨煇浜涘簳灞傜殑寮傚父寮曡捣.
	 */
	public static boolean isCausedBy(Exception ex, Class<? extends Exception>... causeExceptionClasses) {
		Throwable cause = ex;
		while (cause != null) {
			for (Class<? extends Exception> causeClass : causeExceptionClasses) {
				if (causeClass.isInstance(cause)) {
					return true;
				}
			}
			cause = cause.getCause();
		}
		return false;
	}
}
