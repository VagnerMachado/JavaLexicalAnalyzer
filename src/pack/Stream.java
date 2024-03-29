package pack;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/************************************************************************************
 * class Stream - this class was edited from the javaIO so it can accept the files 
 * for input and output in the constructor. Stream class uses the input file to read
 * characters and send to the LexVM class representation of a DFA. Description of
 * the methods can be found below.
 *************************************************************************************
 *
 *   @author ProfessorYukawa - Edited by VagnerMachado - QCID 23651127 - Fall 2019
 * 
 *************************************************************************************
 */

public class Stream 
{
	public static BufferedReader inStream; // input stream
	public static PrintWriter outStream;   // output stream
	public static int intToken;            // the integer value of the character read in
	public static char charToken;          // used to convert the variable "intToken" to the char type whenever necessary

	/**
	 * Stream Constructor - Initialized an input stream and an output stream based on parameters
	 * @param input -  the file name used as input
	 * @param output - the file name used as output
	 */
	public Stream(String input, String output)
	{
		try
		{
			inStream = new BufferedReader(new FileReader(input));
			outStream = new PrintWriter(new FileWriter(output));
			intToken = inStream.read();
		} catch (IOException e) {
			System.out.println("Error Opening File in Stream class Constructor");
			e.printStackTrace();
		}
	}

	/**
	 * getNextChar - returns the next character in the input stream as integer
	 * @return - the next character as integer in the input stream or  -1 if end of file reached
	 */
	public static int getNextChar()
	{
		try
		{
			return inStream.read();
		}
		catch(IOException e)
		{
			System.out.println("Error calling getNextChar() in Stream class");
			e.printStackTrace();
			return -1;
		}
	}


	/**
	 * getChar - Returns the next non-whitespace character as integer on the input stream. 
	 * @return -1 if end-of-stream or the next char if exists
	 */
	public static int getChar()
	{
		int i = getNextChar();
		while ( Character.isWhitespace((char)i) )
			i = getNextChar();
		return i;
	}

	/**
	 * display - overloaded method prints a character to output file
	 * @param s - the integer value of charater to be printed
	 */
	public static void display(int s)
	{
		outStream.print((char)s);
	}

	/**
	 * display - overloaded method prints a character to output file
	 * @param s - the integer value of character to be printed
	 */
	public static void display(String s)
	{
		outStream.print(s);
	}

	/**
	 * displayln - prints a string to output file then ends the line
	 * @param s - the string to be printed to output file
	 */
	public static void displayln(String s)
	{
		outStream.println(s);
	}

	/**
	 * close - closes the input and output files
	 */
	public void close()
	{
		try
		{
			inStream.close();
			outStream.close();
		}
		catch(IOException e)
		{
			System.out.println("Error calling close() in Stream class");
			e.printStackTrace();
		}
	}


}
