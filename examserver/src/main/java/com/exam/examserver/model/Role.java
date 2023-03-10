package com.exam.examserver.model;

import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Role {
    @Id
    private Long roleId ;
    private String roleName;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "role")
    private Set<UserRole> userRoles = new HashSet<>();
}
