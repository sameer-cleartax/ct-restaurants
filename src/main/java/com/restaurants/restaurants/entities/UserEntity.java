package com.restaurants.restaurants.entities;

import com.restaurants.restaurants.contants.TableName;
import com.restaurants.restaurants.contants.UserColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name= TableName.USER_TABLE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long personId;

    @Column(name = UserColumn.NAME, length = 50, columnDefinition = "varchar(50)", nullable = false)
    private String name;

    @Column(name = UserColumn.PHONE_NUMBER, length = 10, columnDefinition = "varchar(10)", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = UserColumn.EMAIL_ID, length = 50, columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String emailId;

    @Column(name = "password", length = 256, columnDefinition = "varchar(256)", nullable = false)
    private String password;

    @CreationTimestamp
    @Column(name = UserColumn.CREATED_AT)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = UserColumn.MODIFIED_AT)
    private Instant modifiedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="role_id", referencedColumnName = "role_id")
    private RoleEntity role;
}
