package tma.datraining.controller;

import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tma.datraining.converter.DateTimeToTimestampConverter;
import tma.datraining.dto.ProductDTO;
import tma.datraining.exception.BadRequestException;
import tma.datraining.exception.NotFoundDataException;
import tma.datraining.model.Product;
import tma.datraining.model.Sales;
import tma.datraining.model.cassandra.CassProduct;
import tma.datraining.service.ProductService;
import tma.datraining.service.SalesService;
import tma.datraining.service.cassandra.CassProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productSer;

	@Autowired
	private SalesService salesSer;

	@Autowired
	private CassProductService cassSer;

	@Autowired
	private DateTimeToTimestampConverter converter;

	@RequestMapping(value = { "/convert" }, method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@ResponseBody
	public List<ProductDTO> convertToProduct() {
		List<ProductDTO> list = new ArrayList<>();
		cassSer.list().forEach(e -> list.add(convertCassToDTO(e)));
		for (ProductDTO product : list) {
			productSer.save(convertProduct(product));
		}
		return list;
	}

	@GetMapping(value = "/list", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<ProductDTO> getProducts() {
		List<ProductDTO> list = convertDTOList(productSer.list());
		return list;
	}

	@GetMapping(value = "/{productId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ProductDTO getProduct(@PathVariable("productId") String productId) {
		ProductDTO pro = null;
		try {
			pro = convertProductToDTO(productSer.get(UUID.fromString(productId)));
		} catch (IllegalArgumentException e) {
			throw new NotFoundDataException("Product Id ");
		}
		return pro;

	}

	@GetMapping(value = { "/cass/{productId}" }, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public CassProduct getProductCass(@PathVariable("productId") String productId) {
		CassProduct pro = null;
		try {
			pro = productSer.getCass(UUID.fromString(productId));
		} catch (IllegalArgumentException e) {
			throw new NotFoundDataException("Product Id ");
		}

		return pro;

	}

	@GetMapping(value = { "/class/{classProduct}" }, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<ProductDTO> getProductByClass(@PathVariable("classProduct") String classProduct) {
		List<Product> pro = productSer.findByClassProduct(classProduct);
		System.out.println(pro.toString());
		System.out.println(pro);
		List<ProductDTO> pr = convertDTOList(pro);
		return pr;

	}

	@PostMapping(value = { "/add" }, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public ProductDTO addProduct(@RequestBody(required = false) ProductDTO product) throws URISyntaxException {
		if (product.getClassProduct().isEmpty() || product.getInventory().isEmpty()) {
			throw new BadRequestException("");
		}
		product.setProductId(UUID.randomUUID());
		Timestamp time = new Timestamp(System.currentTimeMillis());
		product.setCreateAt(time);
		product.setModifiedAt(time);
		Product pro = convertProduct(product);
		UUID id = productSer.save(pro);
		System.out.println("Add a new product : " + id);
		return product;

	}

	@PutMapping(value = { "/update/productId" }, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public ProductDTO updateProduct(@RequestBody ProductDTO pro, @PathVariable("productId") String productId) {
		UUID id = null;
		try {
			id = UUID.fromString(productId);
		} catch (IllegalArgumentException e) {
			throw new NotFoundDataException("Product Id");
		}
		if (pro.getItem() <= 0 || pro.getClassProduct().isEmpty() || pro.getInventory().isEmpty()) {
			throw new BadRequestException("");
		}
		if (productSer.get(id) == null) {
			throw new NotFoundDataException("Product Id ");
		}
		pro.setProductId(id);
		Timestamp time = new Timestamp(System.currentTimeMillis());
		pro.setCreateAt(productSer.get(id).getCreateAt());
		pro.setModifiedAt(time);
		Product product = convertProduct(pro);
		Set<Sales> sales = new HashSet<>();
		sales.addAll(salesSer.findByProduct(product));
		product.setSales(sales);
		productSer.update(product.getProductId(), product);
		return pro;
	}

	@DeleteMapping(value = { "/delete/{productId}" }, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public void deleteProduct(@PathVariable("productId") String productId) {
		ProductDTO pro = null;
		try {
			pro = convertProductToDTO(productSer.get(UUID.fromString(productId)));
		} catch (IllegalArgumentException e) {
			throw new NotFoundDataException("No data found!");
		}
		productSer.delete(pro.getProductId());
		System.out.println("Delete product " + productId);
	}

	
	
	// Convert--
	// Product to DTO
	public ProductDTO convertProductToDTO(Product product) {
		ProductDTO temp = new ProductDTO();
		if (product == null) {
			throw new NotFoundDataException("Product Id ");
		}
		temp.setProductId(product.getProductId());
		temp.setItem(product.getItem());
		temp.setInventory(product.getInventory());
		temp.setClassProduct(product.getClassProduct());
		temp.setCreateAt(product.getCreateAt());
		temp.setModifiedAt(product.getModifiedAt());
		return temp;
	}

	// List product to list DTO
	public List<ProductDTO> convertDTOList(List<Product> list) {
		List<ProductDTO> list2 = new ArrayList<>();
		if (list.size() == 0) {
			throw new NotFoundDataException("");
		}
		list.forEach(e -> list2.add(convertProductToDTO(e)));
		return list2;
	}

	// DTO to product
	public Product convertProduct(ProductDTO product) {
		Product pro = null;
		pro = new Product(product.getItem(), product.getClassProduct(), product.getInventory(), product.getCreateAt(),
				product.getModifiedAt());
		pro.setProductId(product.getProductId());
		return pro;
	}

	// Cass to DTO
	public ProductDTO convertCassToDTO(CassProduct product) {
		ProductDTO pro = new ProductDTO();
		if (product == null) {
			throw new NotFoundDataException("");
		}
		System.out.println(product.getProductId());
		pro.setProductId(product.getProductId());
		pro.setItem(product.getItem());
		pro.setInventory(product.getInventory());
		pro.setClassProduct(product.getClassProduct());
		pro.setCreateAt(converter.convert(product.getCreateAt()));
		pro.setModifiedAt(converter.convert(product.getModifiedAt()));
		return pro;
	}

}
