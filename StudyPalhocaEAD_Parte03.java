public class StudyPalhocaEAD_Parte03{
    public static void main(){
        int codCidade = 0;
        String tempNomeCidade = Teclado.leString("Digite o nome da Cidade: ");
        String tempUF = Teclado.leString("Estado (UF): ");
        Cidade cidade = new Cidade(codCidade, tempNomeCidade, tempUF);
        
        int tamanhoDaLista = Teclado.leInt("Digite o tamanho da turma de estudantes");
        ListaDeEstudantes lista = new ListaDeEstudantes(cidade, tamanhoDaLista);
        
        menu(cidade, lista);
    }
    
    private static void menu(Cidade cidade, ListaDeEstudantes lista){
        int opcao = 0;
        do{
            System.out.println("\n          =============================================");
            System.out.println("          | 1 - Visualizar Lista de Estudantes        |");
            System.out.println("          | 2 - Adicionar Estudantes                  |");
            System.out.println("          | 3 - Pesquisar Estudantes por Nome         |");
            System.out.println("          | 0 - Sair                                  |");
            System.out.println("          =============================================\n");
            opcao = Teclado.leInt("Opcao -> ");
            System.out.println("\n");
            
            switch(opcao){
                case 1:
                    lista.visualizaEstudantes();
                    break;
                case 2:
                    int tipoDeEstudante = Teclado.leInt("Digite 1 para pagante ou 2 para bolsista: ");
                    if(tipoDeEstudante == 1){
                        Estudante estudante = new Estudante(Teclado.leInt("Codigo de matricula: "),
                                                            Teclado.leString("Nome: "),
                                                            Teclado.leString("Data de nascimento: "),
                                                            Teclado.leString("Email: "),
                                                            Teclado.leString("Senha: "),
                                                            cidade);
                        lista.adicionaEstudante(estudante);
                        estudante.exibeDados();
                    }
                    else if(tipoDeEstudante == 2){
                        EstudanteBolsista bolsista = new EstudanteBolsista(Teclado.leInt("Codigo de matricula: "),
                                                            Teclado.leString("Nome: "),
                                                            Teclado.leString("Data de nascimento: "),
                                                            Teclado.leString("Email: "),
                                                            Teclado.leString("Senha: "),
                                                            cidade,
                                                            Teclado.leString("Tipo de Bolsa: "));
                        lista.adicionaEstudante(bolsista);
                        bolsista.exibeDados();
                    }
                    else{
                        System.out.println("Opcao invalida... voltando ao menu principal");
                    }
                    break;
                case 3:
                    Estudante[] tempEstudantesEncontrados = lista.pesquisaEstudantePorNome(Teclado.leString("Digite parte do nome para pesquisar: "));
                    if(tempEstudantesEncontrados != null){
                        System.out.println("Estudantes encontrados: ");
                        for(int i=0; i < tempEstudantesEncontrados.length; i++){
                            tempEstudantesEncontrados[i].exibeDados();
                        }
                    }
                    else{
                        System.out.println("Nenhum Estudante foi Encontrado!");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao Invalida!");
                    break;
            }
        }while(opcao != 0);
    }
}