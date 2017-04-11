package br.ufc.quixada.eda.listaprioridades;

import java.util.List;

/**
 * Implementa a lista de prioridade usando vetor ordenado.
 * Reparem que aqui voc� devem utilizar obrigat�riamente o quickSort 
 * para realizar a ordena��o, quando for necess�rio.
 * @author fabio
 *
 */
public class LPMaximaOrdenada {
	private int n = 0;
	private int nMaximo;
	private int vetor[] = null;
	

	
	public LPMaximaOrdenada(int nMaximo){
		this.nMaximo = nMaximo;
		vetor = new int [nMaximo];		
	}
	
	public void contruir(List<Integer> entrada){
		for(int i = 0; i < entrada.size(); i++){
			vetor[i] = entrada.get(i);
		}
		n = entrada.size();
		quickSort(0, n);
		
		
	}
	
	public int getMaximaPrioridade(){
		return vetor[n];
	}
	
	public int remove(){
		if (n <= 0)
			return -1;
		return vetor[n--];
	}	
	
	public void inserir(int prioridade){
		if(n + 1 > nMaximo){
			int i = n -1;
			if(vetor[i] > prioridade){
				while (i >= 0){
					vetor[i + 1] = vetor[i];
					i--;
				}
			}
			vetor[i + 1] = prioridade;
			n++;
		}
	}
	
	public void alterarPrioridade(int prioridade, int novaPrioridade){
		if(n > 0){
			int i = 0 ;
			while(i < n){
				if(vetor[i] == prioridade)
					break;
				i++;
			}
			while(i < n -1){
				vetor[i] = vetor[i + 1];
				i++;
			}
			n--;
			inserir(novaPrioridade);
		}
	}
	
	private void quickSort(int ini, int fim){
		if(ini < fim){
			int posPivo = particiona(ini, fim);
			quickSort(ini, posPivo - 1);
			quickSort(posPivo + 1, fim);
		}
	}
	
	private int particiona(int inicio, int fim){
		int pivo = vetor[inicio];
		int i = inicio + 1;
		int f = fim;
		
		while(i <= f){
			if(vetor[i] <= pivo){
				i++;
			}else if(pivo < vetor[f]){
				f--;
			}else{
				int aux = vetor[i];
				vetor[i] = vetor[f];
				vetor[f] = aux;
				i++;
				f--;
			}
		}
		vetor[inicio] = vetor[f];
		vetor[f] = pivo;
		return f;
	}
	
	public void imprimir(){
		for(int i = 1; i <= n; i++){
			System.out.println(vetor[i] + " ");
		}
	}
}
