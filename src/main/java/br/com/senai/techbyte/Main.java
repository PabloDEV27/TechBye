package br.com.senai.techbyte;

import br.com.senai.techbyte.service.ProdutoService;
import br.com.senai.techbyte.controller.ProdutoController;
import br.com.senai.techbyte.repository.ProdutoMemoryRepository;
import br.com.senai.techbyte.repository.ProdutoRepository;
import br.com.senai.techbyte.view.ProdutoConsoleView;

public class Main {
    static void main(){
        //1. Instancia o repositório concreto na memória
        ProdutoRepository repository = new ProdutoMemoryRepository();

        //2. Injeta o repositório na camada service (regras de negócio)
        ProdutoService service = new ProdutoService(repository);

        //3. Injeta o service no controller
        ProdutoController controller = new ProdutoController(service);

        //4. Injeta o controller na view
        ProdutoConsoleView view = new ProdutoConsoleView(controller);

        //5. Dispara Aplicação
        view.iniciar();
    }
}
