import java.util.ArrayList;
import java.util.List;

public class Trees_0 {
    public static Node build(){
        Node a=new Node('A');
        Node b=new Node('B');
        Node c=new Node('C');
        Node d=new Node('D');
        Node e=new Node('E');
        Node f=new Node('F');
        Node g=new Node('G');
        Node h=new Node('H');

        a.left=b;a.right=c;
        b.left=d;b.right=e;
        c.left=f;c.right=g;
        e.right=h;
        return a;
    }
    //遍历 前中后
    public static void preOrderTree(Node root){
       if(root==null){
           return;
       }
        System.out.print(" "+root.val);
       preOrderTree(root.left);
       preOrderTree(root.right);
       //时间复杂度为O（n）


    }

    public static List<Character>preOder(Node root){
        if(root==null){
            return new ArrayList<>();
        }
        List<Character>list=new ArrayList<>();
        List<Character>left=preOder(root.left);
        List<Character>right=preOder(root.right);
        list.add(root.val);
        list.addAll(left);
        list.addAll(right);
        return list;

    }


public static List<Character>list;

 private static void preOrder_1(Node root){
    if(root==null){
        return;
    }
    list.add(root.val);
    preOrder_1(root.left);
    preOrder_1(root.right);

}
public static List<Character>preOrder_2(Node root){
     list=new ArrayList<>();
     preOrder_1(root);
     return list;
}

    public static void inOrderTree(Node root){
        if(root==null){
            return;
        }
        inOrderTree(root.left);
        System.out.print(" "+root.val);
        inOrderTree(root.right);

    }
    public static void postOrderTree(Node root){
        if(root==null){
            return;
        }
        postOrderTree(root.left);
        postOrderTree(root.right);
        System.out.print(" "+root.val);
      }
      //8.24
public static int count=0;
      public static int calcTreeNode(Node root){
     if(root==null){
         return 0;
     }
          count++;
          calcTreeNode(root.left);
          calcTreeNode(root.right);
return count;
      }
      public static int calcTreeNode_1(Node root){
          if(root==null){
return 0;
          }
         int left=calcTreeNode_1(root.left);
          int right=calcTreeNode_1(root.right);
      return left+right;
      }
public static void cacLeafNode(Node root){
          if(root==null){
              return;
          }
          //代表结点 用来判断是否为叶子节点
          if(root.left==null && root.right==null){
              count++;
          }
    cacLeafNode(root.left);
    cacLeafNode(root.right);

}

public static int calcHigh(Node root){
          if(root==null){
              return 0;
          }
          int left=calcHigh(root.left);
          int right=calcHigh(root.right);
          int height=Math.max(left,right);
          return height+1;
}

public static int calcKlevel(Node root,int k){
          if(root==null){
              return 0;
          }
          if(k==1){
              return 1;
          }
          int left=calcKlevel(root.left,k-1);
          int right=calcKlevel(root.right,k-1);
          int count=left+right;
          return count;
}

public static Node search(Node root,char v){
          if(root==null){
              return null;
          }
          if(root.val==v){
              return root;
          }
          //递归@#%^&*_hin重要
          Node left=search(root.left,v);
          //if(left.val==v) 该表达错误
    //search是自己写的
          if(left!=null){
              return left;

          }
          Node right=search(root.right,v);
          if(right!=null){
              return right;
          }
          return null;
}

public static boolean search_1(Node root,char v){
          if(root==null){
              return false;
          }
          if(root.val==v){
              return true;
          }
          if(search_1(root.left,v)){
              return true;
          }
          return search_1(root.right,v);


}
public static boolean isMinror(Node p,Node q){
          if(p==null&&q==null){
              return true;
          }
          if(p==null||q==null){
              return false;
          }
          return p.val==q.val
                  && isMinror(p.left,q.right)
                  && isMinror(p.right,q.left);
}
public static boolean isMirror2(Node p) {
    if (p == null) {
        return true;
    }
    return isMirror2(p.left)&&isMirror2(p.right);

}
    public static void main(String[] args) {
        Node root=build();

        preOder(root);
        System.out.println(root.val);
        System.out.println(" ");
        preOrder_2(root);
        System.out.println(root.val);
        System.out.println(" ");
        inOrderTree(root);
        System.out.println(" ");
        postOrderTree(root);
        System.out.println(" m");
        System.out.println(search_1(root,'O'));
        System.out.println(search(root,'A'));


    }
}

