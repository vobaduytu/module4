package com.tu.model;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "province")
@Data
public class Province {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(mappedBy = "province")
    private List<Customer> customers;

}
