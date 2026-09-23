import com.serasa.crm.model.Cliente;
import com.serasa.crm.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteViewController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/listar")
    public String listarClientes(Model model) {
        List<Cliente> clientes = clienteRepository.findAll();
        model.addAttribute("clientes", clientes);
        return "index"; // templates/clientes.html
    }
}
