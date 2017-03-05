package ku.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * Class for copying the InputStram to the OutputStram.
 * @author Issaree Srisomboon
 *
 */
public class FileUtil {

	/**
	 * Copy the InputStream to the OutputStream one byte at a time.
	 * Both InputStram and OutputStream are closed when finished.
	 * @param in is the InputStream to read
	 * @param out is the OutputStram to write
	 */
	public static void copy ( InputStream in , OutputStream out ) {
		int data;
		try {
			try {
				while ( (data = in.read()) > 0 ) {
					out.write( data );
				}
			} finally {
				in.close();
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	/**
	 * Copy the InputStram to the OutputStram using a byte array of size blocksize.
	 * Both InputStram and OutputStream are closed when finished.
	 * @param in is the InputStream to read
	 * @param out is the OutputStram to write
	 * @param blocksize of a byte array
	 */
	public static void copy ( InputStream in , OutputStream out , int blocksize ) {
		byte[] buffer = new byte [ blocksize ];
		int number;
		try {
			try {
				while ( (number = in.read()) > 0 ) {
					out.write( in.read( buffer ) );
				}
			} finally {
				in.close();
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * Copy the InputStram to the OutputStram using a BufferedReader to read the InoutStream,
	 * and using PrintWriter to write the OutputStream.
	 * Both InputStram and OutputStream are closed when finished.
	 * @param in is the InputStream to read
	 * @param out is the OutputStram to write
	 */
	public static void bcopy ( InputStream in , OutputStream out ) {
		BufferedReader buff = new BufferedReader(new InputStreamReader(in));
		PrintWriter print = new PrintWriter(out);
		String line;
		try {
			try {
				while ( (line = buff.readLine()) != null ) {
					print.write( line );
				}
			} finally {
				buff.close();
				print.close();
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * Copy the InputStram to the OutputStram using a BufferedReader to read the InoutStream,
	 * and using BufferedWriter to write the OutputStream.
	 * Both InputStram and OutputStream are closed when finished.
	 * @param in is the InputStream
	 * @param out is the OutputStram
	 * @param blocksize of a char array
	 */
	public static void ccopy ( InputStream in , OutputStream out , int blocksize ) {
		BufferedReader buffRead = new BufferedReader(new InputStreamReader(in));
		BufferedWriter buffWrite = new BufferedWriter(new OutputStreamWriter(out));
		char[] c = new char[blocksize];
		int character;
		try {
			while ( (character = buffRead.read( c )) > 0 ) {
				buffWrite.write( c );
			}
			buffRead.close();
			buffWrite.close();
		} catch (IOException e) {
			throw new RuntimeException();
		}
		
	}
}
