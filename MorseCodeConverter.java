import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter
{
   private static MorseCodeTree t = new MorseCodeTree();

   public static java.lang.String convertToEnglish(java.io.File codeFile) throws java.io.FileNotFoundException
   {
       String output = "";
       ArrayList<String> line = new ArrayList<String>();
       String[] letters; 
       String[] count; 

       Scanner file1;
       file1 = new Scanner(codeFile);

       while (file1.hasNext())
       {
           line.add(file1.nextLine());
       }

       file1.close();

       for(int i = 0; i < line.size(); i++)
       {
    	   letters = line.get(i).split(" / ");

           for(int j = 0; j < letters.length; j++)
           {
        	   count = letters[j].split(" ");

           for(int k = 0; k < count.length; k++)
            {
                output += t.fetch(count[k]);
            }
               output += " ";
           }
       }
       output = output.trim();
       return output;
   }
   public static java.lang.String convertToEnglish(java.lang.String code)
   {
       String final1 = "";
       String[] letters; 
       String[] count; 

       letters = code.split(" / ");
       for(int j = 0; j < letters.length; j++)
       {
    	   count = letters[j].split(" ");

           for(int i = 0; i < count.length; i++)
           {
        	   final1 += t.fetch(count[i]);
           }
           final1 += " ";
       }
       final1 = final1.trim();
       return final1;
   }
   public static java.lang.String printTree()
   {
       ArrayList<String> tree = new ArrayList<String>();

       tree = t.toArrayList();

       String print = "";

       for(int j = 0; j < tree.size(); j ++)
       {
           print += tree.get(j) + " ";
       }
       return print;
   }
   public MorseCodeConverter()
   {
   }
}