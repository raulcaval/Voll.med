package med.voll.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler( EntityNotFoundException.class ) //notfound
    public ResponseEntity tratarErro404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler( MethodArgumentNotValidException.class ) // campo inválido, badRequest
    public ResponseEntity tratarErro400( MethodArgumentNotValidException ex) {
        var erros = ex.getFieldErrors(); //recebe lista de erros
        return ResponseEntity.badRequest().body(erros.stream().map(DadosErrosValidacao::new).toString());
    }


    private record DadosErrosValidacao(
            String campo,
            String mensagem ) {
        public DadosErrosValidacao(FieldError erro) {
            this(
                    erro.getField(),
                    erro.getDefaultMessage()
            );
        }

    }

}

