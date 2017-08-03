package br.edu.ifce.listaduplamenteencadeada;

public class ListaDuplamenteEncadeadaImpl implements ListaDuplamenteEncadeada {

	public int tamanho = 0;
	public No header;
	
	@Override
	public Integer insereFinal(Integer valor) {
		
		No newNo = new No(valor, null, null);
		
		if(listaVazia()){
			header = newNo;
		}else{
			No lastNo = getCauda();
			newNo.setAnterior(lastNo);
			lastNo.setProximo(newNo);
		}
		
		tamanho++;
		return valor;
	}

	@Override
	public Integer insereInicio(Integer valor) {
		
		No novoNo = new No(valor, null, null);
		
		if(listaVazia()){
			header = novoNo;
		}else{
			header.setAnterior(novoNo);
			novoNo.setProximo(header);
			header = novoNo;
		}
		
		tamanho++;
		return valor;
	}

	@Override
	public Integer inserePosicao(int pos, Integer valor) {
		
		if(pos == 0){
			return insereInicio(valor);
		}
		
		No novoNo = new No(valor, null, null);
		No noPosicao = pesquisaPosicao(pos);
		
		noPosicao.getAnterior().setProximo(novoNo);
		noPosicao.setAnterior(novoNo);
		novoNo.setProximo(noPosicao);
		
		tamanho++;
		return valor;
	}

	@Override
	public Integer insereOrdenado(Integer valor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer removeInicio() {
		
		if(listaVazia()){
			System.out.println("Lista vazia, não há elemento a serem removidos");
			return null;
		}
		
		No noRemovido = header;
		header = header.getProximo();
		header.setAnterior(null);
		tamanho--;
		return noRemovido.getValor();
	}

	@Override
	public Integer removeFinal() {
		if(listaVazia()){
			System.out.println("Lista vazia, não há elemento a serem removidos");
			return null;
		}
		No last = getCauda();
		last.getAnterior().setProximo(null);
		tamanho--;
		return last.getValor();
	}

	@Override
	public Integer removePosicao(int pos) {
		if(listaVazia()){
			System.out.println("Lista vazia, não há elemento a serem removidos");
			return null;
		}
		
		if(pos == 0){
			return removeInicio();
		}
		
		No noPosicao = pesquisaPosicao(pos);
		noPosicao.getAnterior().setProximo(noPosicao.getProximo());
		noPosicao.getProximo().setAnterior(noPosicao.getAnterior());
		noPosicao.setProximo(null);
		noPosicao.setAnterior(null);
		return noPosicao.getValor();
	}

	@Override
	public void ordenaLista() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public No pesquisaPosicao(int pos) {
		No no =header;
		for(int i=0; i<tamanho; i++){
			if(pos==i){
				break;
			}
			no = no.getProximo();
		}
		
		return no;
	}
	
	public boolean listaVazia(){
		return this.tamanho == 0;
	}
	
	public No getCauda(){
		No aux = header;
		while(aux.getProximo() != null){
			aux = aux.getProximo();
		}
		
		return aux;
	}
	
	
	public void imprimir(){
		
		if(listaVazia()){
			System.out.println("A lista está vazia");
			return;
		}
		
		No no = header;
		
		int counter=0;
		System.out.println("-------- IMPRIMINDO FILA --------\n");

		while (no.getProximo() != null) {
			System.out.println("Elemento [" + counter + "] = " + no.getValor());
			no = no.getProximo();
			counter++;
		}

		System.out.println("Elemento [" + counter + "] = " + no.getValor());
	}

}
