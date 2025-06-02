package exercs.cap6;

import exercs.cap7.PessoaN;

public class TestePessoaMain {
    public static void main(String[] args) {
        Pessoa p = new Pessoa("Joana", 15, "asdsd");
        PessoaAfro pa = new PessoaAfro("Simone", 32, "Superior Completo", "Sim");
        PessoaIndigena pi = new PessoaIndigena("Maria", 25, "Mestrado");
        p.getIdade();
        pa.getEscolaridade();
        pi.getNome();

        System.out.println("Os dados aleatórios da pessoa são: " + p + " " + pa + " " + pi);

    }
}
