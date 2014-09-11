//package com.rutuja.ds;
//
//public class DLLtoBinary {
//	Node head;
//	
//
//	class Node {
//		public Node(int n) {
//			value = n;
//		}
//
//		int value;
//		Node next;
//		Node previous;
//	}
//	public boolean insertLast(int element){
//		return insertLast_R(head, element);
//	}
//	
//	private boolean insertLast_R(Node node,int element){
//		Node last = new Node(element);
//		if(head == null){
//			head = last;
//			return true;
//		}
//		else{
//		while(node.next != null){
//		node = node.next;	
//		}
//		node.next = last;
//		last.previous = node;
//		return true;
//		}
//	}
//	private Node findMid(Node node){
//		Node mid;	
//		while(node.next != null){
//			node = node.next.next;
//			mid = mid.next;
//			
//		}
//	}
//	
//	public void DLLtoBinary(){
//		head = DLLtoBinary_R(head);
//	}
//	
//	private Node DLLtoBinary_R(Node node){
//		Node mid;
//		mid = findMid(node);
//		
//		
//		
//	}
//
//	public static void main(String[] args) {
//
//	}
//
//}
