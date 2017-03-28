package br.ufc.quixada.eda.listaprioridades;

import java.util.List;

/**
 * Implementa a lista de prioridade usando Heap Maximo.
 * @author fabio
 *
 */
public class HeapMaximo {
	private int nMaximo = 0;
	private int vetor[] = null;
	private int n = 0;
	
	public HeapMaximo(int Nmaximo){
		nMaximo = Nmaximo;
		vetor = new int[Nmaximo];
	}
	
	private void subir(int i){
		int k = i/2; // seleciona o pai
		
		if(k >= 1){ // olha se o pai esta no vetor - se estiver
			if(vetor[k] < vetor[i]){ //compara pai e filho - se o pai for menor que o filho
				int aux = vetor[i];  // realiza um swap entre eles
				vetor[i] = vetor[k];
				vetor[k] = aux;
				subir(k);  //chama a recurcao
			}
		}
	}
	
	private void descer(int i){
		int k = 2 * i; //seleciona o primeiro filho
		
		if(k <= n){ //olha se o primeiro filho esta no vetor - se estiver
			if(k + 1 <= n){ //olha se o segundo filho esta no vetor - se estiver
				if(vetor[k] < vetor[k + 1]){ //seleciona o maior deles
					k++;
				}
			}
			if(vetor[k] > vetor[i]){ //compara quem e maior (pai ou filho) - se o filho for maior
				int aux = vetor[k];  // realiza um swap entre eles
				vetor[k] = vetor[i];
				vetor[i] = aux;
				descer(k); //chama a recurcao
			}
		}
	}
	
	public void contruir(List<Integer> entrada){
		for(int i = 1; i < entrada.size(); i++){
			vetor[i] = entrada.get(i - 1);
			n++;
		}
		for(int i = n/2 ; i > 0; i--){
			descer(i);
		}
	}
	
	public int getMaximaPrioridade(){
		return vetor[1];
	}
	
	public int remove(){
		if(n >= 1){
			int aux = vetor[1];
			vetor[1] = vetor[n];
			n--;
			//imprimir();
			descer(1);
			return aux;
		}
		return 0;
	}	
	
	public void inserir(int prioridade){
		if( n <= nMaximo){
			vetor[n + 1] = prioridade;
			n++;
			subir(n);
		}
	}
	
	public void alterarPrioridade(int prioridade, int novaPrioridade){		
		for(int i = 1; i <= n; i++){
			if(vetor[i] == prioridade){
				vetor[i] = novaPrioridade;
				if(novaPrioridade > prioridade){
					subir(i);
					return;
				}else if(novaPrioridade < prioridade){
					descer(i);
					return;
				}
			}
		}
		
	}	
	
	public void imprimir(){
		for(int i = 1; i <= n; i++){
			System.out.println(vetor[i]);
		}
	}
}
