package br.ufc.quixada.eda.rubronegra;
 
public class No {

	private No esq;
	private No dir;
	private int chave;
	private boolean cor;
	public static final boolean PRETO = true;
	public static final boolean VERMELHO = false;
	
	public No(int chave){
		this.chave = chave;
		esq = null;
		dir = null;
		cor = VERMELHO;
	}

	public No getEsq() {
		return esq;
	}

	public void setEsq(No esq) {
		this.esq = esq;
	}

	public No getDir() {
		return dir;
	}

	public void setDir(No dir) {
		this.dir = dir;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	public boolean isCor() {
		return cor;
	}

	public void setCor(boolean cor) {
		this.cor = cor;
	}
	
}
