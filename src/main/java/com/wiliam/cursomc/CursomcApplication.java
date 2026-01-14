package com.wiliam.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wiliam.cursomc.domain.Categoria;
import com.wiliam.cursomc.domain.Cidade;
import com.wiliam.cursomc.domain.Cliente;
import com.wiliam.cursomc.domain.Endereco;
import com.wiliam.cursomc.domain.Estado;
import com.wiliam.cursomc.domain.ItemPedido;
import com.wiliam.cursomc.domain.Pagamento;
import com.wiliam.cursomc.domain.PagamentoComBoleto;
import com.wiliam.cursomc.domain.PagamentoComCartao;
import com.wiliam.cursomc.domain.Pedido;
import com.wiliam.cursomc.domain.Produto;
import com.wiliam.cursomc.domain.enums.EstadoPagamento;
import com.wiliam.cursomc.domain.enums.TipoCliente;
import com.wiliam.cursomc.repositories.CategoriaRepository;
import com.wiliam.cursomc.repositories.CidadeRepository;
import com.wiliam.cursomc.repositories.ClienteRepository;
import com.wiliam.cursomc.repositories.EnderecoRepository;
import com.wiliam.cursomc.repositories.EstadoRepository;
import com.wiliam.cursomc.repositories.ItemPedidoRepository;
import com.wiliam.cursomc.repositories.PagamentoRepository;
import com.wiliam.cursomc.repositories.PedidoRepository;
import com.wiliam.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository repoCa;

	@Autowired
	private ProdutoRepository repoProd;
    
	@Autowired
	private CidadeRepository repoCid;

	@Autowired
	private EstadoRepository repoEst;

    @Autowired
	private ClienteRepository repoCli;

	@Autowired
	private EnderecoRepository repoEnd;

	 @Autowired
	private PagamentoRepository repoPag;

	@Autowired
	private PedidoRepository repoPed;

	@Autowired
	private ItemPedidoRepository repoitemPed;


	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria c1 = new Categoria(null,"Informatica");
		Categoria c2 = new Categoria(null,"Ecritorio");
         
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);

		c1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		c2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(c1));
		p2.getCategorias().addAll(Arrays.asList(c1,c2));
		p3.getCategorias().addAll(Arrays.asList(c1));

		repoCa.saveAll(Arrays.asList(c1,c2));
		repoProd.saveAll(Arrays.asList(p1,p2,p3));


		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");

		Cidade cd1 = new Cidade(null,"Uberlandia",est1);
		Cidade cd2 = new Cidade(null,"São Paulo",est2);
		Cidade cd3 = new Cidade(null,"Campinas",est2);

		est1.getCidades().addAll(Arrays.asList(cd1));
		est2.getCidades().addAll(Arrays.asList(cd2,cd3));

		repoEst.saveAll(Arrays.asList(est1,est2));
		repoCid.saveAll(Arrays.asList(cd1,cd2,cd3));

		Cliente cli1 = new Cliente(null,"Maria Silva","maria@gmail.com","32179598840",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("985107806","978171909"));

		Endereco e1 = new Endereco(null,"Rua Flores ","300","apto 303","jardim ","03682120",cd1,cli1);
		Endereco e2 = new Endereco(null,"Avenida MAtos ","105","Sala 800","Centro ","88682120",cd2,cli1);

		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));

		repoCli.saveAll(Arrays.asList(cli1));
		repoEnd.saveAll(Arrays.asList(e1,e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Pedido ped1 = new Pedido(null,sdf.parse("13/01/2026 18:13"),cli1,e1);
		Pedido ped2 = new Pedido(null,sdf.parse("10/01/2026 15:13"),cli1,e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/01/2026 15:40"),null);
		ped2.setPagamento(pagto2);


		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));

		repoPed.saveAll(Arrays.asList(ped1,ped2));
		repoPag.saveAll(Arrays.asList(pagto1,pagto2));

		ItemPedido ip1 = new ItemPedido(ped1,p1,0.00,1,200.00);
		ItemPedido ip2 = new ItemPedido(ped1,p3,0.00,2,80.00);
		ItemPedido ip3 = new ItemPedido(ped2,p2,100.00,1,800.00);

		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		repoitemPed.saveAll(Arrays.asList(ip1,ip2,ip3));
		


	}

}
