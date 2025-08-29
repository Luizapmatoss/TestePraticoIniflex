import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FuncionarioService {

    public void removerFuncionario(List<Funcionario> funcionarios, String nome) {
        funcionarios.removeIf(f -> f.getNome().equals(nome));
    }

    public void darAumento(List<Funcionario> funcionarios, BigDecimal percentual) {
        for (Funcionario f : funcionarios) {
            BigDecimal fatorAumento = BigDecimal.ONE.add(percentual);
            f.setSalario(f.getSalario().multiply(fatorAumento));
        }
    }

    public Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    public List<Funcionario> filtrarAniversariantes(List<Funcionario> funcionarios, int... meses) {
        return funcionarios.stream()
                .filter(f -> {
                    for (int mes : meses) {
                        if (f.getDataNascimento().getMonthValue() == mes) {
                            return true;
                        }
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }

    public Optional<Funcionario> encontrarMaisVelho(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .min(Comparator.comparing(Pessoa::getDataNascimento));
    }

    public List<Funcionario> ordenarPorNome(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .sorted(Comparator.comparing(Pessoa::getNome))
                .collect(Collectors.toList());
    }

    public BigDecimal calcularTotalSalarios(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void imprimirSalariosMinimos(List<Funcionario> funcionarios, BigDecimal salarioMinimo) {
        funcionarios.forEach(f -> {
            BigDecimal salariosMinimos = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.println("Nome: " + f.getNome() + ", Salários Mínimos: " + salariosMinimos);
        });
    }

    public void imprimirFuncionarios(List<Funcionario> funcionarios) {
        funcionarios.forEach(System.out::println);
    }
}