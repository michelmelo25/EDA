package br.ufc.quixada.eda.avl;

public class NoAVL<E> {
	private NoAVL<E> esq;
	private NoAVL<E> dir;
	private E elemento;
	private int altura;
	private int chave;
	
	public NoAVL(int chave, E elemento){
		this.esq = null;
		this.dir = null;
		this.altura = 1;
		this.chave = chave;
		this.setElemento(elemento);
	}

	public NoAVL<E> getEsq() {
		return esq;
	}

	public void setEsq(NoAVL<E> esq) {
		this.esq = esq;
	}

	public NoAVL<E> getDir() {
		return dir;
	}

	public void setDir(NoAVL<E> dir) {
		this.dir = dir;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	public E getElemento() {
		return elemento;
	}

	public void setElemento(E elemento) {
		this.elemento = elemento;
	}
	
}
