

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.testes.entities.Aluno;
import com.testes.interfaces.IAlunoRepository;
import com.testes.services.AlunoService;

public class AlunoServiceTests {

    @Mock
    private IAlunoRepository alunoRepository;

    @InjectMocks
    private AlunoService alunoService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCadastrarAlunoComSucesso() {
        String nome = "João";
        String matricula = "12345";

        // Configurando o mock para retornar null (sem aluno cadastrado)
        when(alunoRepository.buscarPorMatricula(matricula)).thenReturn(null);

        String resultado = alunoService.cadastrarAluno(nome, matricula);

        assertEquals("Aluno cadastrado com sucesso", resultado);
        verify(alunoRepository).salvar(any(Aluno.class));
    }

    @Test
    public void testCadastrarAlunoJaExistente() {
        String nome = "Maria";
        String matricula = "54321";

        // Configurando o mock para retornar um aluno existente
        when(alunoRepository.buscarPorMatricula(matricula)).thenReturn(new Aluno(nome, matricula));

        String resultado = alunoService.cadastrarAluno(nome, matricula);

        assertEquals("Aluno já cadastrado", resultado);
        verify(alunoRepository, never()).salvar(any(Aluno.class));
    }
}
