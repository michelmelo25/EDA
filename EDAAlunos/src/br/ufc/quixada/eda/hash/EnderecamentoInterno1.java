package br.ufc.quixada.eda.hash;

public class EnderecamentoInterno1 extends Hash{
	private Integer p = 0;
	private NoHash tabela[] = null;
	
	public EnderecamentoInterno1(Integer tam) {
		super(tam);
		p = (int) (0.3 * tam);
		tabela = new NoHash[tam];
	}
	
	@Override
	public Integer fHash (Integer chave){
		return chave % p;
	}

	@Override
	public void inserir(Integer chave, String valor) {
		Integer n = fHash(chave);
		System.out.println(n);
		NoHash no = new NoHash(chave, valor);
		if(tabela[n] == null){
			tabela[n] = no;
			return;
		}
		int aux = n;
		
		while (tabela[aux].getPros() != -1) {
			if(tabela[aux].getChave() == chave) return;
			aux = tabela[aux].getPros();
		}
		if(tabela[aux].getChave() == chave) return;
		for (int i = p + 1; i < tabela.length; i++){
			if(tabela[i] == null){
				tabela[i] = no; 
				tabela[aux].setPros(i);
				return;
			}
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
		Integer aux = n;
		if(tabela[n] != null){
			if (tabela[n].getChave() == chave){
				if(tabela[n].getPros() == -1) {
					String a = tabela[n].getValor();
					tabela[n] = null; 
					return a;
				}
				aux = tabela[n].getPros();
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
		}else{
			return null;
		}
	}
}
