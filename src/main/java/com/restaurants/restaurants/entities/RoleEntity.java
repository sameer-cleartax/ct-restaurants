package com.restaurants.restaurants.entities;

import com.restaurants.restaurants.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table( name = "roles")
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Long id;

    @Column(name = "role_name", length = 20, columnDefinition = "varchar(20)", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private RoleEnum roleName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", nullable = false)
    private List<PrivilegeEntity> privileges;
}
