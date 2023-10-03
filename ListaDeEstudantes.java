public class ListaDeEstudantes{
    Cidade cidade;
    Estudante listaDeEstudantes[]; 
    int qtdEstudantes;

    public ListaDeEstudantes(Cidade cidade, int tamanholista){
        this.cidade = cidade;
        listaDeEstudantes = new Estudante[tamanholista];
    }
    public void adicionaEstudante(Estudante est){
        
        for(int i = 0; i < listaDeEstudantes.length; i++){
            if(listaDeEstudantes[i] != null){
                if(listaDeEstudantes[i].getCodigo() == est.getCodigo()){
                    System.out.println("Estudante ja existe");
                    return;
                }
            }
        }
        if(qtdEstudantes < listaDeEstudantes.length){
            listaDeEstudantes[qtdEstudantes] = est;
            qtdEstudantes = qtdEstudantes + 1;
        }
        else{
           System.out.println("Lista Lotada!"); 
        }
    }
    
    public void visualizaEstudantes(){
        for(int i = 0; i < listaDeEstudantes.length; i++){
            if(listaDeEstudantes[i] != null){
                listaDeEstudantes[i].exibeDados();
            }
        }
    }
    
    public Estudante[] pesquisaEstudantePorNome(String parteNome){
        int qtdEstudantesEncontrados = 0;
        for(int i = 0; i < listaDeEstudantes.length; i++){
            if(listaDeEstudantes[i] != null){
                String temp = listaDeEstudantes[i].getNome();
                if(temp.contains(parteNome)){
                    qtdEstudantesEncontrados = qtdEstudantesEncontrados + 1;
                }
            }
        }
        if(qtdEstudantesEncontrados == 0){
            return null;
        }
        else{
            Estudante estudantesEncontrados[] = new Estudante[qtdEstudantesEncontrados];
            int indiceDeEstudanteEncontrado = 0;
            for(int i = 0; i < listaDeEstudantes.length; i++){
                if(listaDeEstudantes[i] != null){
                    String temp = listaDeEstudantes[i].getNome();
                    if(temp.contains(parteNome)){
                        estudantesEncontrados[indiceDeEstudanteEncontrado] = listaDeEstudantes[i];
                        indiceDeEstudanteEncontrado ++;
                    }
                }
            }
            return estudantesEncontrados;
        }
    }
}
    
    
