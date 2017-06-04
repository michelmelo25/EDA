package br.ufc.quixada.eda.avl;
  
public class AVL {
	private NoAVL raiz = null;
	
	public void inserir(int chave){
		this.raiz = inserir(this.raiz, chave);
	}
	
	private NoAVL inserir(NoAVL raiz, int chave){
		if(raiz == null){
			NoAVL no = new NoAVL(chave);
			return no;
		}
		if(raiz.getChave() > chave){
			raiz.setEsq(inserir(raiz.getEsq(), chave));
			if((altura(raiz.getEsq()) - altura(raiz.getDir())) == 2){
				if(altura(raiz.getEsq().getEsq()) > altura(raiz.getEsq().getDir())){
					raiz = rotacaoDireita(raiz);
				} else{
					raiz = rotacaoDuplaDireita(raiz);
				}
			}
			
		}else if(raiz.getChave() < chave){
			raiz.setDir(inserir(raiz.getDir(),chave));
			if((altura(raiz.getDir()) - altura(raiz.getEsq())) == 2){
				if(altura(raiz.getDir().getDir()) > altura(raiz.getDir().getEsq())){
					raiz = rotacaoEsqueda(raiz);
				} else {
					raiz = rotacaoDuplaEsquerda(raiz);
				}
			}
		}
		raiz.setAltura(max(altura(raiz.getDir()), altura(raiz.getEsq())));
		return raiz;
	}
	
	private int max(int altura, int altura2) {
		return (altura > altura2 ? altura : altura2);
	}

	private NoAVL rotacaoDireita(NoAVL raiz){
		NoAVL aux = raiz.getEsq();
		raiz.setEsq(aux.getDir());
		aux.setDir(raiz);
		
		if(altura(raiz.getEsq().getEsq()) > altura(raiz.getEsq().getDir())){
			raiz.getEsq().setAltura(altura(raiz.getEsq().getEsq()) + 1);
		}else{
			raiz.getEsq().setAltura(altura(raiz.getEsq().getDir()) + 1);
		}
		
		if(altura(aux.getDir().getEsq()) > altura(aux.getDir().getDir())){
			aux.getDir().setAltura(altura(aux.getDir().getEsq()) + 1);
		}else{
			aux.getDir().setAltura(altura(aux.getDir().getDir()) + 1);
		}
		return aux;
	}
	
	private NoAVL rotacaoDuplaDireita(NoAVL raiz){
		raiz = rotacaoEsqueda(raiz);
		return rotacaoDireita(raiz);
	}
	
	private NoAVL rotacaoEsqueda(NoAVL raiz){
		NoAVL aux = raiz.getDir();
		raiz.setDir(aux.getEsq());
		aux.setEsq(raiz);
		
		if(altura(raiz.getDir().getEsq()) > altura(raiz.getDir().getDir())){
			raiz.getDir().setAltura(altura(raiz.getDir().getEsq()) + 1);
		}else{
			raiz.getDir().setAltura(altura(raiz.getDir().getDir()) + 1);
		}
		
		if(altura(aux.getEsq().getEsq()) > altura(aux.getDir().getDir())){
			aux.getEsq().setAltura(altura(aux.getEsq().getEsq()) + 1);
		}else{
			aux.getEsq().setAltura(altura(aux.getEsq().getDir()) + 1);
		}
		return aux;
	}
	
	private NoAVL rotacaoDuplaEsquerda(NoAVL raiz){
		raiz = rotacaoDireita(raiz);
		return rotacaoEsqueda(raiz);
	}
	
	private int altura(NoAVL raiz){
		return (raiz != null ? raiz.getAltura() : 0);
	}
}
