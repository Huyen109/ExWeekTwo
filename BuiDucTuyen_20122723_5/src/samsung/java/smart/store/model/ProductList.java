package samsung.java.smart.store.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class ProductList implements IProductList {
	private IProduct[] list = new Product[20];
	private int numberOfProduct;
	
	/**
	 * Reads data from the text file to an IProduct array
	 * @param filePath The String contains file path
	 */
	public ProductList(String filePath){
		Path path = Paths.get(filePath);
		numberOfProduct = 0;
		Charset cs = Charset.forName("US-ASCII");
		try(BufferedReader rd = Files.newBufferedReader(path,cs))
		{
			String line = "1:a:b", productID, productName;
			int amount;
			StringTokenizer tk;
			while((line = rd.readLine()) !=  null){
				tk = new StringTokenizer(line,":");
				productID = tk.nextToken();
				productName = tk.nextToken();
				amount = Integer.parseInt(tk.nextToken());
				list[numberOfProduct] = new Product(productID, productName, amount);
				numberOfProduct++;
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.model.IProductList#getList()
	 */
	@Override
	public IProduct[] getList(){
		return this.list;
	}
	public int getnumberOfProduct(){
		return this.numberOfProduct;
	}
}
