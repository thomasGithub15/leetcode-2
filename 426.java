/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

/*
class Solution {
    public Node head;
    public Node treeToDoublyList(Node root) {
        Node node = root;
        helper(node);
        return head;
    }
    public void helper(Node node){
        if(node == null){
            return null;
        }
        //in order traversal
        treeToDoublyList(node.left);

        
        if(node.left == null){
            head = node;
        }
        
        if(node.left != null){
            //case where you connect node two layers down (4<->3)
            if(node.left.right != null){
                node.left.right.right = node;
                node.left = node.left.right;
            }
            //case for connecting only one layer(4<->2)
            else{
                node.left.right = node;
            }    
        }
        //connecting right side back to node 
        if(node.right != null){
            
        }
        
        treeToDoublyList(node.right);
        
        //connect head with this
        
    }
    
}
*/

//1<- 2-> 3<- 4-> 5

class Solution {
    public Node head;
    public Node treeToDoublyList(Node root) {
       if (root == null) {
            return root;
        }
        List<Node> allNodes = new ArrayList<>();
        inOrder(root, allNodes);
        
        for(int i = 0; i < allNodes.size()-1; i++){
            Node curr = allNodes.get(i);
            Node next = allNodes.get(i+1);
            if(curr.right != null){
                next.left = curr;
                if((i+2) < allNodes.size()){
                    next.right = allNodes.get(i+2);
                    allNodes.get(i+2).left = next;
                }
                
            }
            else{
                curr.right = next;
            }
        }
        
        return allNodes.get(0);
    }
    
    public void inOrder(Node root, List<Node> allNodes) {
        if (root == null) {
            return;
        }
        inOrder(root.left, allNodes);
        allNodes.add(root);
        inOrder(root.right, allNodes);
    }
}




/*
                            4
                           / \                            
                          2   5
                         / \
                        1   3
                       / \ / \
                      6  78   9
                      
                      
                      
                      
*/