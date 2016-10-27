import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Next Pointer in the tree
 */
public class SolutionCXVI {
    public void connect(TreeLinkNode root) {
        // level order traversal, BFS
        if(root==null) return;
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        TreeLinkNode dummy = new TreeLinkNode(0);
        q.add(root);
        q.add(dummy);
        while(true){
            ArrayList<TreeLinkNode> level = new ArrayList<TreeLinkNode>();
            while(q.peek()!=dummy){
                TreeLinkNode n = q.poll();
                level.add(n);
                if(n.left!=null) q.add(n.left);
                if(n.right!=null) q.add(n.right);
            }
            int i;
            for(i=0; i<level.size()-1; i++){
                level.get(i).next = level.get(i+1);
            }
            level.get(i).next = null;
            level.clear();
            if(q.size()==1 && q.peek()==dummy) break;
            q.add(q.poll());
        }
    }
}
