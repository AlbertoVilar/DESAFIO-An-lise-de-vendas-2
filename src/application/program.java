package application;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import entitites.Sale;

public class program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Entre o caminho do arquivo: ");
		String path = sc.next();

	
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			 List<Sale> list = new ArrayList<>();

			String line = br.readLine();
			System.out.println();
			while (line != null) {

				String[] field = line.split(",");
				Integer month = Integer.parseInt(field[0]);
				Integer year = Integer.parseInt(field[1]);
				String seller = field[2];
				Integer items = Integer.parseInt(field[3]);
				Double total = Double.parseDouble(field[4]);

					list.add(new Sale(month, year, seller, items, total));	

				line = br.readLine();
			}
			
			System.out.println("Total de vendas por vendedor:");
			System.out.println();
			
			
			System.out.println("==============================================");
						

			Map<String, Double> sellers = new HashMap();
			
		     sellers = list.stream()
		     		  .collect(Collectors.groupingBy(

		     				  Sale :: getSeller,
		     				  Collectors.summingDouble(Sale :: getTotal)
		     				  )
		     				  );
		     
		     sellers.forEach((k, v) -> System.out.printf("%s: R$ %s\n", k, v));
		    		 
		    	
			}
			catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}

	}

}
