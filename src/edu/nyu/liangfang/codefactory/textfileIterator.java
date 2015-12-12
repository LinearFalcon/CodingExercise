package edu.nyu.liangfang.codefactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class textfileIterator implements Iterator<String> {
	BufferedReader reader;
	String line;
	
	public textfileIterator(String path) throws IOException {
		reader = new BufferedReader(new FileReader(path));
		line = null;
	}
	
	@Override
	public boolean hasNext() {
		if (line != null) {
			return true;
		} else {
			try {
				line = reader.readLine();
				if (line != null)
					return true;
				else
					return false;
			} catch (IOException e) {
				return false;
			}
		}
	}

	@Override
	public String next() {
		if (hasNext()) {
			String tmp = line;
			line = null;
			return tmp;
		}
		throw new NoSuchElementException("No next!");
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("Unsupported");
	}
	
}
