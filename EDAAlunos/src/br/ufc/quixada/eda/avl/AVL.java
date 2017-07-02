package br.ufc.quixada.eda.avl;

public class AVL<T> {
	private NoAVL<T> raiz = null;
	
	public void inserir(int chave, T elemento){
		this.raiz = inserir(this.raiz, chave, elemento);
	}
	
	private NoAVL<T> inserir(NoAVL<T> raiz, int chave, T elemento){
		if(raiz == null){
			NoAVL<T> no = new NoAVL<>(chave, elemento);
			return no;
		}
		if(raiz.getChave() > chave){
			raiz.setEsq(inserir(raiz.getEsq(), chave, elemento));
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
			raiz.setDir(inserir(raiz.getDir(),chave, elemento));
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
		return raiz;
	}
	
	private int max(int altura, int altura2) {
		return (altura > altura2 ? altura : altura2);
	}

	private NoAVL<T> rotacaoDireita(NoAVL<T> raiz){
		NoAVL<T> aux = raiz.getEsq();
		raiz.setEsq(aux.getDir());
		aux.setDir(raiz);
		raiz.setAltura(max(altura(raiz.getEsq()), altura(raiz.getDir())) + 1);
		aux.setAltura(max(altura(aux.getEsq()), altura(raiz.getDir())) + 1);
		return aux;
	}
	
	private NoAVL<T> rotacaoDuplaDireita(NoAVL<T> raiz){
		raiz = rotacaoEsqueda(raiz.getEsq());
		return rotacaoDireita(raiz);
	}
	
	private NoAVL<T> rotacaoEsqueda(NoAVL<T> raiz){
		NoAVL<T> aux = raiz.getDir();
		raiz.setDir(aux.getEsq());
		aux.setEsq(raiz);
		raiz.setAltura(max(altura(raiz.getDir()), altura(raiz.getEsq())) + 1);
		aux.setAltura(max(altura(aux.getDir()), altura(raiz.getEsq())) + 1);
		return aux;
	}
	
	private NoAVL<T> rotacaoDuplaEsquerda(NoAVL<T> raiz){
		raiz = rotacaoDireita(raiz.getDir());
		return rotacaoEsqueda(raiz);
	}
	
	public void showTime(){
		showTime(raiz);
	}
	
	private void showTime(NoAVL<T> no){
		if(no == null) return;
		System.out.println(no.getChave() + " " + altura(no));
		showTime(no.getDir());
		showTime(no.getEsq());
	}
	
	private int altura(NoAVL<T> raiz){
		return (raiz != null ? raiz.getAltura() : 0);
	}
	
	private int difAltura(NoAVL<T> r) {
		return altura(r.getEsq()) - altura(r.getDir());
	}
	
	public NoAVL<T> balanceamento(NoAVL<T> r) {
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