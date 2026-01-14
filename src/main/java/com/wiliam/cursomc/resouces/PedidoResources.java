package com.wiliam.cursomc.resouces;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wiliam.cursomc.domain.Pedido;
import com.wiliam.cursomc.service.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResources {

    @Autowired
    private PedidoService service ;

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id){
        //Quando for for Lançada uma exception por não encontar o id , ela sera capturada por um handler
        Pedido obj = service.buscar(id); 
        return ResponseEntity.ok().body(obj);
    }

}
