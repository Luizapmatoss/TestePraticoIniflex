import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;
import java.text.NumberFormat;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        System.out.println("              ᔓ Iniciando aplicação de gestão de funcionários... ᔓ\n");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("⇢ O sistema foi interrompido. ❌");
            Thread.currentThread().interrupt();
        }
        FuncionarioService service = new FuncionarioService();

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        funcionarios.removeIf(f -> f.getNome().equals("João"));

        System.out.println("ᔓ FUNCIONÁRIOS ᔓ");
        funcionarios.forEach(System.out::println);

        System.out.println("\nᔓ AUMENTO DE 10% NOS SÁLARIOS ᔓ");
        for (Funcionario f : funcionarios) {
            BigDecimal novoSalario = f.getSalario().multiply(new BigDecimal("1.10"));
            f.setSalario(novoSalario);
        }

        funcionarios.forEach(System.out::println);

        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        System.out.println("\nᔓ FUNCIONÁRIOS AGRUPADOS POR FUNÇÃO ᔓ");
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("⇢ Função: " + funcao);
            lista.forEach(f -> System.out.println("  ↳ " + f.getNome()));
        });

        System.out.println("\nᔓ ANIVERSIARIANTES DE OUTUBRO (10) E DEZEMBRO (12) ᔓ");
        funcionarios.stream()
                .filter(f -> f.getDataNascimento().getMonthValue() == 10 || f.getDataNascimento().getMonthValue() == 12)
                .forEach(System.out::println);

        System.out.println("\nᔓ FUNCIONÁRIOS COM MAIOR IDADE ᔓ");
        Optional<Funcionario> funcionarioMaisVelho = funcionarios.stream()
                .min(Comparator.comparing(Pessoa::getDataNascimento));

        funcionarioMaisVelho.ifPresent(f -> {
            int idade = Period.between(f.getDataNascimento(), LocalDate.now()).getYears();
            System.out.println("⇢ Nome: " + f.getNome() + ", Idade: " + idade + " anos");
        });

        System.out.println("\nᔓ LISTA DE FUNCIONÁRIOS EM ORDEM ALFABETICA ᔓ");
        funcionarios.stream()
                .sorted(Comparator.comparing(Pessoa::getNome))
                .forEach(System.out::println);

        System.out.println("\nᔓ TOTAL DE SALÁRIOS ᔓ");
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        System.out.println("⇢ Total dos salários: " + currencyFormatter.format(totalSalarios));

        System.out.println("\nᔓ SALÁRIOS MÍNIMOS POR FUNCIONÁRIO ᔓ");
        final BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");
        funcionarios.forEach(f -> {
            BigDecimal salariosMinimos = f.getSalario().divide(SALARIO_MINIMO, 2, RoundingMode.HALF_UP);
            System.out.println("⇢ Nome: " + f.getNome() + ", Salários Mínimos: " + salariosMinimos);
        });
    }
}