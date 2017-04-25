package br.ufc.quixada.eda.algoritimos;

import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.eda.grafo.Aresta;
import br.ufc.quixada.eda.grafo.Grafo;
import br.ufc.quixada.eda.grafo.ListaAdjacencia;
import br.ufc.quixada.eda.listaprioridades.HeapMinimo;

public class Dijkstra {
	private int origem;
	private int ant[] = null;
	private int d[] = null;
	private int vertices[] = null;
	
	public void executar(Grafo g){
		int x = g.getQtdVertice();
		d = new int[x];
		ant = new int [x];
		vertices =  new int[x];
		//Inicializao Integer.MAX_VALUE
		inicializacao(x, origem);
		
		HeapMinimo Q = new HeapMinimo(g.getQtdVertice());
		Q.contruir(vertices);
		
		while(!Q.vazia()){
			int u = Q.remove();
			ListaAdjacencia adj = g.getAdj()[u];
			adj.inicializarIterator();
			while(adj.hasNext()){
				Aresta a = adj.next();
				int v = (a.getU() == u ? a.getV() : a.getU());
				relaxamento(adj, u, v);
			}
		}
	}
	
	public void inicializacao(int v, int s){
		for (int u = 0; u < v; u++){
			ant[u] = -1;
			d[u] = Integer.MAX_VALUE;
			vertices[u] = u;
		}
		d[s] = 0;
		ant[s] = s;
	}
	
	public void relaxamento(ListaAdjacencia adj, int u, int v){
		if(d[v] > (d[u] + adj.next().getPeso())){
			ant[v] = u;
			d[v] = adj.next().getPeso() + d[u];
		}
		adj.next();
	}
}
