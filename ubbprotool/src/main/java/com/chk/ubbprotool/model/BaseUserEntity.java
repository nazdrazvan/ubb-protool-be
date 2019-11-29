package com.chk.ubbprotool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BaseUser")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseUserEntity {
    public static final String ID_COLUMN = "baseuser_id";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";

    @Id
    @Column(name=ID_COLUMN)
    private Long id;

    @Column(name=FIRST_NAME)
    private String first_name;

    @Column(name=LAST_NAME)
    private String last_name;

    @Column(name=EMAIL)
    private String email;

    @Column(name=PASSWORD)
    private String password;

}
