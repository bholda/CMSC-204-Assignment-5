public class TreeNode<T>
{
   protected T data;
   protected TreeNode<T> before;
   protected TreeNode<T> after;

   public TreeNode (T dataNode)
   {
       this.data = dataNode;
       this.before = null;
       this.after = null;
   }

   public T getData()
   {
       return data;
   }
   public TreeNode (TreeNode<T> node)
   {
       new TreeNode<T>(node);
   }

}