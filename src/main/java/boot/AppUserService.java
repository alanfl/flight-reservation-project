package boot;

import org.slf4j.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {
  @Autowired
  private JdbcTemplate jdbc;

	private static final Logger log = LoggerFactory.getLogger(AppUserService.class);

  public AppUser save(AppUser user) {
    jdbc.update("INSERT INTO user (username, password) VALUES (?, ?)", 
      user.getUsername(), user.getPassword() // arguments
    );
    return user;
  }
    
  public AppUser get(String username) {
    return (AppUser) jdbc.queryForObject("SELECT username, password FROM user WHERE username=?", 
      new Object[] { username }, // arguments as array
      (rs, rowNum) -> new AppUser(
        rs.getString("username"), 
        rs.getString("password")
      ) // row mapper 
    );
  }

  public AppUser update(AppUser user) {
    jdbc.update("UPDATE user SET password=? WHERE username=?", 
      user.getPassword(), user.getUsername() // arguments
    );
    return user;
  }
  
  public void delete(String username) {
    jdbc.update("DELETE FROM user WHERE username=?", username);
  }
  
  public Iterable<AppUser> searchAppUsers(String[] names) {
    if (names != null) {
      return jdbc.query("SELECT username FROM user where username IN ?", 
        new Object[] { names }, // arguments as array
        (rs, rowNum) -> new AppUser(rs.getString("username"))); // row mapper
    } else {
      return jdbc.query("SELECT username FROM user",
        new Object[] {}, // arguments as array
        (rs, rowNum) -> new AppUser(rs.getString("username"))); // row mapper
    }
  }
}