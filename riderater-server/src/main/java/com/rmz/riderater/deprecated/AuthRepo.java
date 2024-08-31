//package com.rmz.riderater.repository;
//
//import com.rmz.riderater.model.User;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.jdbc.core.simple.JdbcClient;
//import org.springframework.stereotype.Repository;
//import org.springframework.util.Assert;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface AuthRepo extends JpaRepository<User, Integer> {
//
//    Optional<User> findByUsername(String username);
//
////    private static final Logger logger = LoggerFactory.getLogger(AttractionRepo.class);
////    private final JdbcClient jdbc;
////
////    public AuthRepo(JdbcClient jdbc) {
////        this.jdbc = jdbc;
////    }
////
////    //CREATE
////    public void createUser(User user) {
////        var updated = jdbc.sql("INSERT INTO Users(id, username, password) VALUES (?, ?, ?)")
////                .params(user.getId(), user.getUsername(), user.getPassword())
////                .update();
////
////        Assert.state(updated == 1, "Failed to create user");
////    }
////
////    //RETRIEVE
////    public List<User> getAllUsers() {
////        return jdbc.sql("SELECT * FROM Users")
////                .query(User.class)
////                .list();
////    }
////
////    public User getUserById(int id) {
////        return jdbc.sql("select * from Users where id = ?")
////                .param(id)
////                .query(User.class)
////                .single();
////    }
////
////    //UPDATE
////    public void updatePasswordByUser(String username, String password) {
////        var updated = jdbc.sql("UPDATE Users SET password = ? WHERE username = ?")
////                .param(List.of(password, username))
////                .update();
////
////        Assert.state(updated == 1, "Failed to update password");
////    }
////
////    //DELETE
//
//
//}
