package com.rutuja.adhoc;
/**
 * File Searcher which lists all the files in a directory(Also the files in a directory inside a directory
 * 
 */

import java.io.File;
import java.util.LinkedList;

public class FileSearcher {

	public static void search(File root) {
		LinkedList<File> stack = new LinkedList<File>();
		stack.push(root);
		while (!stack.isEmpty()) {
			root = stack.pop();
			for (File f : root.listFiles()) {
				if (f.isDirectory()) {
					stack.push(f);
				}
				else System.out.println(f);
			}

		}
	}

	public static void main(String[] args) {
		File root = new File("C:\\Users\\Rutuja\\Downloads");
		search(root);
	}
}
