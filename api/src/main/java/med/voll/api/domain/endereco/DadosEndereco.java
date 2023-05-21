package med.voll.api.domain.endereco;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotNull
        String logradouro,
        String numero,
        String complemento,
        @NotNull
        String bairro,
        @NotNull
        String cidade,
        @NotNull
        String uf,
        @NotNull
        @Pattern(regexp = "\\d{8}")
        String cep ) {
}
