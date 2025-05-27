
  import java.util.Scanner;
  import java.io.*;
  import java.util.*;
  
     /* Class BSTNode */
     class BSTNode
     {
         BSTNode left, right, parent;
         int data;
         String key;
         

         /* Constructor */
         public BSTNode()
         {
             left = null;
             right = null;
             //parent=null;
             data = 0;
         }

         /* Constructor */
         public BSTNode(int n)
         {
             left = null;
             right = null;
             parent=null;
             data = n;
         
         }
         public BSTNode(int n,String m,BSTNode parent)
         {
             left = null;
             right = null;
             parent=parent;
             data = n;
             key=m;
             
         }


        /* Function to set left node */
         public void setLeft(BSTNode n)
         {
             left = n;
         }

         /* Function to set right node */ 
         public void setRight(BSTNode n)
         {
             right = n;
         }

         /* Function to get left node */
         public BSTNode getLeft()
         {
             return left;
         }

         /* Function to get right node */
         public BSTNode getRight()
         {
             return right;
         }
         
         /* Function to get right node */
         public BSTNode getParent()
         {
             return parent;
         }

         /* Function to set data to node */
         public void setData(int d)
         {
             data = d;
         }

         /* Function to get data from node */
         public int getData()
         {
             return data;
         }     
     }

     

     /* Class BST */
     public class BST
     {
         private BSTNode root;
         ArrayList l = new ArrayList();

         /* Constructor */
         public BST()
         {
             root = null;
         }

         /* Function to check if tree is empty */
         public boolean isEmpty()
         {
             return root == null;
         }

         /* Functions to insert data */
         public void insert(int data,String key)
         {
             //node = new BSTNode(data,key);
             root = insert(root, data,key);
         }
       
         /* Function to insert data recursively */
         private BSTNode insert(BSTNode node, int data,String key)
         {
             if (root == null )
             {
                 node = new BSTNode(data,key,root);
                 node.parent=node;
                 System.out.println("Root Node is " + node.data);            
             }
             else if(node == null)
             {
                 node = new BSTNode(data,key,root);
             }
                 
             else
             {
          
                 if (data <= node.getData())
                 {
                     node.left = insert(node.left, data,key);
                     node.left.parent=node;
                 }
                 else
                 {
                     node.right = insert(node.right, data,key);
                     node.right.parent=node;
                 }
             }

             return node;
         }


         /* Functions to search for an element */
         public String search(int val)
         {
             return search(root, val);
         }

         /* Function to search for an element recursively */
         private String search(BSTNode r, int val)
         {
             String found = "0";
             while ((r != null) && found.equalsIgnoreCase("0"))
             {
                 int rval = r.getData();
                 if (val < rval)
                     r = r.getLeft();
                 else if (val > rval)
                     r = r.getRight();
                 else
                 {
                     found = r.key;
                     break;
                 }
                 found = search(r, val);
             }
             return found;
         }

         /* Function for inorder traversal */
         public void inorder()
         {
             inorder(root);
         }

        private void inorder(BSTNode r)
         {
             if (r != null)
             {
                 inorder(r.getLeft());
                 System.out.print(r.getData() +" ");
                 inorder(r.getRight());
            }
         }

         /* Function for preorder traversal */
         public void postorder()
         {
             postorder(root);
         }

         private void postorder(BSTNode r)
         {
             if (r != null)
             {
                 postorder(r.getLeft());             
                 postorder(r.getRight());
                  System.out.print(r.getData() +" ");
             }
        }

         /* Function for postorder traversal */
         public void preorder() throws IOException
         {
            String output ="BSTtree.dot";
            BufferedWriter writer = new BufferedWriter(new FileWriter(output));
            writer.write("digraph mygraph{" + System.lineSeparator());
            writer.write(" node [shape=plaintext]" + System.lineSeparator());
            preorder(root,writer);
            writer.write(System.lineSeparator());
            writer.write("}");
            writer.close();
         }

         private void preorder(BSTNode r,BufferedWriter writ) throws IOException
         {
            if (r != null)
             {
                 writ.write(" " + r.parent.data + " -> " + r.getData());
                 writ.write(System.lineSeparator());
                 //System.out.println(r.parent.data+ " is Parent of " + r.getData());
                 if(r.getLeft()!=null)
                    preorder(r.getLeft(),writ);  
                 if(r.getRight()!=null)
                    preorder(r.getRight(),writ);
             }
         }     
    }
  
