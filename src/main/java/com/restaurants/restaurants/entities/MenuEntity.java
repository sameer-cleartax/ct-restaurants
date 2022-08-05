package com.restaurants.restaurants.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.restaurants.restaurants.enums.CuisineType;
import com.restaurants.restaurants.enums.FoodType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menus")
public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "menu_name", nullable = false)
    private String menuName;

    @Column(name = "cuisine_type")
    @Enumerated(value = EnumType.STRING)
    private CuisineType cuisineType;

    @Column(name = "food_type")
    @Enumerated(value = EnumType.STRING)
    private FoodType foodType;

    @Column(name = "is_special")
    private boolean isSpecial;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "available_form")
    @CreatedDate
    private Date availableFrom;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @JsonIgnore
    private RestaurantEntity restaurant;
}
