package br.ufc.quixada.eda.hash;

public class EnderecamentoInterno2 extends Hash{
	private NoHash tabela[] = null;
	
	public EnderecamentoInterno2(Integer tam) {
		super(tam);
		tabela = new NoHash[tam];
		// TODO Auto-generated constructor stub
	}

	@Override
	public void inserir(Integer chave, String valor) {
		Integer n = fHash(chave);
		NoHash no = new NoHash(chave, valor);
		if(tabela[n] == null){
			tabela[n] = no;
		}
		while (tabela[n].getPros() != -1) {
			if(tabela[n].getChave() == chave) return;
			n = tabela[n].getPros();
		}
		if(tabela[n].getChave() == chave) return;
		int j = 1;
		int max = tabela.length;
		for (int i = n + 1; i < max; i++){
			if(j == max) return;
			if(tabela[i] == null){
				tabela[i] = no; 
				tabela[n].setPros(i);
				return;
			}
			if(i % max == 0) i = 0;
			j++;
		}		
	}

	@Override
	public String buscar(Integer chave) {
		Integer n = fHash(chave);
		if(tabela[n] == null){
			return null;
		}
		while (true) {
			if(tabela[n].getChave() == chave){
				return tabela[n].getValor();
			}else if(tabela[n].getPros() != -1){
				n = tabela[n].getPros();
			}else{
				return null;
			}
		}
	}

	@Override
	public String remover(Integer chave) {
		Integer n = fHash(chave);
		int aux = n;
		if(tabela[n] != null){
			if(tabela[n].getChave() == chave){
				if(tabela[n].getPros() == -1) {
					String a = tabela[n].getValor();
					tabela[n] = null; 
					return a;
				}
				aux = tabela[n].getPros(); //prossimo elemento com o mesmo valor de Hash
				tabela[n] = new NoHash(tabela[aux].getChave(), tabela[aux].getValor());
				tabela[n].setPros(tabela[aux].getPros());
				tabela[aux] = null;
			}
			while (true) {
				if(tabela[n].getChave() == chave){
					tabela[aux].setPros(tabela[n].getPros());
					String p = tabela[n].getValor();
					tabela[n] = null;
					return p;
				}else if(tabela[n].getPros() != -1){
					aux = n;
					n = tabela[n].getPros();
				}else{
					return null;
				}
			}		
		}
		return null;

	}
}