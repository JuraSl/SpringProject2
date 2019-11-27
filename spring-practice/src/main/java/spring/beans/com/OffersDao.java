package spring.beans.com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

/*This class is using fully configured DataSource connection pool*/

@Component("offersDao")
public class OffersDao {

	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
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
