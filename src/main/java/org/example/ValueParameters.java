package org.example;

public class ValueParameters {

    public static void main(String[] args) {
        Pessoa pessoaInicial = new Pessoa("Murilo", 30);

        Pessoa segundaPessoa = pessoaInicial;

        pessoaInicial.nome = "Diego";

        System.out.println("nome da pessoa inicial: " + pessoaInicial.nome);

        System.out.println("nome da segunda pessoa: " + segundaPessoa.nome); // olha como o nome da segundaPessoa mudou junto com aquele change da pessoaInicial
        // pq você atribuiu uma variável de objeto pra outra.. ou seja.. as duas tem uma setinha apontando pra mesma caixinha

        // Agora usando primitivos

        String nomeDaPessoaInicial = pessoaInicial.nome; // aqui vai ser Diego pq vc mudou ali em cima, né?

        System.out.println(nomeDaPessoaInicial);

        pessoaInicial.nome = "Marco Antonio Joaquino das Flores"; //e agora ? ce mudou o nome da pessoa inicial, o nome da variavel "nomeDaPessoaInicial"devia mudar ?

        System.out.println(pessoaInicial.nome);
        System.out.println(
                nomeDaPessoaInicial); // olha como esse valor não foi alterado... pq foi uma passagem por valor PRIMITIVOSSSSS, ce passou só a String.. e não uma referencia(setinha) pro objeto

    }

    static class Pessoa {
        String nome;

        int idade;

        public Pessoa(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }
    }

}
