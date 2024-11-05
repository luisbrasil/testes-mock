import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.testes.entities.Aluno;
import com.testes.interfaces.IAlunoRepository;
import com.testes.repositories.AlunoRepositoryEmMemoria;
import com.testes.services.AlunoService;

public class AlunoServiceIntegrationTest {

    private IAlunoRepository alunoRepository;
    private AlunoService alunoService;

    @BeforeEach
    public void setup() {
        alunoRepository = new AlunoRepositoryEmMemoria(); // Repositório em memória
        alunoService = new AlunoService(alunoRepository);
    }

    @Test
    public void testCadastrarEListarAlunos() {
        alunoService.cadastrarAluno("Carlos", "11111");
        alunoService.cadastrarAluno("Ana", "22222");

        List<Aluno> resultado = alunoService.listarAlunos();

        assertEquals(2, resultado.size());
        assertEquals("Carlos", resultado.get(0).getNome());
        assertEquals("Ana", resultado.get(1).getNome());
    }

    @Test
    public void testNaoPermitirCadastroDeAlunoDuplicado() {
        alunoService.cadastrarAluno("João", "33333");
        String resultado = alunoService.cadastrarAluno("João", "33333");

        assertEquals("Aluno já cadastrado", resultado);
        assertEquals(1, alunoService.listarAlunos().size());
    }
}