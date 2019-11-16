
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Henrique Becker
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (menuPrincipal(sc)) {
        }
        sc.close();
        AcessaBanco.getAcesso().salvarCondominios(null);
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
        System.out.print(
"            reICareI                           reICareIC\n" +
"         ICareICareICar                     ICareICareICare\n" +
"       reICareICareICareI                 reICareICareICareIC\n" +
"     CareICareICareICareICa             reICareICareICareICareI\n" +
"    ICarICareICareICareICareI          ICareICareICareICareICareI\n" +
"  ICarICareICareICareICareICare      CareICareICareICareICareICare\n" +
" ICareICareICareICareICareICareI    CareICareICareICareICareICareICa\n" +
"ICaICareICareICareICareICareICareI ICareICareICareICareICareICareICar\n" +
"eICareICareICareICareICareICareICareICareICareICareICareICareICareICar\n" +
" ICareICareICareICareICareICareICareICareICareICareICareICareICareICar\n" +
"  ICareICareICareICareICareICareICareICareICareICareICareICareICareIc\n" +
"   eICareICareICareICareICareICareICareICareICareICareICareICareICa\n" +
"    ICareICareICareICareICareICareICareICareICareICareICareICareI\n" +
"      reICareICareICareICareICareICareICareICareICareICareICare\n" +
"        ICareICareICareICareICareICareICareICareICareICareICa\n" +
"          reICareICareICareICareICareICareICareICareICareIc\n" +
"            ICareICareICareICareICareICareICareICareICare\n" +
"              reICareICareICareIICareICareICareICareIca\n" +
"                ICareICareICareICareICareICareICarICa\n" +
"                   reICareICareICareICareICarICare\n" +
"                      areICareICareICareICareICa\n" +
"                         ICareICareICareICare\n" +
"                           areICareICareICa\n" +
"                             eICareICareI\n" +
"                               CareICar\n" +
"                                 reIC\n" +
"                                  eI");
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
        System.out.print(
                  "        .\n"
                + "       ,O,\n"
                + "      ,OOO,\n"
                + "'oooooOOOOOooooo'\n"
                + "  `OOOOOOOOOOO`\n"
                + "    `OOOOOOO`\n"
                + "    OOOO'OOOO\n"
                + "   OOO'   'OOO\n"
                + "  O'         'O");
        System.out.println();
        System.out.println();
        System.out.println();

    }

    private static boolean menuPrincipal(Scanner sc) {
        sc.reset();
        System.out.println("\nSelecione uma opção:");
        System.out.println("1 - Listar Condomínios");
        System.out.println("2 - Cadastrar novo Condomínio");
        System.out.println("3 - Gerenciar Condomínios");
        System.out.println("4 - Sair");
        try {
            int op = Integer.parseInt(sc.nextLine());
            if (op == 4) {
                return false;
            } else if (op == 1) {
                listarCondominos();
                System.out.println("Pressione ENTER para continuar");
                sc.nextLine();
            } else if (op == 2) {
                cadastroCondominio(sc);
            } else if (op == 3) {
                gerenciarCondominios(sc);
            } else {
                showOpInvalida();
            }
            return true;
        } catch (Exception e) {
            return true;
        }
    }

    private static void showOpInvalida() {
        System.out.println("Opção inválida!!\n");
    }

    private static int showCrud(Scanner sc) {
        int op = 0;
        while (op < 1 || op > 4) {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Ver detalhes");
            System.out.println("2 - Editar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Voltar ao menu principal");
            try {
                op = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                op = 0;
            }
        }
        return op;
    }

    private static void cadastroCondominio(Scanner sc) {
        try {
            sc.reset();
            System.out.println("Informe o nome do condomínio:");
            String nome = sc.nextLine();
            System.out.println("Informe a cidade:");
            String cidade = sc.nextLine();
            System.out.println("Informe o bairro:");
            String bairro = sc.nextLine();
            System.out.println("Informe o número:");
            int numero = Integer.parseInt(sc.nextLine());
            Condominio condominio = new Condominio(nome, cidade, bairro, numero, new ArrayList<Edificio>());
            AcessaBanco bd = AcessaBanco.getAcesso();
            bd.addCondominio(condominio);
            System.out.println("Condomínio criado");
            String op = null;
            while (op == null || (op.length() > 0 && (op.charAt(0) == 'S' || op.charAt(0) == 's'))) {
                System.out.println();
                System.out.println("Adicionar edifício ao condomínio?");
                System.out.println("S - Sim");
                System.out.println("N - Não");
                op = sc.nextLine();
                if (op.charAt(0) == 'S' || op.charAt(0) == 's') {
                    cadastroEdificio(sc, bd.getCondominios().size() - 1);
                }
            }
        } catch (Exception e) {
            System.out.println("Falha ao salvar condomínio;");
        }
    }

    private static void listarCondominos() {
        if (AcessaBanco.getAcesso().getCondominios().isEmpty()) {
            System.out.println("Nenhum condomínio salvo!");
            return;
        }
        AcessaBanco.getAcesso().getCondominios().forEach(c -> {
            System.out.println("Condomínio " + c.getNome());
            System.out.println("Localizado em: " + c.getCidade() + " - " + c.getBairro() + ", " + c.getNumero());
        });
    }

    private static void cadastroEdificio(Scanner sc, int indexCondominio) {
        try {
            sc.reset();
            System.out.println("Informe o número do Edifício:");
            int numero = Integer.parseInt(sc.nextLine());
            System.out.println("Informe a cor:");
            String cor = sc.nextLine();
            System.out.println("Informe a quantidade de andares:");
            int qAndares = Integer.parseInt(sc.nextLine());
            AcessaBanco bd = AcessaBanco.getAcesso();
            bd.getCondominios()
                    .get(indexCondominio)
                    .getEdificios()
                    .add(new Edificio(numero, cor, qAndares, new ArrayList<Apartamento>()));
            System.out.println("Edifício criado");
            String op = null;
            while (op == null || (op.length() > 0 && (op.charAt(0) == 'S' || op.charAt(0) == 's'))) {
                System.out.println();
                System.out.println("Adicionar novo apartamento ao edifício?");
                System.out.println("S - Sim");
                System.out.println("N - Não");
                op = sc.nextLine();
                if (op.charAt(0) == 'S' || op.charAt(0) == 's') {
                    cadastroApartamento(sc, indexCondominio, bd.getCondominios()
                            .get(indexCondominio)
                            .getEdificios().size() - 1);
                }
            }
        } catch (Exception e) {
            System.out.println("Falha ao salvar edifício;");
        }
    }

    private static void cadastroApartamento(Scanner sc, int indexCondominio, int indexEdificio) {
        try {
            sc.reset();
            System.out.println("Tipo:");
            System.out.println("L - Luxo");
            System.out.println("P - Padrão");
            String op = sc.nextLine();
            if (op.charAt(0) == 'L' || op.charAt(0) == 'l') {
                cadastroApartamentoLuxo(sc, indexCondominio, indexEdificio);
            } else if (op.charAt(0) == 'P' || op.charAt(0) == 'p') {
                cadastroApartamentoPadrao(sc, indexCondominio, indexEdificio);
            }
        } catch (Exception e) {
            System.out.println("Falha ao salvar apartamento;");
        }
    }

    private static void cadastroApartamentoLuxo(Scanner sc, int indexCondominio, int indexEdificio) {
        try {
            sc.reset();
            String l = "";
            System.out.println("Informe o número do Apartamento:");
            int numero = Integer.parseInt(sc.nextLine());
            System.out.println("Informe o andar:");
            int andar = Integer.parseInt(sc.nextLine());
            System.out.println("Informe a renda média dos moradores:");
            double rendaMedia = Double.parseDouble(sc.nextLine());
            System.out.println("Informe o tipo de luminária:");
            String tipoLuminaria = sc.nextLine();
            System.out.println("Possui geladeira embutida? (S - Sim | N - Não)");
            l = sc.nextLine();
            boolean geladeiraEmbutida = !l.isEmpty() && (l.charAt(0) == 'S' || l.charAt(0) == 's');
            System.out.println("Possui fogão embutido? (S - Sim | N - Não)");
            l = sc.nextLine();
            boolean fogaoEmbutido = !l.isEmpty() && (l.charAt(0) == 'S' || l.charAt(0) == 's');
            ConstructorApartamentoLuxo cA = new ConstructorApartamentoLuxo();
            AcessaBanco bd = AcessaBanco.getAcesso();
            bd.getCondominios()
                    .get(indexCondominio)
                    .getEdificios()
                    .get(indexEdificio)
                    .getApartamentos()
                    .add(cA.construirApartamento(tipoLuminaria, geladeiraEmbutida, fogaoEmbutido, numero, andar, rendaMedia, new ArrayList<Morador>()));

            System.out.println("Apartamento criado");
            String op = null;
            while (op == null || (op.length() > 0 && (op.charAt(0) == 'S' || op.charAt(0) == 's'))) {
                System.out.println();
                System.out.println("Adicionar novo morador ao apartamento?");
                System.out.println("S - Sim");
                System.out.println("N - Não");
                op = sc.nextLine();
                if (op.charAt(0) == 'S' || op.charAt(0) == 's') {
                    cadastroMorador(sc, indexCondominio, indexEdificio,
                            bd.getCondominios()
                                    .get(indexCondominio)
                                    .getEdificios()
                                    .get(indexEdificio)
                                    .getApartamentos().size() - 1);
                }
            }
        } catch (Exception e) {
            System.out.println("Falha ao salvar apartamento;");
        }
    }

    private static void cadastroApartamentoPadrao(Scanner sc, int indexCondominio, int indexEdificio) {
        try {
            sc.reset();
            String l = "";
            System.out.println("Informe o número do Apartamento:");
            int numero = Integer.parseInt(sc.nextLine());
            System.out.println("Informe o andar:");
            int andar = Integer.parseInt(sc.nextLine());
            System.out.println("Informe o tipo de armário:");
            String tipoArmario = sc.nextLine();
            System.out.println("Informe o tipo de piso:");
            String tipoPiso = sc.nextLine();
            ConstrutorApartamentoPadrao cA = new ConstrutorApartamentoPadrao();
            AcessaBanco bd = AcessaBanco.getAcesso();
            bd.getCondominios()
                    .get(indexCondominio)
                    .getEdificios()
                    .get(indexEdificio)
                    .getApartamentos()
                    .add(cA.construitApartamento(tipoArmario, tipoPiso, numero, andar, andar, new ArrayList<Morador>()));
            System.out.println("Apartamento criado");
            String op = null;
            while (op == null || (op.length() > 0 && (op.charAt(0) == 'S' || op.charAt(0) == 's'))) {
                System.out.println();
                System.out.println("Adicionar novo morador ao apartamento?");
                System.out.println("S - Sim");
                System.out.println("N - Não");
                op = sc.nextLine();
                if (op.charAt(0) == 'S' || op.charAt(0) == 's') {
                    cadastroMorador(sc, indexCondominio, indexEdificio,
                            bd.getCondominios()
                                    .get(indexCondominio)
                                    .getEdificios()
                                    .get(indexEdificio)
                                    .getApartamentos().size() - 1);
                }
            }
        } catch (Exception e) {
            System.out.println("Falha ao salvar apartamento;");
        }
    }

    private static void cadastroMorador(Scanner sc, int indexCondominio, int indexEdificio, int indexApartamento) {
        try {
            sc.reset();
            System.out.println("Informe o nome do morador:");
            String nome = sc.nextLine();
            System.out.println("Informe o cpf do morador:");
            String cpf = sc.nextLine();
            System.out.println("Informe o rg do morador:");
            String rg = sc.nextLine();
            System.out.println("Informe o sexo do morador: (M - Masculino, F - Feminino)");
            char sexo = sc.nextLine().charAt(0);
            System.out.println("Informe a idade do morador:");
            int idade = Integer.parseInt(sc.nextLine());
            AcessaBanco bd = AcessaBanco.getAcesso();
            bd.getCondominios()
                    .get(indexCondominio)
                    .getEdificios()
                    .get(indexEdificio)
                    .getApartamentos()
                    .get(indexApartamento)
                    .getMoradores()
                    .add(new Morador(nome, cpf, rg, sexo, idade));
            System.out.println("Morador criado");
        } catch (Exception e) {
            System.out.println("Falha ao salvar morador;");
        }
    }

    private static void gerenciarCondominios(Scanner sc) {
        if (AcessaBanco.getAcesso().getCondominios().isEmpty()) {
            System.out.println("Nenhum condomínio registrado!");
            return;
        }
        int i = 1;
        for (Condominio c : AcessaBanco.getAcesso().getCondominios()) {
            System.out.println(i + ": Condomínio " + c.getNome());
            i++;
        }
        System.out.println("Selecione algum condomínio: (informe seu número identificador)");
        try {
            int indexCondominio = Integer.parseInt(sc.nextLine()) - 1;
            switch (showCrud(sc)) {
                case 1:
                    exibirDetalhesCondominio(indexCondominio);
                    System.out.println("Pressione ENTER para continuar");
                    sc.nextLine();
                    break;
                case 2:
                    cadastroCondominio(sc, indexCondominio);
                    break;
                case 3:
                    AcessaBanco.getAcesso().getCondominios().remove(indexCondominio);
            }
        } catch (Exception e) {
            showOpInvalida();
        }
    }

    private static void exibirDetalhesCondominio(int indexCondominio) {
        try {
            Condominio c = AcessaBanco.getAcesso()
                    .getCondominios()
                    .get(indexCondominio);
            System.out.println("Condomínio " + c.getNome());
            System.out.println("Localizado em: " + c.getCidade() + " - " + c.getBairro() + ", " + c.getNumero());
            System.out.println("Possui " + c.getEdificios().size() + " edifícios");
            c.getEdificios().forEach(e -> {
                System.out.println();
                System.out.println("Edifício de Número " + e.getNumeroEdificio());
                System.out.println("Cor " + e.getCor() + ", " + e.getQuantidadeAndares() + " andares, " + e.getApartamentos().size() + " apartamentos.");
                if (!e.getApartamentos().isEmpty()) {
                    System.out.println("Apartamentos:");
                    e.getApartamentos().forEach(a -> {
                        if (a instanceof ApartamentoLuxo) {
                            System.out.println("\tNúmero: " + a.getNumeroApto()
                                    + ", Andar: " + a.getAndar()
                                    + ", Renda Média: " + String.format("%.2f", a.getRendaMedia())
                                    + ", Tipo de Luminária: " + ((ApartamentoLuxo) a).getTipoLuminaria()
                                    + ", Possui geladeira embutida: " + (((ApartamentoLuxo) a).isGeladeiraEmbutida() ? "Sim" : "Não")
                                    + ", Possui fogão embutido: " + (((ApartamentoLuxo) a).isFogaoEmbutido() ? "Sim" : "Não"));
                        } else if (a instanceof ApartamentoPadrao) {
                            System.out.println("\t Número: " + a.getNumeroApto()
                                    + ", Andar: " + a.getAndar()
                                    + ", Renda Média: " + String.format("%.2f", a.getRendaMedia())
                                    + ", Tipo de Armário: " + ((ApartamentoPadrao) a).getTipoArmario()
                                    + ", Tipo de Piso: " + ((ApartamentoPadrao) a).getTipoPiso());
                        }
                        if (!a.getMoradores().isEmpty()) {
                            System.out.println("\tMoradores:");
                            a.getMoradores().forEach(m -> {
                                System.out.println("\t\tNome: " + m.getNome()
                                        + ", CPF: " + m.getCpf()
                                        + ", RG: " + m.getRg()
                                        + ", Idade: " + m.getIdade()
                                        + ", Sexo: " + m.getSexo());
                            });
                        }
                    });
                }
            });
        } catch (Exception e) {
            System.out.println("Condomínio não localizado!");
        }
    }

    private static void cadastroCondominio(Scanner sc, int indexCondominio) {
        try {
            sc.reset();
            System.out.println("1 - Editar Dados do condomínio");
            System.out.println("2 - Editar edifícios");
            System.out.println("3 - Adicionar edifício");
            System.out.println("4 - Remover edifício");
            System.out.println("5 - Voltar ao menu principal");
            int op = Integer.parseInt(sc.nextLine());
            if (op == 1) {
                System.out.println("Informe o nome do condomínio:");
                String nome = sc.nextLine();
                System.out.println("Informe a cidade:");
                String cidade = sc.nextLine();
                System.out.println("Informe o bairro:");
                String bairro = sc.nextLine();
                System.out.println("Informe o número:");
                int numero = Integer.parseInt(sc.nextLine());
                AcessaBanco bd = AcessaBanco.getAcesso();
                Condominio c = bd.getCondominios().get(indexCondominio);
                c.setNome(nome);
                c.setCidade(cidade);
                c.setBairro(bairro);
                c.setNumero(numero);
                System.out.println("Condomínio atualizado com sucesso");
            } else if (op == 2 || op == 4) {
                AcessaBanco bd = AcessaBanco.getAcesso();
                Condominio c = bd.getCondominios().get(indexCondominio);
                if (c.getEdificios().isEmpty()) {
                    System.out.println("Nenhum edifício localizado!");
                    return;
                }
                int indexEdificio = 1;
                for (Edificio e : c.getEdificios()) {
                    System.out.println(indexEdificio + " - Edifício de Número " + e.getNumeroEdificio());
                    indexEdificio++;
                }
                System.out.println("Selecione o edifício: (Informe o identificador)");
                indexEdificio = Integer.parseInt(sc.nextLine()) - 1;
                if (op == 2) {
                    cadastroEdificio(sc, indexCondominio, indexEdificio);
                } else {
                    c.getEdificios().remove(indexEdificio);
                }
            } else if (op == 3) {
                cadastroEdificio(sc, indexCondominio);
            }
        } catch (Exception e) {
            showOpInvalida();
        }
    }

    private static void cadastroEdificio(Scanner sc, int indexCondominio, int indexEdificio) {
        try {
            sc.reset();
            System.out.println("1 - Editar Dados do edifício");
            System.out.println("2 - Editar apartamentos");
            System.out.println("3 - Adicionar apartamento");
            System.out.println("4 - Remover apartamento");
            System.out.println("5 - Voltar ao menu principal");
            int op = Integer.parseInt(sc.nextLine());
            if (op == 1) {
                System.out.println("Informe o número do Edifício:");
                int numero = Integer.parseInt(sc.nextLine());
                System.out.println("Informe a cor:");
                String cor = sc.nextLine();
                System.out.println("Informe a quantidade de andares:");
                int qAndares = Integer.parseInt(sc.nextLine());
                AcessaBanco bd = AcessaBanco.getAcesso();
                Edificio e = bd.getCondominios().get(indexCondominio).getEdificios().get(indexEdificio);
                e.setCor(cor);
                e.setNumeroEdificio(indexEdificio);
                e.setQuantidadeAndares(qAndares);
                System.out.println("Edifício atualizado com sucesso");
            } else if (op == 2 || op == 4) {
                AcessaBanco bd = AcessaBanco.getAcesso();
                Edificio e = bd.getCondominios().get(indexCondominio).getEdificios().get(indexEdificio);
                if (e.getApartamentos().isEmpty()) {
                    System.out.println("Nenhum apartamento localizado!");
                    return;
                }
                int indexApartamento = 1;
                for (Apartamento a : e.getApartamentos()) {
                    System.out.println(indexApartamento + " - Apartamento de Número " + a.getNumeroApto());
                    indexApartamento++;
                }
                System.out.println("Selecione o aparamento: (Informe o identificador)");
                indexApartamento = Integer.parseInt(sc.nextLine()) - 1;
                if (op == 2) {
                    cadastroApartamento(sc, indexCondominio, indexEdificio, indexApartamento);
                } else {
                    e.getApartamentos().remove(indexApartamento);
                }
            } else if (op == 3) {
                cadastroApartamento(sc, indexCondominio, indexEdificio);
            }
        } catch (Exception e) {
            showOpInvalida();
        }
    }

    private static void cadastroApartamento(Scanner sc, int indexCondominio, int indexEdificio, int indexApartamento) {
        try {
            sc.reset();
            System.out.println("1 - Editar Dados do apartamento");
            System.out.println("2 - Editar morador");
            System.out.println("3 - Adicionar morador");
            System.out.println("4 - Remover morador");
            System.out.println("5 - Voltar ao menu principal");
            int op = Integer.parseInt(sc.nextLine());
            if (op == 1) {
                System.out.println("Tipo:");
                System.out.println("L - Luxo");
                System.out.println("P - Padrão");
                String o = sc.nextLine();
                if (o.charAt(0) == 'L' || o.charAt(0) == 'l') {
                    String l = "";
                    System.out.println("Informe o número do Apartamento:");
                    int numero = Integer.parseInt(sc.nextLine());
                    System.out.println("Informe o andar:");
                    int andar = Integer.parseInt(sc.nextLine());
                    System.out.println("Informe a renda média dos moradores:");
                    double rendaMedia = Double.parseDouble(sc.nextLine());
                    System.out.println("Informe o tipo de luminária:");
                    String tipoLuminaria = sc.nextLine();
                    System.out.println("Possui geladeira embutida? (S - Sim | N - Não)");
                    l = sc.nextLine();
                    boolean geladeiraEmbutida = !l.isEmpty() && (l.charAt(0) == 'S' || l.charAt(0) == 's');
                    System.out.println("Possui fogão embutido? (S - Sim | N - Não)");
                    l = sc.nextLine();
                    boolean fogaoEmbutido = !l.isEmpty() && (l.charAt(0) == 'S' || l.charAt(0) == 's');
                    ConstructorApartamentoLuxo cA = new ConstructorApartamentoLuxo();
                    AcessaBanco bd = AcessaBanco.getAcesso();
                    bd.getCondominios()
                            .get(indexCondominio)
                            .getEdificios()
                            .get(indexEdificio)
                            .getApartamentos()
                            .add(cA.construirApartamento(tipoLuminaria, geladeiraEmbutida, fogaoEmbutido, numero, andar, rendaMedia,
                                    bd.getCondominios()
                                            .get(indexCondominio)
                                            .getEdificios()
                                            .get(indexEdificio)
                                            .getApartamentos()
                                            .get(indexApartamento).getMoradores()));
                } else if (o.charAt(0) == 'P' || o.charAt(0) == 'p') {
                    String l = "";
                    System.out.println("Informe o número do Apartamento:");
                    int numero = Integer.parseInt(sc.nextLine());
                    System.out.println("Informe o andar:");
                    int andar = Integer.parseInt(sc.nextLine());
                    System.out.println("Informe o tipo de armário:");
                    String tipoArmario = sc.nextLine();
                    System.out.println("Informe o tipo de piso:");
                    String tipoPiso = sc.nextLine();
                    ConstrutorApartamentoPadrao cA = new ConstrutorApartamentoPadrao();
                    AcessaBanco bd = AcessaBanco.getAcesso();
                    bd.getCondominios()
                            .get(indexCondominio)
                            .getEdificios()
                            .get(indexEdificio)
                            .getApartamentos()
                            .add(cA.construitApartamento(tipoArmario, tipoPiso, numero, andar, andar,
                                    bd.getCondominios()
                                            .get(indexCondominio)
                                            .getEdificios()
                                            .get(indexEdificio)
                                            .getApartamentos()
                                            .get(indexApartamento).getMoradores()));
                }
                AcessaBanco.getAcesso().getCondominios()
                        .get(indexCondominio)
                        .getEdificios()
                        .get(indexEdificio)
                        .getApartamentos()
                        .remove(indexApartamento);
                System.out.println("Apartamento atualizado com sucesso");
            } else if (op == 2 || op == 4) {
                AcessaBanco bd = AcessaBanco.getAcesso();
                Apartamento a = bd.getCondominios().get(indexCondominio).getEdificios().get(indexEdificio).getApartamentos().get(indexApartamento);
                int indexMorador = 1;
                if (a.getMoradores().isEmpty()) {
                    System.out.println("Nenhum morador localizado!");
                    return;
                }
                for (Morador m : a.getMoradores()) {
                    System.out.println(indexMorador + " - Morador de nome " + m.getNome());
                    indexMorador++;
                }
                System.out.println("Selecione o morador: (Informe o identificador)");
                indexMorador = Integer.parseInt(sc.nextLine()) - 1;
                if (op == 2) {
                    System.out.println("Informe o nome do morador:");
                    String nome = sc.nextLine();
                    System.out.println("Informe o cpf do morador:");
                    String cpf = sc.nextLine();
                    System.out.println("Informe o rg do morador:");
                    String rg = sc.nextLine();
                    System.out.println("Informe o sexo do morador: (M - Masculino, F - Feminino)");
                    char sexo = sc.nextLine().charAt(0);
                    System.out.println("Informe a idade do morador:");
                    int idade = Integer.parseInt(sc.nextLine());
                    Morador m = a.getMoradores().get(indexMorador);
                    m.setNome(nome);
                    m.setCpf(cpf);
                    m.setRg(rg);
                    m.setSexo(sexo);
                    m.setIdade(idade);
                    System.out.println("Morador atualizado com sucesso!");
                } else {
                    a.getMoradores().remove(indexMorador);
                }
            } else if (op == 3) {
                cadastroMorador(sc, indexCondominio, indexEdificio, indexApartamento);
            }
        } catch (Exception e) {
            showOpInvalida();
        }
    }

}
