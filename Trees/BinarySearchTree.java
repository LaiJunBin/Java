package Trees;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
	
	public int data;
	public BinarySearchTree left,right;
	
	public void insert(int value) {
		insert(this,value);
	}
	
	private void insert(BinarySearchTree tree,int value) {
		if(tree.data < value) {
			if(tree.right == null) {
				tree.right = new BinarySearchTree(value);
				return;
			}else {
				this.insert(tree.right,value);
			}
		}else {
			if(tree.left == null) {
				tree.left = new BinarySearchTree(value);
				return;
			}else {
				this.insert(tree.left,value);
			}
		}
	}
	
	public String preorder() {
		List <String> nodes = new ArrayList <String> ();
		this._preorder(this, nodes);
        return String.join(",", nodes);
	}
	
	public void _preorder(BinarySearchTree tree,List<String> nodes) {
		if(tree == null) return;
		nodes.add(String.valueOf(tree.data));
		this._preorder(tree.left, nodes);
		this._preorder(tree.right, nodes);
	}
	
	public String inorder() {
		List <String> nodes = new ArrayList <String> ();
		this._inorder(this, nodes);
        return String.join(",", nodes);
	}
	
	public void _inorder(BinarySearchTree tree,List<String> nodes) {
		if(tree == null) return;
		this._inorder(tree.left, nodes);
		nodes.add(String.valueOf(tree.data));
		this._inorder(tree.right, nodes);
	}
	
	public String postorder() {
		List <String> nodes = new ArrayList <String> ();
		this._postorder(this, nodes);
        return String.join(",", nodes);
	}
	
	public void _postorder(BinarySearchTree tree,List<String> nodes) {
		if(tree == null) return;
		this._postorder(tree.left, nodes);
		this._postorder(tree.right, nodes);
		nodes.add(String.valueOf(tree.data));
	}
	
	public BinarySearchTree(int value) {
		this.data = value;
		this.left = null;
		this.right = null;
	}
	
	public static void main(String[] args) {
		
		BinarySearchTree tree = null;
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("Input : c = createTree , i = insert,[1,2,3] = [preorder,inorder,postorder]");
			switch(scanner.nextLine()) {
				case "i":
					System.out.println("請輸入要插入的值");
					tree.insert(scanner.nextInt());
					break;
				case "c":
					System.out.println("請輸入根節點的值");
					tree = new BinarySearchTree(scanner.nextInt());
					break;
				case "1":
					System.out.println(tree.preorder());
					break;
				case "2":
					System.out.println(tree.inorder());
					break;
				case "3":
					System.out.println(tree.postorder());
					break;
			}	
		}
		
	}

}
