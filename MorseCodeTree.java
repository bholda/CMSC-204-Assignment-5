import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<java.lang.String>
{
   private TreeNode<String> rt = null; 
   private String recivedLetter; 
   public MorseCodeTree()
   {
       buildTree(); 
   }
@Override
   public void buildTree()
   {
	rt = new TreeNode<String>("");
       insert(".", "e");
       insert("-", "t");
      
       insert("..", "i");
       insert(".-", "a");
       insert("-.", "n");
       insert("--", "m");
      
       insert("...", "s");
       insert("..-", "u");
       insert(".-.", "r");
       insert(".--", "w");
       insert("-..", "d");
       insert("-.-", "k");
       insert("--.", "g");
       insert("---", "o");

       insert("....", "h");
       insert("...-", "v");
       insert("..-.", "f");
       insert(".-..", "l");
       insert(".--.", "p");
       insert(".---", "j");
       insert("-...", "b");
       insert("-..-", "x");
       insert("-.-.", "c");
       insert("-.--", "y");
       insert("--..", "z");
       insert("--.-", "q");                  
   }
  
@Override
public void addNode(TreeNode<String> rt, String count, String character)
{  
    if(count.length() == 1)
     {
        if (count.equals("."))
        {
     	   rt.before = new TreeNode<String>(character);
        }
        else
        {
     	   rt.after = new TreeNode<String>(character);
        }
        return;
     } else {  
        if(count.substring(0, 1).equals("."))
        {
            addNode(rt.before, count.substring(1), character);
        }
        else
        {
            addNode(rt.after, count.substring(1), character);      
        }      
    }          
}

@Override
public java.lang.String fetch(java.lang.String count)
{
    String letter = fetchNode(rt, count);
   
    return letter;
}

@Override
public MorseCodeTree insert(java.lang.String count, java.lang.String character)
{
    addNode(rt, count, character);
    return this;      
}

   @Override
   public void setRoot(TreeNode<String> newNode) {
      
	   rt = newNode;  
   }

   @Override
   public TreeNode<String> getRoot()
   {
       return this.rt;
   }
   
   @Override
   public java.lang.String fetchNode(TreeNode<java.lang.String> rt, java.lang.String count)
   {  
       if(count.length() == 1)
        {
           if (count.equals("."))
           {
        	   recivedLetter = rt.before.getData();
           }
           else
           {
        	   recivedLetter = rt.after.getData();
           }
       }
        else
        {  
           if(count.substring(0, 1).equals("."))
           {
               fetchNode(rt.before, count.substring(1));
           }
           else
           {
               fetchNode(rt.after, count.substring(1));      
           }      
       }
       return recivedLetter;  
   }

   @Override
   public java.util.ArrayList<java.lang.String> toArrayList()
   {
       ArrayList<String> printTree = new ArrayList<String>();

       LNRoutputTraversal(rt, printTree);      

       return printTree;
   }
   @Override
   public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
       return null;
   }
   
   @Override
   public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
       return null;
   }
   
   @Override
   public void LNRoutputTraversal(TreeNode<java.lang.String> rt, java.util.ArrayList<java.lang.String> list)
   {
       if(rt != null)
       {
           LNRoutputTraversal(rt.before, list);
           list.add(rt.getData());
           LNRoutputTraversal(rt.after, list);
       }
   }

   

}