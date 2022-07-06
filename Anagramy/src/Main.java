import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList <ArrayList<String>> Anagramy = new ArrayList();
		ArrayList <String> ListaWyrazow = new ArrayList();
		
		int n = scanner.nextInt();
		
		if(n > 3000 || n < 1)
		{
			System.out.println("n must be <= 3000 and >= 1");
		}
		else
		{
			char word[] = new char[30];
			for(int i = 0; i < n; i++)
			{
				word = scanner.next().toCharArray();
				String Strword = String.valueOf(word);
				if(!ListaWyrazow.contains(Strword))
				{
					ListaWyrazow.add(Strword);
				}
			}
			Collections.sort(ListaWyrazow);
			for(int i = 0; i < ListaWyrazow.size(); i++)
			{
				String wyrazString = ListaWyrazow.get(i);
				char wyrazCH[] = wyrazString.toCharArray();
				ArrayList <String> GrupaAnagramow = new ArrayList();
				Arrays.sort(wyrazCH);
				for(int j = 0; j < ListaWyrazow.size(); j++)
				{
					String tempWordString = ListaWyrazow.get(j);
					char TempWordToCompare[] = tempWordString.toCharArray();
					Arrays.sort(TempWordToCompare);
					if(Arrays.equals(wyrazCH, TempWordToCompare) == true)
					{
						GrupaAnagramow.add(tempWordString);
						if(tempWordString != wyrazString)
						{
							ListaWyrazow.remove(tempWordString);
							j--;
						}
					}
				}
				Collections.sort(GrupaAnagramow);
				Anagramy.add(GrupaAnagramow);
			}
		}
		System.out.println(Anagramy);
	}

}
