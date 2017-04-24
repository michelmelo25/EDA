package br.ufc.quixada.eda.algoritimos;

import java.util.ArrayList;
import java.util.List;
import br.ufc.quixada.eda.conjuntodisjunto.*;
import br.ufc.quixada.eda.grafo.*;


public class ArvoreGeradoraMinima {
	public List<Aresta> kruskal(Grafo g){
		List<Aresta> solucao = new ArrayList<Aresta>();
		ConjuntoDisjunto conj = new ConjuntoDisjunto(g.getQtdVertice());
		
		for(int i = 0; i < g.getQtdVertice(); i++) conj.makeSet(i);
		
		g.quickSort(0, g.getArestas().length - 1);
		
		for(int i = 0; i < g.getQtdAresta(); i++){
			Aresta a[] = g.getArestas();
			if(conj.findSetIntel(a[i].getV()) != conj.findSetIntel(a[i].getU())){
				solucao.add(a[i]);
				conj.unionIntel(a[i].getV(), a[i].getU());
			}
		}
		return solucao;
	}
	
	public double getCustoArvore(List<Aresta> solucao){
		double custo = 0;
		for (Aresta aresta : solucao) {
			custo += aresta.getPeso();
		}
		return custo;
	}
}