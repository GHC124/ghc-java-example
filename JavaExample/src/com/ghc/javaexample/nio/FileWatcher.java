/**
 * FileWatcher.java
 *
 *	
 */
package com.ghc.javaexample.nio;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import com.ghc.javaexample.IApplication;

/**
 * 
 */
public class FileWatcher implements IApplication {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.javaexample.IApplication#runApp(java.lang.String[])
	 */
	@Override
	public void runApp(String[] args) {
		System.out.print("File Watcher");
		new Thread(new Runnable() {

			@Override
			public void run() {
				Path path = Paths.get("D:\\GHC_\\Document");
				System.out.printf(":%s\n", path.toAbsolutePath());
				WatchService watchService = null;
				try {
					watchService = path.getFileSystem().newWatchService();
					path.register(watchService,
							StandardWatchEventKinds.ENTRY_MODIFY,
							StandardWatchEventKinds.ENTRY_CREATE,
							StandardWatchEventKinds.ENTRY_DELETE);
				} catch (IOException e) {
					e.printStackTrace();
				}
				while (true) {
					WatchKey key = null;
					try {
						key = watchService.take();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					for (WatchEvent<?> event : key.pollEvents()) {
						switch (event.kind().name()) {
						case "OVERFLOW":
							System.out.println("We lost some events!\n");
							break;
						case "ENTRY_MODIFY":
							System.out.printf("File %s is changed.\n",
									event.context());
							break;
						case "ENTRY_CREATE":
							System.out.printf("File %s is created.\n",
									event.context());
							break;
						case "ENTRY_DELETE":
							System.out.printf("File %s is deleted.\n",
									event.context());
							break;
						}
					}
					key.reset();
				}
			}
		}).start();
	}
}
