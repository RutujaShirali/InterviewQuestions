package com.rutuja.ds;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class FindTopK {
	public void findK(File file, int k){
	PriorityQueue<Integer> pq = new PriorityQueue<>();
	BufferedReader read;
	int num;
	String text = null;
	try {
		read = new BufferedReader(new FileReader(file));
		for(int i = 0; i< k; i++){
			if((text = read.readLine())== null) {
				System.out.println("File doesnt have enough elements top elements are: !!");
				break;
			}
			num = Integer.parseInt(text);			
			pq.add(num);
		}
		while((text = read.readLine()) !=null){
			num = Integer.parseInt(text);
			int temp = pq.peek();				
			if(temp < num){
				pq.poll();
				pq.add(num);
			}
			
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	while (!pq.isEmpty())
		System.out.println(pq.poll());
	}
	

	public static void main(String[] args) {
		File file = new File("C:/Users/Rutuja/Desktop/numbers.txt");
		FindTopK ftk = new  FindTopK();
		ftk.findK(file,6);

	}

}
