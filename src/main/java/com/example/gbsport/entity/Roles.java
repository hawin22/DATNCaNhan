package com.example.gbsport.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class Roles {
@Id
    private Integer id_roles;
    private String ma_roles;
    private String ten_roles;
}
