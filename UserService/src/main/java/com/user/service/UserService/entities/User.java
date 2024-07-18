package com.user.service.UserService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "micro-users")
public class User {
    @Id
    private String userId;
    private String userName;
    private String userEmail;
    private String userBio;
    private long userPhone;

    @Transient
    private List<Rating> ratings = new ArrayList<>();
}
