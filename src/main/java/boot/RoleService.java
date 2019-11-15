package boot;

import java.util.ArrayList;
import org.slf4j.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
  @Autowired
  private JdbcTemplate jdbc;

	private static final Logger log = LoggerFactory.getLogger(RoleService.class);

  public Role save(Role role) {
    jdbc.update("INSERT INTO role (username, role) VALUES (?, ?)", 
      role.getUsername(), role.getRole() // arguments
    );
    return role;
  }
    
  public void delete(String username, String role) {
    jdbc.update("DELETE FROM user WHERE username=? AND role=?", username, role);
  }
  
  public Iterable<Role> getRoles(String name) {
    if (name != null) {
      return jdbc.query("SELECT username, role FROM role where username=?", 
        new Object[] { name }, // arguments as array
        (rs, rowNum) -> new Role(rs.getString("username"), rs.getString("role"))); // row mapper
    } else {
      return new ArrayList<Role>();
    }
  }
}