package br.ufc.quixada.eda.avl;
  
public class NoAVL {
	private NoAVL esq;
	private NoAVL dir;
	private int altura;
	private int chave;
	
	public NoAVL(int chave){
		this.esq = null;
		this.dir = null;
		this.altura = 1;
		this.chave = chave;
	}

	public NoAVL getEsq() {
		return esq;
	}

	public void setEsq(NoAVL esq) {
		this.esq = esq;
	}

	public NoAVL getDir() {
		return dir;
	}

	public void setDir(NoAVL dir) {
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
	
}
