package com.rutuja.graphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import com.rutuja.ds.Main;

public class FloydWarshall {
	
	public int[][] adjMatrix() throws Exception{
		Scanner scan = new Scanner(new File(
				"C:\\Users\\Rutuja\\Desktop\\edges.txt"));
		int vertices = scan.nextInt()-1;
		int[][] adjMat = new int [vertices][vertices];
		for(int[] row : adjMat){
			Arrays.fill(row, Integer.MAX_VALUE/2);
		}
		while(scan.hasNext()){
			int u = scan.nextInt()-1, v = scan.nextInt()-1,w = scan.nextInt();
			adjMat[u][v] = w;
			adjMat[v][u] = w;			
		}
		for(int i =0; i<vertices; i++){
			adjMat[i][i] = 0;
		}
		for(int k = 0; k<vertices; k++){
			for(int i =0; i< vertices;i++){
				for(int j= 0; j< vertices;j++){
					adjMat[i][j] = Math.min(adjMat[i][j],adjMat[i][k]+adjMat[k][j]);
				}
			}
		}
		return adjMat;
		
	}
	
	public int floydWar(int i, int j) throws Exception{
		int[][] adjMat = adjMatrix();
		return adjMat[i][j];
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(new FloydWarshall().floydWar(0, 4));
		
	}
	
	

}
