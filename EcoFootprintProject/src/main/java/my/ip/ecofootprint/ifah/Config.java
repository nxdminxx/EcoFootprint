package my.ip.ecofootprint.ifah;

@Configuration
public class Config {

	private DriverManagerDataSource dataSource() {
		
		DriverManagerDataSource source = new DriverManagerDataSource();
		 source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		 source.setUrl("jdbc:mysql://localhost:3306/mydb");
		 source.setUsername("root");
		 source.setPassword("admin");
		 return source;
		 }
	
		 @Bean
		 JdbcTemplate jdbcTemplate() {
			 return new JdbcTemplate(dataSource());
		 }

		 
}
