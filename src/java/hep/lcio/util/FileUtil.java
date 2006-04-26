package hep.lcio.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Miscellaneous java file utilities.
 * @author jeremym
 * @version $Id: FileUtil.java,v 1.1 2006-04-26 00:56:53 jeremy Exp $
 */
public abstract class FileUtil
{
	/**
	 * Reads a file into an ArrayList.
	 * @param fileName Name of the input file.
	 * @return A List with one line String per entry.
	 */
	public static List loadFile(String fileName)
	{
		if ((fileName == null) || (fileName == ""))
			throw new IllegalArgumentException();

		String line;
		ArrayList file = new ArrayList();

		try
		{
			BufferedReader in = new BufferedReader(new FileReader(fileName));

			if (!in.ready())
				throw new IOException();

			while ((line = in.readLine()) != null)
				file.add(line);

			in.close();
		}
		catch (IOException e)
		{
			System.out.println(e);
			return null;
		}

		return file;
	}
	
	/**
	 * Return an array of files from an array of file paths.
	 * @param fstr Array of file paths.
	 * @return Array of File objects.
	 */
	public static File[] createFiles(String[] fstr)
	{
		File[] infiles = new File[fstr.length];
		for (int i = 0; i < fstr.length; i++)
		{
			String ifile = (String) fstr[i];
			infiles[i] = new File(ifile);
		}
		return infiles;
	}
}
