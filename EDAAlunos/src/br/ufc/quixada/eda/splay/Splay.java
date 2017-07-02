package br.ufc.quixada.eda.splay;

 
public class Splay<E> {

		private No<?> raiz;
		
		
		private No<?> rotacaoDireita(No<?> no){
			No<?> novoNo = no.getEsq();
			no.setEsq(novoNo.getDir());
			novoNo.setDir(no);
			return novoNo;
		}
		private No<?> rotacaoEsquerda(No<?> no){
			No<?> novoNo = no.getDir();
			no.setDir(novoNo.getEsq());
			novoNo.setEsq(no);
			return novoNo;
		}
		
		private No<?> sPlay(No<?> raiz, int chave ){
			if(raiz == null) return null;
			if(raiz.getChave() == chave) return raiz;
			
			if(chave < raiz.getChave()){
				if(raiz.getEsq() != null){
					raiz.setEsq(sPlay(raiz.getEsq(), chave));
					raiz = rotacaoDireita(raiz);
				}
			}else {
				if(raiz.getDir() != null){
					raiz.setDir(sPlay(raiz.getDir(), chave));
					raiz = rotacaoEsquerda(raiz);
				}
			}
			
			return raiz;
		}
		
		public void inserir(int chave, E object){
			raiz = inserir(raiz, chave, object);
		}
		
		private No<?> inserir(No<?> raiz, int chave, E object){
			if(raiz == null)
				return new No<E>(chave, object);
			else if(raiz.getChave() > chave){
				raiz.setEsq(inserir(raiz.getEsq(), chave, object));
			}else if(raiz.getChave() < chave){
				raiz.setDir(inserir(raiz.getDir(), chave, object));
			}
			raiz = sPlay(raiz, chave);
			return raiz;
		}
	
		public No<?> busca(int chave){
			raiz = sPlay(raiz, chave);
			if(raiz.getChave() == chave)
				return raiz;
			else
				return null;
		} 
		
		private void mostraArvore(No<?> n, String s) {
			if(n != null && (n.getEsq() != null || n.getDir() != null))
				mostraArvore(n.getDir(), s + "r");
			int tam = s.length();
			for(int i = 0; i < tam - 1; i++) {
				if(s.charAt(i) != s.charAt(i+1)) {
					System.out.print("| "+"  ");
				}else {
					System.out.print("  "+"  ");
				}
			}
			if(s != "") {
				if(s.endsWith("r") == true)
					System.out.print("┌───");
				else
					System.out.print("└───");
			}
			if(n == null) {
				System.out.println("#");
				return;
			}
			System.out.println(n.getChave());
			if(n != null && (n.getEsq() != null || n.getDir() != null)) {
				mostraArvore(n.getEsq(), s + "l");
			}
		}
		
		public void mostraArvore() {
			mostraArvore(this.raiz, "");
			System.out.println("\n\n");
		}

}