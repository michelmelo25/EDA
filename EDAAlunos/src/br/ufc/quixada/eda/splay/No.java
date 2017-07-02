package br.ufc.quixada.eda.splay;
 
public class No<E> {
	
	private No<?> dir, esq;
	private int chave;
	private E object;
	
	public No(int chave, E object){
		esq = null;
		dir = null;
		this.chave = chave;
		this.object = object;
	}
	
	public No<?> getDir() {
		return dir;
	}
	public void setDir(No<?> direita) {
		this.dir = direita;
	}
	public No<?> getEsq() {
		return esq;
	}
	public void setEsq(No<?> esquerda) {
		this.esq = esquerda;
	}
	public int getChave() {
		return chave;
	}
	public void setChave(int chave) {
		this.chave = chave;
	}
	public E getObject() {
		return object;
	}
	public void setObject(E object) {
		this.object = object;
	}
}