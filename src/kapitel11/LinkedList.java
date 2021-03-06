package kapitel11;

import kapitel9.Student;

//import kapitel9.Student;

public class LinkedList {
	
	private Node firstNode = null;

	public void add(Student student){
		Node newNode = new Node(student);
		
		if(firstNode == null){	
			firstNode = newNode;
		}else{
			Node currentNode = firstNode;
			while(currentNode.getNextNode() != null){
				currentNode = currentNode.getNextNode();
			}
			currentNode.setNextNode(newNode);
		}
	}
	
	public boolean remove(Student data){
		if(firstNode != null){
			if(firstNode.getData().equals(data)){
				firstNode = firstNode.getNextNode();
				return true;
			}else{
				Node currentNode = firstNode;
				while(currentNode.getNextNode() != null){
					if(currentNode.getNextNode().getData().equals(data)){
						currentNode.setNextNode(currentNode.getNextNode().getNextNode());
						return true;
					}
					currentNode = currentNode.getNextNode();
				}
			}
		}
		
		return false;
	}

	public Student remove(int matrikelNr){
		
		if(firstNode == null){
			return null;
		}else{
			if(firstNode.getData().getMatrikelNummer() == matrikelNr){
				Student data = firstNode.getData();
				firstNode = firstNode.getNextNode();
				return data;
			}
			Node currentNode = firstNode;
			while(currentNode.getNextNode() != null){
				if(currentNode.getNextNode().getData().getMatrikelNummer() == matrikelNr){
					Student data = currentNode.getNextNode().getData();
					currentNode.setNextNode(currentNode.getNextNode().getNextNode());
					return data;
				}
				currentNode = currentNode.getNextNode();
			}
		}
		return null;
	}
	
	public void printLinkedList(){
		if(firstNode == null){
			System.out.println("Die Liste ist leer!");
		}else{
			Node currentNode = firstNode;
			do{
				System.out.println(currentNode.getData());
				currentNode = currentNode.getNextNode();
			}while(currentNode != null);
		}
	}
	
	public void printLinkedListRecursiv(){
		printNode(firstNode);
	}
	
	private void printNode(Node currentNode){
		if(currentNode == null){
			return;
		}else{
			System.out.println(currentNode.getData());
			printNode(currentNode.getNextNode());
		}
	}
	
	private class Node{
		private Student data;
		private Node nextNode;
		
		public Node(Student data){
			this.data = data;
		}
		
		public Node getNextNode(){
			return nextNode;
		}
		
		public void setNextNode(Node nextNode){
			this.nextNode = nextNode;
		}
		
		public Student getData(){
			return this.data;
		}
	}
	
	
	/*
	private Node getLastNode(Node node){
		if(node.getNextNode() != null){
			return getLastNode(node.getNextNode());
		}else{
			return node;
		}
	}
	*/
}
