package br.ufc.quixada.eda.testes;

import java.io.IOException;
import java.util.List;

import br.ufc.quixada.eda.algoritimos.ArvoreGeradoraMinima;
import br.ufc.quixada.eda.grafo.Aresta;
import br.ufc.quixada.eda.grafo.Grafo;
import br.ufc.quixada.eda.listaprioridades.HeapTernarioMaximo;
import br.ufc.quixada.eda.util.CriarInstancia;
import br.ufc.quixada.eda.util.EDAConstants;
import br.ufc.quixada.eda.util.EDAUtil;
import br.ufc.quixada.eda.util.Operacao;

public class TesteGrafosKraskal {
	public static void main(String args[]){
		try {
			for (int tamanho : CriarInstancia.tamanhoInstancias) {	
				for(int i = 0; i < 4; i++){
					String path = EDAConstants.caminhoPasta + "tb8ch" + tamanho + "_" + i +".txt";
					
					Grafo entrada = EDAUtil.grafo(path);
					
					long tempoInicial = System.currentTimeMillis();				
					ArvoreGeradoraMinima grafo = new ArvoreGeradoraMinima();
					System.out.println(tempoInicial + "\n");
					int caminho = 0;
					System.out.println("\n" + "tb8ch" + tamanho + "_" + i +":\n");
					int h = 0;
					for (Aresta e : grafo.kroskal(entrada)) {
						System.out.println(h + "\n");
						h++;
						caminho += e.getPeso();
					}
					
					long tempo = System.currentTimeMillis() - tempoInicial;
					System.out.println(tempo + "\n");
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}