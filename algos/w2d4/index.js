/**
 * Class to represent a Node in a Binary Search Tree (BST).
 */
class BSTNode {

    constructor(data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }
  
  /**
   * Represents an ordered tree of nodes where the data of left nodes are <= to
   * their parent and the data of nodes to the right are > their parent's data.
   */
class BinarySearchTree {
    constructor() {
        this.root = null;
}
  
    /**
     * Determines if this tree is empty.
     * @returns {boolean} Indicates if this tree is empty.
     */
    isEmpty() {
      return this.root === null;
    }
  
    /**
     * Retrieves the smallest integer data from this tree.
     * @param {Node} current The node that is currently accessed from the tree as the tree is being traversed.
     * @returns {number} The smallest integer from this tree.
     */
    min(current = this.root) {
      if(this.isEmpty()) return null;

      while(current.left !== null){
        current = current.left
      }
      return current.data;
    }
  
    /**
     * Retrieves the smallest integer data from this tree.
     * @param {Node} current The node that is currently accessed from the tree as the tree is being traversed.
     * @returns {number} The smallest integer from this tree.
     */
    minRecursive(current = this.root) {}
  
    /**
     * Retrieves the largest integer data from this tree.
     * @param {Node} current The node that is currently accessed from the tree as the tree is being traversed.
     * @returns {number} The largest integer from this tree.
     */
    max(current = this.root) {
      if(this.isEmpty()) return null;

      while(current.right !== null){
        current = current.right
      }
      return current.data
    }
    
    /**
     * Retrieves the largest integer data from this tree.
     * @param {Node} current The node that is currently accessed from the tree as the tree is being traversed.
     * @returns {number} The largest integer from this tree.
    */
   maxRecursive(current = this.root) {}
   
   // Logs this tree horizontally with the root on the left.
   print(node = this.root, spaceCnt = 0, spaceIncr = 10) {
     if (!node) {
       return;
      }
      
      spaceCnt += spaceIncr;
      this.print(node.right, spaceCnt);
      
      console.log(
        " ".repeat(spaceCnt < spaceIncr ? 0 : spaceCnt - spaceIncr) +
        `${node.data}`
        );
        
        this.print(node.left, spaceCnt);
      }
      
      ////! WEDNESDAY //////////////////
    /**
 * Determines if this tree contains the given searchVal.
 * - Time: O(?).
 * - Space: O(?).
 * @param {number} searchVal The number to search for in the node's data.
 * @returns {boolean} Indicates if the searchVal was found.
 */
contains(searchVal) {
  let current = this.root;
    if(current.data === searchVal) return true;
    while(current){
      if(current.data < searchVal){
        current = current.right
      } else if(current.data > searchVal) {
        current = current.left
      } else {
        return true
      }
    }
    return false


}

/**
 * Determines if this tree contains the given searchVal.
 * - Time: O(?).
 * - Space: O(?).
 * @param {number} searchVal The number to search for in the node's data.
 * @returns {boolean} Indicates if the searchVal was found.
 */
containsRecursive(searchVal, current = this.root) {}
/**
 * Calculates the range (max - min) from the given startNode.
 * - Time: O(?).
 * - Space: O(?).
 * @param {Node} startNode The node to start from to calculate the range.
 * @returns {number|null} The range of this tree or a sub tree depending on if the
 *    startNode is the root or not.
 */
range(startNode = this.root) {}

///! THURSDAY //////////////////

/**
 * Inserts a new node with the given newVal in the right place to preserver
 * the order of this tree.
 * - Time: O(?).
 * - Space: O(?).
 * @param {number} newVal The data to be added to a new node.
 * @returns {BinarySearchTree} This tree.
 */
insert(newVal) {
    if(this.isEmpty()){
        this.root = new BSTNode(newVal);
        return this
    }
    let current = this.root
    while(current){
        if(current.data < newVal){
            if(current.right){
                current = current.right
            }else{
                current.right = new BSTNode(newVal);
                return this
            }
        }
        else if(current.data >= newVal){
            if(current.left){
                current = current.left
            }else{
                current.left = new BSTNode(newVal);
                return this
            }
        }
    }
    return this
}

/**
 * Inserts a new node with the given newVal in the right place to preserver
 * the order of this tree.
 * - Time: O(?).
 * - Space: O(?).
 * @param {number} newVal The data to be added to a new node.
 * @param {Node} curr The node that is currently accessed from the tree as
 *    the tree is being traversed.
 * @returns {BinarySearchTree} This tree.
 */
insertRecursive(newVal, curr = this.root) {
    if(this.isEmpty()){
        this.root = new BSTNode(newVal);
        return this    
    }
    if(curr.data < newVal){
        if(curr.right){
            return this.insertRecursive(newVal,curr.right)
        }
        curr.right = new BSTNode(newVal)
        return(this)
    }else{
        if(curr.left){
            return this.insertRecursive(newVal,curr.left)
        }
        curr.left = new BSTNode(newVal)
        return(this)
    }
}
  }
  
  const emptyTree = new BinarySearchTree();
  const oneNodeTree = new BinarySearchTree();
  oneNodeTree.root = new BSTNode(10);
  
  /* twoLevelTree
          root
          10
        /   \
      5     15
  */
  const twoLevelTree = new BinarySearchTree();
  twoLevelTree.root = new BSTNode(10);
  twoLevelTree.root.left = new BSTNode(5);
  twoLevelTree.root.right = new BSTNode(15);
  
  /* threeLevelTree 
          root
          10
        /   \
      5     15
    / \    / \
  2   6  13  
  */
  const threeLevelTree = new BinarySearchTree();
  threeLevelTree.root = new BSTNode(10);
  threeLevelTree.root.left = new BSTNode(5);
  threeLevelTree.root.left.left = new BSTNode(2);
  threeLevelTree.root.left.right = new BSTNode(6);
  threeLevelTree.root.right = new BSTNode(15);
  threeLevelTree.root.right.left = new BSTNode(13);
  
  /* fullTree
                      root
                  <-- 25 -->
                /            \
              15             50
            /    \         /    \
          10     22      35     70
        /   \   /  \    /  \   /  \
      4    12  18  24  31  44 66  90
  */
  /***************** Uncomment after insert method is created. ****************/
  const fullTree = new BinarySearchTree();
  fullTree
    .insertRecursive(25)
    .insertRecursive(15)
    .insertRecursive(10)
    .insertRecursive(22)
    .insertRecursive(4)
    .insertRecursive(12)
    .insertRecursive(18)
    .insertRecursive(24)
    .insertRecursive(50)
    .insertRecursive(35)
    .insertRecursive(70)
    .insertRecursive(31)
    .insertRecursive(44)
    .insertRecursive(66)
    .insertRecursive(66)
    .insertRecursive(90);
  fullTree.print()
//   const bst = new BinarySearchTree()
//   bst.root = new BSTNode(34)
//   bst.root.left = new BSTNode(24)
//   bst.root.left.right = new BSTNode(27)
//   bst.root.left.left = new BSTNode(14)
//   bst.root.right = new BSTNode(42)
//   // console.log(bst.min())
//   // console.log(bst.max())
// console.log(bst.contains(27)) // => true
//   console.log(bst.contains(17)) // => false

//   console.log(bst.isEmpty())