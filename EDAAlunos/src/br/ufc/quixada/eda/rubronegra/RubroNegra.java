package br.ufc.quixada.eda.rubronegra;
 
public class RubroNegra {

	private No raiz;
	
	public RubroNegra(){
		raiz = null;
	}
	
	public void add(int chave){
		raiz = add(chave, raiz);
		raiz.setCor(No.PRETO);
	}
	
	private No add(int chave, No raiz){
		if(raiz == null){
			No no = new No(chave);
			show();
			System.out.println();
			return no;
		}
		if(chave < raiz.getChave()){
			raiz.setEsq(add(chave, raiz.getEsq()));
		}else if(chave > raiz.getChave()){
			raiz.setDir(add(chave, raiz.getDir()));	
		}
		
		if(isVermelho(raiz.getDir()) && isVermelho(raiz.getEsq()) && isVermelho(raiz.getEsq().getEsq())){
				raiz.setCor(No.VERMELHO);
				raiz.getEsq().setCor(No.PRETO);
				raiz.getDir().setCor(No.PRETO);
				
		}else if(isVermelho(raiz.getDir()) && isVermelho(raiz.getEsq()) && isVermelho(raiz.getDir().getDir())){
			raiz.setCor(No.VERMELHO);
			raiz.getEsq().setCor(No.PRETO);
			raiz.getDir().setCor(No.PRETO);
			
		}else if(isPreto(raiz) && isVermelho(raiz.getEsq()) && isVermelho(raiz.getEsq().getDir())){
				raiz.setEsq(rotacaoEsqueda(raiz.getEsq()));
		}else if( isPreto(raiz) && isVermelho(raiz.getDir()) && isVermelho(raiz.getDir().getEsq())){
				raiz.setDir(rotacaoDireita(raiz.getDir()));				
		}else if(isPreto(raiz.getDir()) && isVermelho(raiz.getEsq()) && isVermelho(raiz.getEsq().getEsq())){
				raiz = rotacaoDireita(raiz);
				raiz.setCor(No.PRETO);
				raiz.getDir().setCor(No.VERMELHO);
		}else if(isVermelho(raiz.getDir()) && isPreto(raiz.getEsq()) && isVermelho(raiz.getDir().getDir())){				
				raiz = rotacaoEsqueda(raiz);
				raiz.setCor(No.PRETO);
				raiz.getEsq().setCor(No.VERMELHO);
		}
		return raiz;
	}
	
	public No busca(int chave){
		return busca(raiz, chave);
	}
	
	private No busca(No no, int chave){
		if(chave == no.getChave()) return no;
		if(chave < no.getChave()){
			return busca(no.getEsq(), chave);
		}else if(chave > no.getChave()){
			return busca(no.getDir(), chave);
		}
		return null;
	}
	
	private No rotacaoDireita(No raiz){
		No aux = raiz.getEsq();
		raiz.setEsq(aux.getDir());
		aux.setDir(raiz);
		return aux;
	}
	
	private No rotacaoEsqueda(No raiz){
		No aux = raiz.getDir();
		raiz.setDir(aux.getEsq());
		aux.setEsq(raiz);
		return aux;
	}
	
	public boolean isPreto(No no){
		if(no == null) return true;
		if(no.isCor() == No.PRETO) return true;
		return false;
	}
	
	public boolean isVermelho(No no){
		return !isPreto(no);
	}
	
	public void show(){
		show(raiz);
	}
	
	private void show(No no){
		if(no == null) return;
		System.out.println(no.getChave() + " " + no.isCor());
		show(no.getEsq());
		show(no.getDir());
	}	
}
