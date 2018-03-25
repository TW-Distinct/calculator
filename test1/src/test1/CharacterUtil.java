package test1;

public class CharacterUtil
{
	public static boolean isEmpty(String str)
	{
		if (str.equals(""))
		{
			return true;
		}

		return false;
	}

	public static boolean isNumber(String str)
	{
		for (int i = 0; i < str.length(); i++)
		{
			if (!Character.isDigit(str.charAt(i)))
			{
				return false;
			}
		}

		return true;
	}
}


