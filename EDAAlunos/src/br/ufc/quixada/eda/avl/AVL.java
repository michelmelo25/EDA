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
			if((altura(raiz.getEsq()) - altura(raiz.getDir())) != 1){
				if((altura(raiz.getDir()) - altura(raiz.getEsq())) != 0){
					if(altura(raiz.getEsq().getEsq()) > altura(raiz.getEsq().getDir())){
						raiz = rotacaoDireita(raiz);
					} else{
						raiz = rotacaoDuplaDireita(raiz);
					}
			
				}
			}
		}else if(raiz.getChave() < chave){
			raiz.setDir(inserir(raiz.getDir(),chave));
			if((altura(raiz.getDir()) - altura(raiz.getEsq())) != 1){
				if((altura(raiz.getDir()) - altura(raiz.getEsq())) != 0){
					if(altura(raiz.getDir().getDir()) > altura(raiz.getDir().getEsq())){
						raiz = rotacaoEsqueda(raiz);
					} else {
						raiz = rotacaoDuplaEsquerda(raiz);
					}
			}  }
		}
		raiz.setAltura(max(altura(raiz.getDir()), altura(raiz.getEsq())));
		raiz = balanceamento(raiz);
		raiz = balanceamento(raiz);
		return raiz;
	}
	
	private int max(int altura, int altura2) {
		return (altura > altura2 ? altura : altura2);
	}

	private NoAVL rotacaoDireita(NoAVL raiz){
		NoAVL aux = raiz.getEsq();
		raiz.setEsq(aux.getDir());
		aux.setDir(raiz);
		raiz.setAltura(max(altura(raiz.getEsq()), altura(raiz.getDir())) + 1);
		aux.setAltura(max(altura(aux.getEsq()), altura(raiz.getDir())) + 1);
		return aux;
	}
	
	private NoAVL rotacaoDuplaDireita(NoAVL raiz){
		raiz = rotacaoEsqueda(raiz.getEsq());
		return rotacaoDireita(raiz);
	}
	
	private NoAVL rotacaoEsqueda(NoAVL raiz){
		NoAVL aux = raiz.getDir();
		raiz.setDir(aux.getEsq());
		aux.setEsq(raiz);
		raiz.setAltura(max(altura(raiz.getDir()), altura(raiz.getEsq())) + 1);
		aux.setAltura(max(altura(aux.getDir()), altura(raiz.getEsq())) + 1);
		return aux;
	}
	
	private NoAVL rotacaoDuplaEsquerda(NoAVL raiz){
		raiz = rotacaoDireita(raiz.getDir());
		return rotacaoEsqueda(raiz);
	}
	
	public void showTime(){
		showTime(raiz);
	}
	
	private void showTime(NoAVL no){
		if(no == null) return;
		System.out.println(no.getChave() + " " + altura(no));
		showTime(no.getDir());
		showTime(no.getEsq());
	} 
	
	private int altura(NoAVL raiz){
		return (raiz != null ? raiz.getAltura() : 0);
	}
	
	private int difAltura(NoAVL r) {
		return altura(r.getEsq()) - altura(r.getDir());
	}
	
	public NoAVL balanceamento(NoAVL r) {
		if(difAltura(r) == 2) {
			if(difAltura(r.getEsq()) > 0) {
				r = rotacaoDireita(r);
			}else {
				r = rotacaoDuplaDireita(r);
			}
		}else if(difAltura(r) == -2) {
			if(difAltura(r.getDir()) < 0) {
				r = rotacaoEsqueda(r);
			}else {
				r = rotacaoDuplaEsquerda(r);
			}
		}
		r.setAltura(max(altura(r.getEsq()), altura(r.getDir())) + 1);
		return r;
	}
}
