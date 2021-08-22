import java.util.LinkedList;

/**
 *
 * @author Lizbeth Vergara
 */
public class TreeNode<T> {
    
    private Tree<T> parent;
    private T content;
    private LinkedList<Tree<T>> children;
    private int utility;

    public TreeNode(T content) {
        this.content = content;
        this.children = new LinkedList<>();
    }

    public Tree<T> getParent() {
        return parent;
    }

    public void setParent(Tree<T> parent) {
        this.parent = parent;
    }
    
    

    public T getContent() {
        return content;
    }

    public LinkedList<Tree<T>> getChildren() {
        return children;
    }

    public void addChild(T content) {
        this.children.add(new Tree(content));
    }
    
    
    public void addChild(Tree newTree) {
        this.children.add(newTree);
    }

    public int getUtility() {
        return utility;
    }

    public void setUtility(int utility) {
        this.utility = utility;
    }
    
    @Override
    public String toString() {
        return content.toString();
    }
    
}