package br.ufc.quixada.eda.conjuntodisjunto;


public class ConjuntoDisjunto{
	private int pai[] = null;
	private int ordem[] = null;
	private int n = 0;
	
	public ConjuntoDisjunto(int n){
		this.n = n;
		pai = new int[n];
		ordem = new int[n];
	}
	
	public void make_set(int i){
		pai[i] = i;
		ordem[i] = 0;
	}
	
	//recursivo
	public int find_set1(int v){
		if(v == pai[v]){
			return v;
		}else return find_set(pai[v]);
	}
	
	public int find_set(int v){
		if(v == pai[v]) return v;
		int paiv = find_set(pai[v]);
		pai[v] = paiv;
		return paiv;
	}
	
	public void link_set(int v, int u){
		if(ordem[v] < ordem[u]){
			pai[v] = u;
			if(ordem[v] == ordem[u]) ordem[u]++;
		}else{
			pai[u] = v;
			if(ordem[v] == ordem[u]) ordem[v]++;
		}
	}
	
	public void union(int v, int u){
		link_set(find_set(v), find_set(u));
	}
}
