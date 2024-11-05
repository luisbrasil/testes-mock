import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.testes.entities.Aluno;
import com.testes.interfaces.IAlunoRepository;
import com.testes.services.AlunoService;

public class AlunoServiceIntegrationTest {
    
    @Mock
    private IAlunoRepository alunoRepository;

    @InjectMocks
    private AlunoService alunoService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListarAlunosComSucesso() {
        // Preparando dados simulados para retorno do mock
        Aluno aluno1 = new Aluno("Carlos", "11111");
        Aluno aluno2 = new Aluno("Ana", "22222");
        List<Aluno> alunosMockados = Arrays.asList(aluno1, aluno2);

        // Configurando o mock para retornar a lista de alunos
        when(alunoRepository.listarTodos()).thenReturn(alunosMockados);

        // Chamando o método que queremos testar
        List<Aluno> resultado = alunoService.listarAlunos();

        // Verificando se o método listarTodos do repositório foi chamado
        verify(alunoRepository, times(1)).listarTodos();

        // Verificando se o retorno foi o esperado
        assertEquals(2, resultado.size());
        assertEquals("Carlos", resultado.get(0).getNome());
        assertEquals("Ana", resultado.get(1).getNome());
    }
}
