class IntTree {
    
    private class Node {
        
        int elem;
        Node left = null;
        Node right = null;
        
        Node(int elem) {
            this.elem = elem;
        }
        
        void add(int elem) {
            if (elem < this.elem) {
                if (this.left == null) {
                    this.left = new Node(elem);
                } else {
                    this.left.add(elem);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(elem);
                } else {
                    this.right.add(elem);
                }
            }
        }
        
        int countNodes() {
            //TODO Implementieren Sie hier die Angabe
            if (this.left == null && this.right == null) {
                return 1;
            }
            if (this.left != null && this.right == null) {
                return 1 + this.left.countNodes();
            }
            if (this.right != null && this.left == null) {
                return 1 + this.right.countNodes();
            }
            return 1 + this.left.countNodes() + this.right.countNodes();
        }
        
        int countLeaves() {
            //TODO Implementieren Sie hier die Angabe alle, die keine nachfolger haben
            if (this.left == null && this.right == null) {
                return 1;
            }
            if (this.left != null && this.right == null) {
                return this.left.countLeaves();
            }
            if (this.right != null && this.left == null) {
                return this.right.countLeaves();
            }
            return this.left.countLeaves() + this.right.countLeaves();
        }
        
        int height() {
            //TODO Implementieren Sie hier die Angabe
            if (this.left == null && this.right == null) {
                return 1;
            }
            if (this.left != null && this.right == null) {
                return 1 + this.left.height();
            }
            if (this.right != null && this.left == null) {
                return 1 + this.right.height();
            }
            return 1 + Math.max(this.left.height(), this.right.height());
        }
        
        void printLeaves() {
            //TODO Implementieren Sie hier die Angabe
            if (this.left == null && this.right == null) {
                System.out.println(this.elem);
            }
            if (this.left != null) {
                this.left.printLeaves();
            }
            if (this.right != null) {
                this.right.printLeaves();
            }
        }
        
        void printInOrderUp() {
            //TODO Implementieren Sie hier die Angabe
            if (this.left != null) {
                this.left.printInOrderUp();
            }
            System.out.println(this.elem);
            if (this.right != null) {
                this.right.printInOrderUp();
            }
        }
        
        void printInOrderUpSub(int elem) {
            //TODO Implementieren Sie hier die Angabe
            if (elem == this.elem) {
                this.printInOrderUp();
            } else if (elem < this.elem) {
                this.left.printInOrderUp();
            } else {
                this.right.printInOrderUp();
            }
        }
    
        void printPostOrder() {
            //TODO Implementieren Sie hier die Angabe
            if (this.left != null) {
                this.left.printPostOrder();
            }
            if (this.right != null) {
                this.right.printPostOrder();
            }
            System.out.println(this.elem);
        }
    
        void printPreOrder() {
            //TODO Implementieren Sie hier die Angabe
            System.out.println(this.elem);
            if (this.left != null) {
                this.left.printPreOrder();
            }
            if (this.right != null) {
                this.right.printPreOrder();
            }
        }
    }
    
    private Node root = null;
    
    public void add(int elem) {
        if (empty()) {
            this.root = new Node(elem);
        } else {
            this.root.add(elem);
        }
    }
    
    public boolean empty() {
        return this.root == null;
    }
    
    public int countNodes() {
        //TODO Implementieren Sie hier die Angabe
        if (empty()) {
            return 0;
        }
        return this.root.countNodes();
    }
    
    public int countLeaves() {
        //TODO Implementieren Sie hier die Angabe
        if (empty()) {
            return 0;
        }
        return this.root.countLeaves();
    }
    
    public int height() {
        //TODO Implementieren Sie hier die Angabe
        if (empty()) {
            return 0;
        }
        return this.root.height();
    }
    
    public void printLeaves() {
        //TODO Implementieren Sie hier die Angabe
        if (!empty()) {
            this.root.printLeaves();
        }
    }
    
    public void printInOrderUp() {
        //TODO Implementieren Sie hier die Angabe
        if (!empty()) {
            this.root.printInOrderUp();
        }
    }
    
    public void printInOrderUpSub(int elem) {
        //TODO Implementieren Sie hier die Angabe
        if (!empty()) {
            this.root.printInOrderUpSub(elem);
        }
    }
    
    public void printPostOrder(){
        //TODO Implementieren Sie hier die Angabe
        if (!empty()) {
            this.root.printPostOrder();
        }
    }
    
    public void printPreOrder(){
        //TODO Implementieren Sie hier die Angabe
        if (!empty()) {
            this.root.printPreOrder();
        }
    }
}
