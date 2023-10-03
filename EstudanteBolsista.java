public class EstudanteBolsista extends Estudante{
    
    private String tipoDeBolsa;
    
    public EstudanteBolsista(int cod, String nom, String dat, String ema, String sen, Cidade cid, String tipoDeBolsa){
        super(cod, nom, dat, ema, sen, cid);
        this.tipoDeBolsa = tipoDeBolsa;
    }
    public EstudanteBolsista(int cod, String nom, String dat, String ema, String sen, Cidade cid){
        super(cod, nom, dat, ema, sen, cid);
    }
    
    public String getTipoDeBolsa(){
        return tipoDeBolsa;
    }
    
    public void setTipodeBolsa(String tipoDeBolsa){
        this.tipoDeBolsa = tipoDeBolsa;
    }
    
    public void exibeDados(){
        super.exibeDados();
        System.out.println("Tipo de Bolsa: "+tipoDeBolsa);
    }
}