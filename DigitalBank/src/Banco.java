import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Banco {
    public String nome;
    private List<Conta> contas;
}
