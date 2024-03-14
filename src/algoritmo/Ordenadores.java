package algoritmo;

public class Ordenadores {

	public Ordenadores() {
		super (); 
	}
	
	public int [] funcaoBub(int [] vetor) {
		int tamanho = vetor.length;
		for(int i=0; i<tamanho; i++) {
			for(int j=0; j<tamanho -1; j++) {
				if(vetor[j]> vetor[j+1]) {
					int aux = vetor[j];
					vetor[j]= vetor [j+1];
					vetor [j+1] = aux; 
				}
			}

		}
		return vetor; 
	}	
	
	
	public int [] funcaoMerge(int [] vetor, int inicio, int fim) {		
		if(inicio<fim) {
			int meio = (inicio+fim)/2;
			funcaoMerge(vetor, inicio, meio);
			funcaoMerge(vetor, meio+1, fim);
			intercala(vetor, inicio, meio, fim); 
		}
		return vetor; 
	}
	
	private void intercala(int[] vetor, int inicio, int meio, int fim) {
		int novovetor[] = new int [vetor.length]; 
			for(int i = inicio; i<=fim; i++) {
				novovetor[i] = vetor [i]; 
		}
		int esq = inicio; 
		int dir = meio+1; 
		
		for(int cont = inicio; cont <= fim; cont++) {
			if(esq>meio) {
				vetor[cont] = novovetor[dir];
				dir++; 			
			}else if (dir>fim) {
				vetor[cont] = novovetor[esq]; 
				esq++;
			}else if (novovetor[esq]<novovetor[dir]) {
				vetor[cont] = novovetor[esq];
				esq++; 
			}else {
				vetor[cont] = novovetor[dir]; 
				dir++;
			}
			
		}
		
		
	}

	public int [] quick(int [] vetor, int inicio, int fim) {
		if(fim>inicio) {
			int posicaoPivoFixo = dividir (vetor, inicio, fim);
			quick(vetor, inicio, posicaoPivoFixo-1);
			quick(vetor, posicaoPivoFixo+1, fim );
		}
		return vetor; 
	}
	
	private int dividir(int [] vetor, int inicio, int fim) {
		int ponteiroEsquerda = inicio +1; 
		int ponteiroDireita = fim; 
		int pivo = vetor[inicio];
		
		while(ponteiroEsquerda<= ponteiroDireita) {
			while(ponteiroEsquerda<= ponteiroDireita && vetor[ponteiroEsquerda] <= pivo) {
				ponteiroEsquerda++; 
			}
			while(ponteiroDireita >= ponteiroEsquerda && vetor[ponteiroDireita]>pivo) {
				ponteiroDireita--; 
			}
			if(ponteiroEsquerda < ponteiroDireita) {
				trocar (vetor, ponteiroEsquerda, ponteiroDireita); 
				ponteiroEsquerda++; 
				ponteiroDireita--; 
			}
		}
		trocar (vetor, inicio, ponteiroDireita);
		return ponteiroDireita; 
	}
	
	private void trocar (int [] vetor, int i, int j) {
		int auxiliar = vetor [j];
		vetor [j] = vetor[i]; 
		vetor [i] = auxiliar; 
	}
	
	
}
