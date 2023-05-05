package huy.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.xdevapi.PreparableStatement;

import huy.dev.data.DAO.CategoryDAO;
import huy.dev.data.DAO.Database;
import huy.dev.data.DAO.DatabaseDAO;
import huy.dev.data.DAO.GalleryDAO;
import huy.dev.data.DAO.ProductDAO;
import huy.dev.data.driver.MySQLDriver;
import huy.dev.data.impl.CategoryImpl;
import huy.dev.data.impl.GalleryImpl;
import huy.dev.data.impl.ProductImpl;
import huy.dev.data.model.Category;
import huy.dev.data.model.Product;
import huy.dev.util.Faker;

public class MainApp {
	
	public static void main(String[] args) {
		Connection con = MySQLDriver.getInstance().getConnection();
	
		Scanner sc = new Scanner(System.in);
		//CRUD
//		CategoryDAO categoryDAO = new CategoryImpl();

//		for(int i = 1; i <= 10; i++) {
//			Category category = new Category(Faker.name(), Faker.url());
//			categoryDAO.insert(category);
//		}
		
//		ProductDAO productDAO = new ProductImpl();
//		
//		for(int i = 1; i <= 10; i++) {
//			Product product = new Product(Faker.nameProduct(), Faker.url(), Faker.numberRandom(100000, 1000000), Faker.numberRandom(100, 1000), Faker.numberRandom(301,320), null);
//			productDAO.insert(product);
//		}
		
		CategoryDAO categoryDAO = new CategoryImpl();
		List<Product> list = categoryDAO.find(312).products();
		for(int i = 0; i < list.size(); i++)
		{
			System.out.println("Cac product thuoc category 312: ");
			System.out.format("id: %d, name: %s, description: %s, price: %.2f, quantity: %d, category id: %d", 
					list.get(i).getId(),
					list.get(i).getName(),
					list.get(i).getDescription(),
					list.get(i).getPrice(),
					list.get(i).getQuantity(),
					list.get(i).getCategoryId()).println();
		}
//		CategoryDAO categoryDAO = new CategoryImpl();
//		Category category = new Category(null, null);
//		
//		String name, thumbnail;
//		System.out.println("Nhap ten loai hang: ");
//		name = sc.nextLine();
//		
//		System.out.println("Nhap thumbnail: ");
//		thumbnail = sc.nextLine();
//		
//		Category category = new Category(name, thumbnail);
//		
//		categoryDAO.insert(category);
		
//		create(con);
//		read(con);
//		update(con);
//		delete(con);
	}

	private static void delete(Connection con) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM CATEGORIES WHERE ID = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, 1);
			
//			stmt.execute();
			System.out.println(stmt.execute());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void update(Connection con) {
		// TODO Auto-generated method stub
		String sql = "UPDATE CATEGORIES SET name = ?, thumbnail = ? WHERE id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,"Ao bull");
			stmt.setString(2,"abcxyz");
			stmt.setInt(3,2);
			
			stmt.execute();
//			System.out.println(stmt.execute());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void read(Connection con) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM CATEGORIES" ;
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String thumbnail = rs.getString("thumbnail");
				System.out.format("%d - %s - %s", id, name, thumbnail).println();
			}
//			System.out.println(stmt.execute());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void create(Connection con) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO CATEGORIES VALUES(NULL, ?, ?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "Ao bull");
			stmt.setString(2, "https://google.com/asdf");
			
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
