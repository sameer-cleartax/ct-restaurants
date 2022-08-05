package com.restaurants.restaurants.entities;

import com.restaurants.restaurants.enums.PrivilegeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "privileges")
@NoArgsConstructor
public class PrivilegeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "privilege_id")
    private Long id;

    @Column(name = "privilege_name", length = 20, columnDefinition = "varchar(20)")
    @Enumerated(value = EnumType.STRING)
    private PrivilegeEnum privilegeName;

    public PrivilegeEntity(final PrivilegeEnum privilegeName) {
        this.privilegeName = privilegeName;
    }
}
