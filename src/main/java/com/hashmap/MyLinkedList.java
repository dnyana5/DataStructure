package com.hashmap;

public class MyLinkedList<K> {
    public INode head;
    public INode tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(INode<K> newNode) {
        if(this.tail  == null) {
            this.tail = newNode;
        }
        if(this.head == null)
            this.head = newNode;
        else {
            INode<K> temNode = this.head;
            this.head = newNode;
            this.head.setNext(temNode);
        }
    }

    public void append(INode myNode) {
        if(this.head == null) {
            this.head = myNode;
        }
        if(this.tail == null) {
            this.tail = myNode;
        }else {
            this.tail.setNext(myNode);
            this.tail=myNode;
        }
    }

    public void insert(INode myNode, INode newINode) {
        INode tempNode = myNode.getNext();
        myNode.setNext(newINode);
        newINode.setNext(tempNode);
    }

    public INode<K> pop() {
        INode<K> tempNode = this.head;
        this.head = head.getNext();
        return tempNode;
    }

    public INode<K> popLast() {
        INode<K> tempNode = head;
        while(!tempNode.getNext().equals(tail)) {
            tempNode = tempNode.getNext();
        }
        this.tail = tempNode;
        tempNode = tempNode.getNext();
        return tempNode;
    }

    public INode popBetween(INode myNode) {
        INode tempNode = this.head;
        INode popNode = null;
        while(tempNode.getNext() != null) {
            if(tempNode.getNext().equals(myNode)) {
                INode temp1Node = myNode.getNext();
                tempNode.setNext(temp1Node);
                popNode = myNode;
                break;
            }
            tempNode = tempNode.getNext();
        }
        return popNode;
    }

    public INode search(K key) {
        INode<K> tempNode = this.head;
        while(tempNode != null && tempNode.getNext() != null) {
            if(tempNode.getKey().equals(key)) {
                return tempNode;
            }
            tempNode = tempNode.getNext();
        }
        return null;
    }

    public void size(){
        INode tempNode = this.head;
        Integer count = 0;
        while(tempNode != null) {
            count = count + 1;
            tempNode = tempNode.getNext();
        }
        System.out.println(count);
    }

    public void printMyNodes() {
        System.out.println("My Nodes:" +head);
    }

    @Override
    public String toString() {
        return "MyLinkedList{" + head +'}';
    }
}
