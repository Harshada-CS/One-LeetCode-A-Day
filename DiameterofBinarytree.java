/*
543.Diameter of Binary tree
Problem:
Given the root of a binary tree,return the length of the diameter of the tree.
The diameter is the length of the longest path between any two nodes.
The length of a path is measured by the number of edges between the nodes.

Ex:
input: root={1,2,3,4,5}
output:3

#approach:
we can use DFS(depth-first-search) to solve this pbolem.
we can find the height of the left and right subtree of each node.
the diameter of the tree is the maximum value of (leftheight+rightHeight) for ech node.

Algorithm:

Initialize diameter = 0.
Call height(root).
If the current node is null, return 0.
Recursively find the left subtree height.
Recursively find the right subtree height.
Calculate the diameter passing through the current node.
Update the maximum diameter.
Return the height of the current node.
Finally, return diameter.

 */
//code:
class DiameterofBinarytree{
    static class TreeNode{
        int val;
        TreeNode left=null;
        TreeNode right=null;
        TreeNode(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    int diameter=0;
    public int diameterofBinaryTree(TreeNode root){
        height(root);
        return diameter;
        }
        public int height(TreeNode node){
            if(node==null){
                return 0;
            }
            int leftHeight=height(node.left);
            int rightHeight=height(node.right);

            diameter=Math.max(diameter,leftHeight+rightHeight);
            return Math.max(leftHeight,rightHeight)+1;
        }
        public static void main(String[] args){
             DiameterofBinarytree obj = new DiameterofBinarytree();
             TreeNode root=new TreeNode(1);
             root.left=new TreeNode(2);
             root.right=new TreeNode(3);
             root.left.left=new TreeNode(4);
             root.left.right=new TreeNode(5);

             int diameter = obj.diameterofBinaryTree(root);
             System.out.println("Diameter of the binary tree is: " + diameter);
        }
}
/*
Time Complexity:0(n)
Space COmplexity:0(h)
 */