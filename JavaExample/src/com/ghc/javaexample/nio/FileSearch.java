/**
 * FileSearch.java
 *
 *	
 */
package com.ghc.javaexample.nio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import com.ghc.javaexample.IApplication;

/**
 * 
 */
public class FileSearch implements IApplication {
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.javaexample.IApplication#runApp(java.lang.String[])
	 */
	@Override
	public void runApp(String[] args) {
		System.out.format("File Search\n");

		new Thread(new Runnable() {
			@Override
			public void run() {
				Path path = Paths.get("D:\\GHC_\\Document");
				try {
					Files.walkFileTree(path, new MyFileVisitor());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	private class MyFileVisitor extends SimpleFileVisitor<Path> {
		int mMargin = 0;

		public MyFileVisitor() {
		}

		@Override
		public FileVisitResult preVisitDirectory(Path dir,
				BasicFileAttributes attrs) throws IOException {
			String margin = getMargin(mMargin);
			System.out.format(margin + " + %s \n", dir.getFileName());
			mMargin++;
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult postVisitDirectory(Path dir, IOException exc)
				throws IOException {
			mMargin--;
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
				throws IOException {
			String margin = getMargin(mMargin);
			System.out.format(margin + " - %s \n", file.getFileName());
			return FileVisitResult.CONTINUE;
		}
	}

	private String getMargin(int margin) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < margin; i++) {
			sb.append("\t");
		}
		return sb.toString();
	}
}
