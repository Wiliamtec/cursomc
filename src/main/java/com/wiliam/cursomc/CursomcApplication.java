package com.wiliam.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wiliam.cursomc.domain.Categoria;
import com.wiliam.cursomc.domain.Cidade;
import com.wiliam.cursomc.domain.Estado;
import com.wiliam.cursomc.domain.Produto;
import com.wiliam.cursomc.repositories.CategoriaRepository;
import com.wiliam.cursomc.repositories.CidadeRepository;
import com.wiliam.cursomc.repositories.EstadoRepository;
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
	}

}
