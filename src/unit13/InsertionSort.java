package unit13;

import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

class InsertionSort
{
	private ArrayList<String> list;

	public InsertionSort()
	{
		list = new ArrayList<String>();

	}

	//modfiers
	public void add( String  word)
	{
		int loc = 0;
		list.add(word);

	}


	public void remove(String word)
	{
		int index = list.indexOf(word);
		if (index >= 0) {
			System.out.println(index);
			list.remove(index);

		}





	}

	public String toString()
	{
		String output = "";
		for (String s : list) {
			output += s + " ";
		}
		return output;
	}
}