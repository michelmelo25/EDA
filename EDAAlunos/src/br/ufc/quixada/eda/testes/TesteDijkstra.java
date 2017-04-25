package br.ufc.quixada.eda.testes;

import java.io.IOException;
import java.util.List;

import br.ufc.quixada.eda.algoritimos.ArvoreGeradoraMinima;
import br.ufc.quixada.eda.grafo.Aresta;
import br.ufc.quixada.eda.grafo.Grafo;
import br.ufc.quixada.eda.util.CriarInstancia;
import br.ufc.quixada.eda.util.EDAConstants;
import br.ufc.quixada.eda.util.EDAUtil;

public class TesteDijkstra {
	public static void main(String args[]){
		try {
			for (int tamanho : CriarInstancia.tamanhoInstanciasGK) {	
				for(int i = 0; i < 4; i++){
					String path = EDAConstants.grafoKruskal + "tb8ch" + tamanho + "_" + i +".txt";
					
					Grafo entrada = EDAUtil.lerGrafo(path);
					
					long tempoInicial = System.currentTimeMillis();				
					ArvoreGeradoraMinima grafo = new ArvoreGeradoraMinima();
					System.out.println("\n" + "tb8ch" + tamanho + "_" + i +":");
					List<Aresta> solucao= grafo.kruskal(entrada);
					
					System.out.println("Custo: " + grafo.getCustoArvore(solucao));
					long tempo = System.currentTimeMillis() - tempoInicial;
					System.out.println("tempo: " + tempo);
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}