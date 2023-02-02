import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1504 {

	static class Node {
		int to, wei;

		public Node(int to, int wei) {
			super();
			this.to = to;
			this.wei = wei;
		}

	}
	static int N, E, A, B;
	static ArrayList<ArrayList<Node>> graph;
	static int sa, sb, sf, ab, af, bf;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int[][] save = new int[E][3];
		int[] dist = new int[N];
		boolean[] vst = new boolean[N];

		graph = new ArrayList<ArrayList<Node>>();
		for(int i = 0; i < N; i++) {
			graph.add(new ArrayList<Node>());
			dist[i] = Integer.MAX_VALUE;
			vst[i] = false;
		}
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken());
			save[i][0] = a;
			save[i][1] = b;
			save[i][2] = e;
			graph.get(a).add(new Node(b, e));
			graph.get(b).add(new Node(a, e));
		}
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken())-1;
		B = Integer.parseInt(st.nextToken())-1;
		//입력

		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.wei, o2.wei));

		q.offer(new Node(0, 0));
		dist[0] = 0;
		vst[0] = true;
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			vst[curNode.to] = true;
			for(int i = 0; i < graph.get(curNode.to).size(); i++) {
				Node neiNode = graph.get(curNode.to).get(i);
				if(dist[curNode.to] + neiNode.wei < dist[neiNode.to]) {
					dist[neiNode.to] = dist[curNode.to] + neiNode.wei;
					q.offer(new Node(neiNode.to, dist[neiNode.to]));
				}
			}
		}
		for(int i = 0; i < N; i++) {
			if(i == A) sa = dist[i];
			if(i == B) sb = dist[i];
			if(i == N-1) sf = dist[i];
		}
//============1회차
		graph = new ArrayList<ArrayList<Node>>();
		for(int i = 0; i < N; i++) {
			graph.add(new ArrayList<Node>());
			dist[i] = Integer.MAX_VALUE;
			vst[i] = false;
		}
		for(int i = 0; i < E; i++) {
			int a = save[i][0];
			int b = save[i][1];
			int e = save[i][2];
			graph.get(a).add(new Node(b, e));
			graph.get(b).add(new Node(a, e));
		}
		q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.wei, o2.wei));
		q.offer(new Node(A, 0));
		dist[A] = 0;
		vst[A] = true;
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			vst[curNode.to] = true;
			for(int i = 0; i < graph.get(curNode.to).size(); i++) {
				Node neiNode = graph.get(curNode.to).get(i);
				if(dist[curNode.to] + neiNode.wei < dist[neiNode.to]) {
					dist[neiNode.to] = dist[curNode.to] + neiNode.wei;
					q.offer(new Node(neiNode.to, dist[neiNode.to]));
				}
			}
		}
		for(int i = 0; i < N; i++) {
			if(i == B) ab = dist[i];
			if(i == N-1) af = dist[i];
		}
//=============
		graph = new ArrayList<ArrayList<Node>>();
		for(int i = 0; i < N; i++) {
			graph.add(new ArrayList<Node>());
			dist[i] = Integer.MAX_VALUE;
			vst[i] = false;
		}
		for(int i = 0; i < E; i++) {
			int a = save[i][0];
			int b = save[i][1];
			int e = save[i][2];
			graph.get(a).add(new Node(b, e));
			graph.get(b).add(new Node(a, e));
		}
		q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.wei, o2.wei));
		q.offer(new Node(B, 0));
		dist[B] = 0;
		vst[B] = true;
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			vst[curNode.to] = true;
			for(int i = 0; i < graph.get(curNode.to).size(); i++) {
				Node neiNode = graph.get(curNode.to).get(i);
				if(dist[curNode.to] + neiNode.wei < dist[neiNode.to]) {
					dist[neiNode.to] = dist[curNode.to] + neiNode.wei;
					q.offer(new Node(neiNode.to, dist[neiNode.to]));
				}
			}
		}
		for(int i = 0; i < N; i++) {
			if(i == N-1) bf = dist[i];
		}
		
		int minA, minB;
		if(sa != Integer.MAX_VALUE && ab != Integer.MAX_VALUE && bf != Integer.MAX_VALUE) {
			minA = sa+ab+bf;
		} else {
			minA = Integer.MAX_VALUE;
		}
		if(sb != Integer.MAX_VALUE && ab != Integer.MAX_VALUE && af != Integer.MAX_VALUE) {
			minB = sb+ab+af;
		} else {
			minB = Integer.MAX_VALUE;
		}
		int min = Math.min(minA, minB);
		if(min == Integer.MAX_VALUE) {System.out.println(-1);}
		else {System.out.println(min);}
	}


}
