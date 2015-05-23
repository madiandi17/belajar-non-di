package com.wordpress.bmadi.belajar.non.di.dao;

import com.wordpress.bmadi.belajar.non.di.model.Produk;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

public class ProdukDao {
    
    private BasicDataSource dataSource;
    
    public ProdukDao() throws Exception {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/belajar");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");
    }
    
    public void create(Produk p) throws SQLException{
        String sql = "insert into produk(kode, nama, harga)values(?, ?, ?)";
        
        Connection dataConnection = dataSource.getConnection();
        PreparedStatement ps = dataConnection.prepareStatement(sql);
        ps.setString(1, p.getKode());
        ps.setString(2, p.getNama());
        ps.setBigDecimal(3, p.getHarga());
        ps.executeUpdate();
        
        dataConnection.close();
    }
    
    public void read(Produk p) throws SQLException{
        String sql = "select * from produk";
        
        Connection dataConnection = dataSource.getConnection();
        PreparedStatement ps = dataConnection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.println("id : " + rs.getInt("id"));
            System.out.println("kode : " + rs.getString("kode"));
            System.out.println("nama : " + rs.getString("nama"));
            System.out.println("harga : " + rs.getBigDecimal("harga"));
        }
        dataConnection.close();
    }
    
    public Produk cariById(Integer id) throws Exception{
        String sql = "select * from produk where id=?";
        
        Connection dbConnection = dataSource.getConnection();
        PreparedStatement ps = dbConnection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.println("id : " + rs.getInt("id"));
            System.out.println("kode : " + rs.getString("kode"));
            System.out.println("nama : " + rs.getString("nama"));
            System.out.println("harga : " + rs.getBigDecimal("harga"));
        }
        dbConnection.close();
        return null;
    }
    
    public Produk cariByNama(String nama) throws Exception{
        String sql = "select * from produk where nama like ? order by nama";
        
        Connection dbConnection = dataSource.getConnection();
        PreparedStatement ps = dbConnection.prepareStatement(sql);
        ps.setString(1, "%" + nama + "%");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.println("id : " + rs.getInt("id"));
            System.out.println("kode : " + rs.getString("kode"));
            System.out.println("nama : " + rs.getString("nama"));
            System.out.println("harga : " + rs.getBigDecimal("harga"));
        }
        dbConnection.close();
        return null;
    }
    public void update(Produk p)throws Exception{
        String sql = "update produk set kode=?, nama=?, harga=? where id=?";
        
        Connection dbConnection = dataSource.getConnection();
        PreparedStatement ps = dbConnection.prepareStatement(sql);
        ps.setString(1, p.getKode());
        ps.setString(2, p.getNama());
        ps.setBigDecimal(3, p.getHarga());
        ps.setInt(4, p.getId());
        ps.executeUpdate();
        
        dbConnection.close();
    }
    
    public void delete(Produk p) throws Exception{
        String sql = "delete from produk where id=?";
        
        Connection dbConnection = dataSource.getConnection();
        PreparedStatement ps = dbConnection.prepareStatement(sql);
        ps.setInt(1, p.getId());
        ps.executeUpdate();
        
        dbConnection.close();
    }
}
