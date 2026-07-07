public class Main {
    public static void main(String[] args) {
        Aluno al1 = new Aluno();
        al1.setNome("Igor");
        al1.setEmail("igorfepazuch@gmail.com");
        al1.setMedia(10);

       /* System.out.println("Nome: " + al1.getNome());
        System.out.println("Email: " + al1.getEmail()); 
        System.out.println("Media: " + al1.getMedia()); */

        al1.display();
    }
}
