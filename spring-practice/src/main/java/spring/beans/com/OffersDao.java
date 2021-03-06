package spring.beans.com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/*This class is using fully configured DataSource connection pool*/

@Component("offersDao")
public class OffersDao {

	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	// this method runs the statement for every object in the list
	@Transactional
	public int[] create(List<Offers> offer){
		// Prepared Statement, creating special parameters. Util method which return an array of objects
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offer.toArray());
		// this method returns array of int
		return jdbc.batchUpdate("insert into offers (id, name, email, text) values(:id, :name, :email, :text)", params);
	}
	
	// update an offer object in database 
	public boolean update(Offers offer){
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		return jdbc.update("update offers set name=:name, text=:text, email=:email where id=:id", params)==1;
	}
	
	public boolean create(Offers offer){
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		return jdbc.update("insert into offers (name, email, text) values(:name, :email, :text)", params)==1;
	}
	
	public boolean delete(int id){		
		MapSqlParameterSource param = new MapSqlParameterSource("id", id);
		return jdbc.update("delete from offers where id=:id",param) == 1;
	}
	
	public List<Offers> getOffers(){
		
	// creating parameter for a placeholder	
	MapSqlParameterSource param = new MapSqlParameterSource();
	param.addValue("name", "Sam");
	
		return jdbc.query("SELECT * FROM offers", new RowMapper<Offers>() {

			public Offers mapRow(ResultSet rs, int rowNum) throws SQLException {
	
				Offers offer = new Offers();
				
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));
								
				return offer;
			}			
		});			
	}
	
	public Offers getOffer(int id){
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", id);
		
			return jdbc.queryForObject("SELECT * FROM offers where id = :id",param, new RowMapper<Offers>() {

				public Offers mapRow(ResultSet rs, int rowNum) throws SQLException {
		
					Offers offer = new Offers();
					
					offer.setId(rs.getInt("id"));
					offer.setName(rs.getString("name"));
					offer.setEmail(rs.getString("email"));
					offer.setText(rs.getString("text"));
									
					return offer;
				}			
			});			
		}
}
