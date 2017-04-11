package br.ufc.quixada.eda.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.ufc.quixada.eda.grafo.Aresta;
import br.ufc.quixada.eda.grafo.Grafo;
import br.ufc.quixada.eda.algoritmos.ArvoreGeradoraMinima;

public class EDAUtil {
	/**
	 * Ler o arquivo que contém as prioridades iniciais da lista de prioridades.
	 * @param path
	 * @return
	 * @throws IOException
	 */
    public static List<Integer> getDadosIniciais(String path) throws IOException {
        List<Integer> entrada = new ArrayList<Integer>();
        Scanner scanner = new Scanner(new FileReader(path)).useDelimiter("\r\n");
        
		while (scanner.hasNext())
			entrada.add(scanner.nextInt());
		
		scanner.close();
        return entrada;
    }
    
    public static Grafo lerGrafo(String path) throws IOException{
    	Scanner scanner = new Scanner(new FileReader(path)).useDelimiter(" |\r\n");
    	Grafo g = new Grafo(scanner.nextInt(), scanner.nextInt());
    	Aresta arestas[] = new Aresta[g.getQtdAresta()];
    	
    		int pos = 0;
    	while(scanner.hasNext()){
    			arestas[pos] = new Aresta(scanner.nextInt(), scanner.nextInt(), scanner.nextDouble());
    			pos++;
    	}
    	scanner.close();
    	g.setArestas(arestas);
    	return g;
    }
    /*
    
    public static Grafo lerGrafo(String path) throws IOException{
    	Scanner scanner = new Scanner(new FileReader(path)).useDelimiter(" |\r\n");
    	Grafo g = new Grafo();
    	Aresta arestas[] = new Aresta[g.getQtdAresta() * 2];
    	
    	if(scanner.hasNext()){
    		g.setQtdAresta(scanner.nextInt());
    		g.setQtdVertice(scanner.nextInt()); 
    	}
    		int pos = 0;
    	while(scanner.hasNext()){
    			arestas[pos] = new Aresta(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
    			pos++;
    	}
    	scanner.close();
    	g.setArestas(arestas);
    	return g;
    }
    */
    
    /**
     * Ler as operações que serão realizadas na lista de prioridades após a sua criação.
     * @param path
     * @return
     * @throws IOException
     */
    public static List<Operacao> getOperacoes(String path) throws IOException {
        List<Operacao> operacoes = new ArrayList<Operacao>();
        Scanner scanner = new Scanner(new FileReader(path)).useDelimiter(" |\r\n");	
		while (scanner.hasNext())
			operacoes.add(new Operacao(scanner.next(), scanner.nextInt(), scanner.nextInt()));
			
		scanner.close();
        return operacoes;
    }       
}
