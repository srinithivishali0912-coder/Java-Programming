/* Structure of binary tree Node
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public boolean areAnagrams(Node root1, Node root2) {
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        
        q1.add(root1);
        q2.add(root2);
        
        while(!q1.isEmpty() && !q2.isEmpty()){
            int s1 = q1.size();
            int s2 = q2.size();
            
            HashMap<Integer,Integer> map1 = new HashMap<>();
            HashMap<Integer,Integer> map2 = new HashMap<>();
            
            for(int i=0;i<s1;i++){
                Node n = q1.poll();
                map1.put(n.data,map1.getOrDefault(n.data,0)+1);
                if(n.left != null){
                    q1.add(n.left);
                }
                if(n.right != null){
                    q1.add(n.right);
                }
            }
            for(int i=0;i<s2;i++){
                Node n = q2.poll();
                map2.put(n.data,map2.getOrDefault(n.data,0)+1);
                if(n.left != null){
                    q2.add(n.left);
                }
                if(n.right != null){
                    q2.add(n.right);
                }
            }
            if(map1.size() == map2.size()){
                for(int val : map1.keySet()){
                    if(map2.containsKey(val)){
                        if(map1.get(val) != map2.get(val)){
                            return false;
                        }
                    }
                    else{
                        return false;
                    }
                }
            }
            else{
                return false;
            }
        }
        if(q1.isEmpty() && !q2.isEmpty()){
            return false;
        }
        if(!q1.isEmpty() && q2.isEmpty()){
            return false;
        }
        return true;
    }
}
