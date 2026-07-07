public class Aluno extends Pessoa {
    
    private double media;

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public String getStatus(){
        return media >= 7 ? "Aprovado" : "Reprovado";
    }

    public void display(){
        super.display();
        System.out.println("Media: " + media);
        System.out.println("Situação: " + (getStatus()));
    }
}
